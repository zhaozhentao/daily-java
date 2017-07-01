package com.zzt.daily.service;

import com.zzt.daily.auth.JwtToken;
import com.zzt.daily.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

/**
 * Created by zhaotao on 2017/5/24.
 */

@Service
public class AuthService {

    @Value("${encode.secret}")
    String secret;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtToken jwtToken;

    public String login(User user) {
        UsernamePasswordAuthenticationToken upToken = new UsernamePasswordAuthenticationToken(user.name, user.password);
        SecurityContextHolder.getContext().setAuthentication(authenticationManager.authenticate(upToken));
        return jwtToken.generateToken(user.getName());
    }
}
