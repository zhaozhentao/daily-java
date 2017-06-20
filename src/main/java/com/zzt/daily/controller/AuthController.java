package com.zzt.daily.controller;

import com.zzt.daily.OAuth.GithubOAuthService;
import org.scribe.model.Token;
import org.scribe.model.Verifier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by zhaotao on 2017/6/20.
 */
@Controller
public class AuthController {

    @Value("${oAuth.github.clientId}")
    String githubClientId;

    @Value("${oAuth.github.state}")
    String state;

    @Autowired
    GithubOAuthService githubOAuthService;

    @GetMapping("/auth/oauth")
    public String oauthLogin() {
        return "redirect:https://github.com/login/oauth/authorize?client_id=" + githubClientId +
            "&redirect_uri=http%3A%2F%2Flocalhost%3A8080%2Foauth%2Fgithub%2Fcallback&state=" + state;
    }

    @RequestMapping(value = "/oauth/github/callback", method = RequestMethod.GET)
    public String callback(@RequestParam(value = "code") String code) {
        Token accessToken = githubOAuthService.getAccessToken(null, new Verifier(code));
        githubOAuthService.getOAuthUser(accessToken);
        return "index";
    }
}
