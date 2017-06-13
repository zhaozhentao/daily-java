package com.zzt.daily.view;

import com.zzt.daily.config.Values;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by zhaotao on 2017/6/13.
 */
@Component
public class ViewHelper {

    @Autowired
    private Values values;

    public String cdn(String cdn) {
        return values.url_static;
    }
}
