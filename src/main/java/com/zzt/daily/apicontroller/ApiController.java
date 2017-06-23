package com.zzt.daily.apicontroller;

import com.zzt.daily.mapper.User;
import com.zzt.daily.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by zhaotao on 2017/6/12.
 */
@RestController
@RequestMapping(value = "/api")
public class ApiController {

    @Autowired
    private UserMapper userMapper;

    @GetMapping("/my")
    public String home() {
        User u = userMapper.findByName("suyingwen");
        return u.toString();
    }

    @PostMapping("/signup")
    public String signup() {
        return "ok";
    }

}
