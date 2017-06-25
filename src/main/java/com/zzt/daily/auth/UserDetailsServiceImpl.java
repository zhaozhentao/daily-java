package com.zzt.daily.auth;

import com.zzt.daily.mapper.User;
import com.zzt.daily.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * Created by zhaotao on 2017/5/24.
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    UserMapper userMapper;

    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
        User user = userMapper.findByName(name);

        if (user == null) {
            throw new UsernameNotFoundException(String.format("No user found with username '%s'.", name));
        } else {
            return JwtUserFactory.create(user);
        }
    }
}
