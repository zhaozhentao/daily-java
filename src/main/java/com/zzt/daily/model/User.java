package com.zzt.daily.model;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by zhaotao on 2017/6/21.
 */
@Getter
@Setter
public class User {

    public int id;

    public String name;

    public int github_id;

    public String github_name;

    public String image_url;

    public String avatar;

    public String password;

    @Override
    public String toString() {
        return "User{" +
            "id=" + id +
            ", name='" + name + '\'' +
            ", github_name='" + github_name + '\'' +
            ", image_url='" + image_url + '\'' +
            ", avatar='" + avatar + '\'' +
            ", password='" + password + '\'' +
            '}';
    }
}
