package com.zzt.daily.service;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

/**
 * Created by zhaotao on 2017/6/20.
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String userName)
        throws UsernameNotFoundException {
        ArrayList list = new ArrayList();
        list.add(new SimpleGrantedAuthority("ROLE_USER"));
        User details = new User("rod", "koala", list);
        return details;
    }

}

