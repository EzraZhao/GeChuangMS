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

    public static final int USER_GROUP_MEMBER = 1;
    public static final int USER_GROUP_OFFICER = 2;
    public static final int USER_ALL = 3;

    public static final int DELAY = 2000;

    public static final String BMOB_KEY = "bdfef151721a4fee3ccaf3e8bfba0bdb";

    public static final String[] GCMS_PERMISSION = {
            Manifest.permission.READ_CONTACTS,
            Manifest.permission.CALL_PHONE,
            Manifest.permission.READ_PHONE_STATE,
            Manifest.permission.WRITE_EXTERNAL_STORAGE
    };

    public static final int REQUEST_PERMISSION = 1;

    public static final String MESSAGE_TITLE = "messageTitle";
}
