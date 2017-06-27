package com.zzt.daily.service;

import com.zzt.daily.mapper.User;
import com.zzt.daily.mapper.UserMapper;
import com.zzt.daily.requests.StoreUserRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.StandardPasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * Created by zhaotao on 2017/6/21.
 */
@Service
public class UserService {

    @Value("${encode.secret}")
    String secret;

    @Autowired
    UserMapper userMapper;

    public User getByDriver(String driver, long id) {
        User user = null;
        switch (driver) {
            case "github":
                user = userMapper.getByGithubId(id);
                break;
        }
        return user;
    }

    public int create(StoreUserRequest request) {
        StandardPasswordEncoder encoder = new StandardPasswordEncoder(secret);
        request.password = encoder.encode(request.password);
        return userMapper.create(request);
    }
}
