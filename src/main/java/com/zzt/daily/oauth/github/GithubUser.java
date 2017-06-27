package com.zzt.daily.oauth.github;

/**
 * Created by zhaotao on 2017/6/21.
 */
public class GithubUser {

    /**
     * login : zhaozhentao
     * id : 10723969
     * avatar_url : https://avatars3.githubusercontent.com/u/10723969?v=3
     * gravatar_id :
     * url : https://api.github.com/users/zhaozhentao
     * html_url : https://github.com/zhaozhentao
     * followers_url : https://api.github.com/users/zhaozhentao/followers
     * following_url : https://api.github.com/users/zhaozhentao/following{/other_user}
     * gists_url : https://api.github.com/users/zhaozhentao/gists{/gist_id}
     * starred_url : https://api.github.com/users/zhaozhentao/starred{/owner}{/repo}
     * subscriptions_url : https://api.github.com/users/zhaozhentao/subscriptions
     * organizations_url : https://api.github.com/users/zhaozhentao/orgs
     * repos_url : https://api.github.com/users/zhaozhentao/repos
     * events_url : https://api.github.com/users/zhaozhentao/events{/privacy}
     * received_events_url : https://api.github.com/users/zhaozhentao/received_events
     * type : User
     * site_admin : false
     * name : 涛
     * company : null
     * blog :
     * location : Foshan,China
     * email : 514656282@qq.com
     * hireable : null
     * bio : null
     * public_repos : 22
     * public_gists : 0
     * followers : 207
     * following : 23
     * created_at : 2015-01-27T11:04:04Z
     * updated_at : 2017-06-20T15:34:12Z
     */

    public String login;
    public long id;
    public String avatar_url;
    public String gravatar_id;
    public String url;
    public String html_url;
    public String followers_url;
    public String following_url;
    public String gists_url;
    public String starred_url;
    public String subscriptions_url;
    public String organizations_url;
    public String repos_url;
    public String events_url;
    public String received_events_url;
    public String type;
    public boolean site_admin;
    public String name;
    public String company;
    public String blog;
    public String location;
    public String email;
    public String hireable;
    public String bio;
    public int public_repos;
    public int public_gists;
    public int followers;
    public int following;
    public String created_at;
    public String updated_at;

    @Override
    public String toString() {
        return "GithubUser{" +
            "login='" + login + '\'' +
            ", id=" + id +
            ", avatar_url='" + avatar_url + '\'' +
            ", gravatar_id='" + gravatar_id + '\'' +
            ", url='" + url + '\'' +
            ", html_url='" + html_url + '\'' +
            ", followers_url='" + followers_url + '\'' +
            ", following_url='" + following_url + '\'' +
            ", gists_url='" + gists_url + '\'' +
            ", starred_url='" + starred_url + '\'' +
            ", subscriptions_url='" + subscriptions_url + '\'' +
            ", organizations_url='" + organizations_url + '\'' +
            ", repos_url='" + repos_url + '\'' +
            ", events_url='" + events_url + '\'' +
            ", received_events_url='" + received_events_url + '\'' +
            ", type='" + type + '\'' +
            ", site_admin=" + site_admin +
            ", name='" + name + '\'' +
            ", company=" + company +
            ", blog='" + blog + '\'' +
            ", location='" + location + '\'' +
            ", email='" + email + '\'' +
            ", hireable=" + hireable +
            ", bio=" + bio +
            ", public_repos=" + public_repos +
            ", public_gists=" + public_gists +
            ", followers=" + followers +
            ", following=" + following +
            ", created_at='" + created_at + '\'' +
            ", updated_at='" + updated_at + '\'' +
            '}';
    }
}
