package com.gechuangms.model;

import java.io.Serializable;

import cn.bmob.v3.BmobObject;

/**
 * Created by Ezra on 2017/6/9.
 */

public class GCPrize extends BmobObject implements Serializable {

    //获奖简述，如发现杯
    private String info;

    private String desc;

    private String imageUrl;

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
