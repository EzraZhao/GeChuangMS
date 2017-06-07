package com.gechuangms.model;

import cn.bmob.v3.BmobObject;

/**
 * 我参与的
 * Created by Ezra on 2017/6/5.
 */

public class GCMine extends BmobObject {

    private GCUser user;
    private GCMessage message;
    private String conmment;

    public GCUser getUser() {
        return user;
    }

    public void setUser(GCUser user) {
        this.user = user;
    }

    public GCMessage getMessage() {
        return message;
    }

    public void setMessage(GCMessage message) {
        this.message = message;
    }

    public String getConmment() {
        return conmment;
    }

    public void setConmment(String conmment) {
        this.conmment = conmment;
    }
}
