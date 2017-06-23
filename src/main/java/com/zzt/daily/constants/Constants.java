package com.zzt.daily.constants;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Created by zhaotao on 2017/6/21.
 */

@Component
public class Constants {

    @Value("${oAuth.github.clientId}")
    String githubClientId;

    @Value("${oAuth.github.state}")
    String state;

    @Value("${font_end_url}")
    String fontEndUrl;

    public String GithubRedirectUrl() {
        return "redirect:https://github.com/login/oauth/authorize?client_id=" + githubClientId +
            "&redirect_uri=http%3A%2F%2Flocalhost%3A8080%2Foauth%2Fgithub%2Fcallback&state=" + state;
    }

    public String signupUrl() {
        return "redirect:" + fontEndUrl + "/signup";
    }
}
