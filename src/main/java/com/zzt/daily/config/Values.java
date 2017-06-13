package com.zzt.daily.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Created by zhaotao on 2017/6/13.
 */
@Component
public class Values {

    @Value("${url_static}")
    public String url_static;
}
