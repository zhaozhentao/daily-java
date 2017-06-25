package com.zzt.daily.mapper;

import com.zzt.daily.requests.StoreUserRequest;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

/**
 * Created by zhaotao on 2017/6/21.
 */
@Component
public interface UserMapper {

    User findById(@Param("id") int id);

    User findByName(@Param("name") String name);

    User getByGithubId(@Param("github_id") int githubId);

    int create(@Param("request") StoreUserRequest request);
}
