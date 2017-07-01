package com.zzt.daily.model;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * Created by zhaotao on 2017/6/21.
 */
@Getter
@Setter
public class Blog {

    public int id;

    public String title;

    public String source;

    public String body;

    public int user_id;

    public int category_id;

    public int reply_count;

    public int view_count;

    public int vote_count;

    public int last_reply_user_id;

    public int order;

    public bool is_excellent;

    public bool is_blocked;

    public String body_original;

    public String excerpt;

    public bool is_tagged;

    public Date deleted_at;

    public Date created_at;

    public Date updated_at;

    public enum bool {
        yes, no;
    }
}
