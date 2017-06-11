package com.gechuangms.app;

import android.Manifest;

import com.gechuangms.model.GCUser;

/**
 * Created by Ezra on 2017/5/29.
 */

public class Config {

    public static  GCUser CURRENT_USER = null;

    public static  boolean LOGIN_STATE = false;

    public static final String DEFAULT_ICON_URL = "http://imgsrc.baidu.com/forum/w%3D580/sign=62018d439ddda144da096cba82b6d009/e7ad9825bc315c605a7e42bf87b1cb134854774d.jpg";

    public static final String VIDEO_URL = "http://tb-video.bdstatic.com/tieba-smallvideo-transcode/215467594_d38d889b28026afde5dccd4745ed29e3_f0b1a4d2_1.mp4?authorization=bce-auth-v1%2Fde94045c2e42438fad71ab8df47a6727%2F2017-06-10T12%3A47%3A01Z%2F1800%2F%2F4376bebb266d2f32ed7a14fc730384a8150ae509ac7bf8b03119cae720a68627";

    public static final int USER_GROUP_MEMBER = 1;
    public static final int USER_GROUP_OFFICER = 2;
    public static final int USER_ALL = 3;

    public static final String MESSAGE_TYPE = "type";
    public static final String MESSAGE_TYPE_ACTIVITY = "activity";
    public static final String MESSAGE_TYPE_INFORM = "inform";
    public static final String MESSAGE_TYPE_NEWS = "news";

    public static final int DELAY = 2000;

    public static final String BMOB_KEY = "bdfef151721a4fee3ccaf3e8bfba0bdb";

    public static final String[] GCMS_PERMISSION = {
            Manifest.permission.READ_CONTACTS,
            Manifest.permission.CALL_PHONE,
            Manifest.permission.READ_PHONE_STATE,
            Manifest.permission.WRITE_EXTERNAL_STORAGE
    };

    public static final int REQUEST_PERMISSION = 1;

    public static final String MESSAGE = "message";
    public static final String PRIZE = "prize";
    public static final String JOIN = "join";

}
