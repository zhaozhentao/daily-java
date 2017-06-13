package com.zzt.daily.apicontroller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by zhaotao on 2017/6/12.
 */
@RestController
@RequestMapping(value = "/api")
public class ApiController {

    @GetMapping("/my")
    public String home() {
        return "haha";
    }
}
