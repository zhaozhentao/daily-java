package com.zzt.daily.controller;

import com.zzt.daily.oauth.github.GithubOAuthService;
import com.zzt.daily.oauth.github.GithubUser;
import com.zzt.daily.constants.Constants;
import com.zzt.daily.model.User;
import com.zzt.daily.requests.StoreUserRequest;
import com.zzt.daily.service.AuthService;
import com.zzt.daily.service.UserService;
import org.scribe.model.Token;
import org.scribe.model.Verifier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

/**
 * Created by zhaotao on 2017/6/20.
 */
@Controller
public class AuthController {

    @Value("${domain}")
    String domain;

    @Autowired
    Constants constants;

    @Autowired
    GithubOAuthService githubOAuthService;

    @Autowired
    UserService userService;

    @Autowired
    AuthService authService;

    @Value("${jwt.expiration}")
    int expiration;

    @GetMapping("/api/auth/oauth")
    public String oauthLogin() {
        return constants.GithubRedirectUrl();
    }

    @GetMapping("/api/oauth/github/callback")
    public ModelAndView callback(@RequestParam(value = "code") String code, HttpServletResponse response) {
        Token accessToken = githubOAuthService.getAccessToken(null, new Verifier(code));
        GithubUser githubUser = githubOAuthService.getOAuthUser(accessToken);
        User user = userService.getByDriver("github", githubUser.id);

        if (user == null) {
            return userNotFound(githubUser);
        } else {
            return userFounded(user, response);
        }
    }

    private ModelAndView userFounded(User user, HttpServletResponse response) {
        ModelAndView modelAndView = new ModelAndView(constants.homeUrl());
        Cookie cookie = new Cookie("token", authService.login(user));
        cookie.setMaxAge(expiration);
        cookie.setDomain(domain);
        cookie.setPath("/");
        response.addCookie(cookie);
        return modelAndView;
    }

    private ModelAndView userNotFound(GithubUser githubUser) {
        ModelAndView modelAndView = new ModelAndView(constants.signupUrl());
        modelAndView.addObject("image_url", githubUser.avatar_url);
        modelAndView.addObject("github_id", githubUser.id);
        modelAndView.addObject("github_url", githubUser.url);
        modelAndView.addObject("github_name", githubUser.login);
        modelAndView.addObject("name", githubUser.name);
        modelAndView.addObject("email", githubUser.email);
        return modelAndView;
    }

    @ResponseBody
    @PostMapping("/api/signup")
    public Object store(@RequestBody @Valid StoreUserRequest request, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseEntity.status(400).body(bindingResult.getAllErrors().get(0));
        }

        if (userService.create(request) > 0) {
            User user = userService.getByDriver("github", request.github_id);
            return authService.login(user);
        } else {
            return ResponseEntity.badRequest().body("创建用户失败");
        }
    }
}
