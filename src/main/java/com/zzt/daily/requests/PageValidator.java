package com.zzt.daily.requests;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by zhaotao on 2017/6/5.
 */
@Getter
@Setter
public class PageValidator {

    public int page = 0;

    public int perPage = 10;

    public int getOffset() {
        return page * perPage;
    }
}
