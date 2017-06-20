package com.zzt.daily.mapper;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by zhaotao on 2017/6/21.
 */
@Getter
@Setter
public class User {
    private Long id;
    private String name;

    @Override
    public String toString() {
        return "User{" +
            "id=" + id +
            ", name='" + name + '\'' +
            '}';
    }
}
