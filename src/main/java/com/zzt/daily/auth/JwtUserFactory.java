package com.zzt.daily.auth;

import com.zzt.daily.mapper.User;

public final class JwtUserFactory {

    private JwtUserFactory() {

    }

    public static JwtUser create(User user) {
        return new JwtUser(user.getId(), user.getName(), user.getPassword(), user.getGithub_id());
    }
}

