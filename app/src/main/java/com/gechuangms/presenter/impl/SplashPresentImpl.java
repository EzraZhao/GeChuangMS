package com.gechuangms.presenter.impl;

import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.v4.app.ActivityCompat;

import com.gechuangms.app.Config;
import com.gechuangms.model.GCToken;
import com.gechuangms.presenter.ISplashPresent;
import com.gechuangms.view.ISplashView;

import org.litepal.crud.DataSupport;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ezra on 2017/6/4.
 */

public class SplashPresentImpl implements ISplashPresent {

    private static final String TAG = "SplashPresentImpl";

    private ISplashView mISplashView;

    private Activity mActivity;

    public SplashPresentImpl(Activity mActivity, ISplashView mISplashView) {
        this.mActivity = mActivity;
        this.mISplashView = mISplashView;
    }

    @Override
    public void checkLoginStatus() {
        List<GCToken> tokens = DataSupport.findAll(GCToken.class);
        if (tokens.get(0).isToken()) {
            mISplashView.onLoggedIn();
        } else {
            mISplashView.onNotLogin();
        }
    }

    @Override
    public void requestPermissions() {
        if (Build.VERSION.SDK_INT < 23) {
            checkLoginStatus();
        } else {
            String[] needRequestPermissionList = checkPermissions(mActivity, Config.GCMS_PERMISSION);
            if (needRequestPermissionList.length > 0) {
                requestGCMSPermissions(needRequestPermissionList);
            } else {
                //检查是否登录
                checkLoginStatus();
            }
        }
    }

    private void requestGCMSPermissions(String[] needRequestPermissionList) {
        ActivityCompat.requestPermissions(mActivity, needRequestPermissionList, Config.REQUEST_PERMISSION);
    }

    private String[] checkPermissions(Context context, String[] gcmsPermission) {
        List<String> needRequestPermissionList = new ArrayList<>();
        for (String permission : needRequestPermissionList) {
            //如果应用具有此权限，方法将返回 PackageManager.PERMISSION_GRANTED，并且应用可以继续操作。
            // 如果应用不具有此权限，方法将返回 PERMISSION_DENIED，且应用必须明确向用户要求权限
            if (android.support.v4.app.ActivityCompat.checkSelfPermission(context, permission) != PackageManager.PERMISSION_GRANTED) {
                needRequestPermissionList.add(permission);
            }
        }
        String[] needRequestPermissionArray = new String[needRequestPermissionList.size()];
        return needRequestPermissionList.toArray(needRequestPermissionArray);
    }
}
