package com.zzt.daily.apicontroller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by zhaotao on 2017/6/19.
 */
@RestController
public class UsersController {

    @RequestMapping({"/user", "/me"})
    public Map<String, String> user(Principal principal) {
        System.out.println(principal.toString() + "\n\n\n\n\n\n\n\n\n\n");
        Map<String, String> map = new LinkedHashMap<>();
        map.put("name", principal.getName());
        return map;
    }
}
