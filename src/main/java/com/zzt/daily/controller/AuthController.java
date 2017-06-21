package com.zzt.daily.controller;

import com.zzt.daily.OAuth.github.GithubOAuthService;
import com.zzt.daily.OAuth.github.GithubUser;
import com.zzt.daily.constants.Constants;
import com.zzt.daily.mapper.User;
import com.zzt.daily.service.UserService;
import org.scribe.model.Token;
import org.scribe.model.Verifier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

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

    @RequestMapping(value = "/oauth/github/callback", method = RequestMethod.GET)
    public ModelAndView callback(@RequestParam(value = "code") String code) {
        Token accessToken = githubOAuthService.getAccessToken(null, new Verifier(code));
        GithubUser githubUser = githubOAuthService.getOAuthUser(accessToken);
        User user = userService.getByDriver("github", githubUser.id);

        if (user == null) {
            return userNotFound(githubUser);
        } else {
            return null;
        }
    }

    private ModelAndView userNotFound(GithubUser githubUser) {
        ModelAndView modelAndView = new ModelAndView(constants.signupUrl());
        modelAndView.addObject("image_url", githubUser.avatar_url);
        modelAndView.addObject("github_id", githubUser.id);
        modelAndView.addObject("github_url", githubUser.url);
        modelAndView.addObject("github_name", githubUser.name);
        modelAndView.addObject("name", githubUser.name);
        modelAndView.addObject("email", githubUser.email);
        return modelAndView;
    }
}
