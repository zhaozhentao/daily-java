package com.zzt.daily.requests;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 * Created by zhaotao on 2017/6/24.
 */
@Getter
@Setter
public class StoreBlogRequest {

    @NotNull
    public String title;

    @NotNull
    public String body;
}
