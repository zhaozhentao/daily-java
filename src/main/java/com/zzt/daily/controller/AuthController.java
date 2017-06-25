package com.zzt.daily.controller;

import com.zzt.daily.OAuth.github.GithubOAuthService;
import com.zzt.daily.OAuth.github.GithubUser;
import com.zzt.daily.constants.Constants;
import com.zzt.daily.mapper.User;
import com.zzt.daily.requests.StoreUserRequest;
import com.zzt.daily.service.UserService;
import org.scribe.model.Token;
import org.scribe.model.Verifier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.IOException;
import java.util.HashMap;

/**
 * Created by zhaotao on 2017/6/20.
 */
@Controller
public class AuthController {

    @Autowired
    Constants constants;

    @Autowired
    GithubOAuthService githubOAuthService;

    @Autowired
    UserService userService;

    @GetMapping("/auth/oauth")
    public String oauthLogin() {
        return constants.GithubRedirectUrl();
    }

    @GetMapping("/oauth/github/callback")
    public ModelAndView callback(@RequestParam(value = "code") String code, HttpServletResponse response) {
        Token accessToken = githubOAuthService.getAccessToken(null, new Verifier(code));
        GithubUser githubUser = githubOAuthService.getOAuthUser(accessToken);
        User user = userService.getByDriver("github", githubUser.id);

        if (user == null) {
            return userNotFound(githubUser);
        } else {
            Cookie cookie = new Cookie("cookie1", "value1");
            System.out.println("set setset");
            cookie.setMaxAge(1000000);
            cookie.setPath("/");
            cookie.setSecure(false);
            cookie.setDomain("xiaotaotao.me");
            response.addCookie(cookie);
            return userFounded(user);
        }
    }

    private ModelAndView userFounded(User user) {
        ModelAndView modelAndView = new ModelAndView(constants.homeUrl());
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

        return userService.create(request);
    }
}
