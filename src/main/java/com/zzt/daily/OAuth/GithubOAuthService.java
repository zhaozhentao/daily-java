package com.zzt.daily.OAuth;

import org.scribe.model.OAuthRequest;
import org.scribe.model.Response;
import org.scribe.model.Token;
import org.scribe.model.Verb;
import org.scribe.oauth.OAuthService;

public class GithubOAuthService extends OAuthServiceDeractor {
    
    private static final String PROTECTED_RESOURCE_URL = "https://api.github.com/user";

    public GithubOAuthService(OAuthService oAuthService) {
        super(oAuthService, "github");
    }

    @Override
    public String getOAuthUser(Token accessToken) {
        OAuthRequest request = new OAuthRequest(Verb.GET, PROTECTED_RESOURCE_URL);
        this.signRequest(accessToken, request);
        Response response = request.send();

        System.out.println(response.getBody());
//
//        OAuthUser oAuthUser = new OAuthUser();
//        oAuthUser.setoAuthType(getoAuthType());
//        Object result = JSON.parse(response.getBody());
//        oAuthUser.setoAuthId(JSONPath.eval(result, "$.id").toString());
//        oAuthUser.setUser(new User());
//        oAuthUser.getUser().setUsername(JSONPath.eval(result, "$.login").toString());
        return response.getBody();
    }
}
