package com.zzt.daily.auth;

import com.zzt.daily.model.User;

public final class JwtUserFactory {

    private JwtUserFactory() {

    }

    public static JwtUser create(User user) {
        return new JwtUser(user);
    }
}

