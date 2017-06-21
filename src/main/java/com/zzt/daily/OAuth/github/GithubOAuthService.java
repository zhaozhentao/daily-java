package com.zzt.daily.OAuth.github;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.zzt.daily.OAuth.OAuthServiceDeractor;
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
    public GithubUser getOAuthUser(Token accessToken) {
        OAuthRequest request = new OAuthRequest(Verb.GET, PROTECTED_RESOURCE_URL);
        this.signRequest(accessToken, request);
        Response response = request.send();
        String body = response.getBody();
        return new Gson().fromJson(body, new TypeToken<GithubUser>() {
        }.getType());
    }
}
