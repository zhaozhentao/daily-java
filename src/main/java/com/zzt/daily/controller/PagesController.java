package com.zzt.daily.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by zhaotao on 2017/6/12.
 */
@Controller
public class PagesController {

    @GetMapping("/")
    public String home() {
        return "pages/index";
    }
}
