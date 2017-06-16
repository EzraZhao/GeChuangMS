package com.gechuangms.model;

import cn.bmob.v3.BmobObject;
import cn.bmob.v3.datatype.BmobRelation;

/**
 * Created by Ezra on 2017/6/16.
 */

public class GCFeedback extends BmobObject {

    private BmobRelation user;

    private String feedback;

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    public BmobRelation getUser() {
        return user;
    }

    public void setUser(BmobRelation user) {
        this.user = user;
    }
}
