package com.zzt.daily.mapper;

import com.zzt.daily.model.Blog;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

/**
 * Created by zhaotao on 2017/6/21.
 */
@Component
public interface BlogMapper {

    int create(@Param("blog") Blog blog);

    Blog findById(@Param("id") int id);
}
