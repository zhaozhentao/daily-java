package com.zzt.daily.mapper;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;
/**
 * Created by zhaotao on 2017/6/21.
 */
@Component
public interface UserMapper {

    User findByName(@Param("name") String name);
}
