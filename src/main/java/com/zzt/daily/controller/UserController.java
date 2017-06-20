package com.zzt.daily.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by zhaotao on 2017/6/19.
 */
@Controller
public class UserController {

    @GetMapping(value = "/hello")
    public String index() {
        System.out.println("hello\n\n\n\n\n\n\n\n");
        return "index";
    }
}
