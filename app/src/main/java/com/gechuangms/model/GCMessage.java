package com.gechuangms.model;

import java.io.Serializable;

import cn.bmob.v3.BmobObject;
import cn.bmob.v3.datatype.BmobRelation;

/**
 * 相关活动推送
 * Created by Ezra on 2017/5/31.
 */

public class GCMessage extends BmobObject implements Serializable {

    private String title;
    private String content;
    private String imageUrl;
    private Integer group;
    private String type;
    private BmobRelation join;
    private BmobRelation comment;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public int getGroup() {
        return group;
    }

    public void setGroup(int group) {
        this.group = group;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public BmobRelation getJoin() {
        return join;
    }

    public void setJoin(BmobRelation join) {
        this.join = join;
    }

    public BmobRelation getComment() {
        return comment;
    }

    public void setComment(BmobRelation comment) {
        this.comment = comment;
    }
}
