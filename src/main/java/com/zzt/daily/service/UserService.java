package com.zzt.daily.service;

import com.zzt.daily.mapper.User;
import com.zzt.daily.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by zhaotao on 2017/6/21.
 */
@Service
public class UserService {

    @Autowired
    UserMapper userMapper;

    public User getByDriver(String driver, int id) {
        User user = null;
        switch (driver) {
            case "github":
                user = userMapper.getByGithubId(id);
                break;
        }
        return user;
    }
}
