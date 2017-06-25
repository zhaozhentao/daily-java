package com.zzt.daily.controller.apicontroller;

import com.zzt.daily.auth.JwtUser;
import com.zzt.daily.mapper.User;
import com.zzt.daily.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by zhaotao on 2017/6/12.
 */
@RestController
@RequestMapping(value = "/api")
public class UserController {

    @Autowired
    private UserMapper userMapper;

    @GetMapping("/user")
    public String show(HttpServletRequest request) {
//        JwtUser userDetails = (JwtUser) request.getAttribute("loginUser");
//        return userDetails.getUser();
        return "ok";
    }
}
