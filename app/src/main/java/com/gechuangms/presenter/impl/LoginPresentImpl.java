package com.gechuangms.presenter.impl;

import com.gechuangms.app.Config;
import com.gechuangms.model.GCUser;
import com.gechuangms.presenter.ILoginPresent;
import com.gechuangms.util.StringUtils;
import com.gechuangms.view.ILoginView;

import java.util.ArrayList;
import java.util.List;

import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.SaveListener;

/**
 * Created by Ezra on 2017/5/29.
 */

public class LoginPresentImpl implements ILoginPresent {

    private static final String TAG = "LoginPresentImpl";

    private ILoginView mILoginView;
    private List<GCUser> mGCUsers;

    public LoginPresentImpl(ILoginView mILoginView) {
        this.mILoginView = mILoginView;
        mGCUsers = new ArrayList<>();
    }

    @Override
    public void login(String userName, String password) {
        if (StringUtils.checkUserName(userName)) {
            if (StringUtils.checkPassword(password)) {
                mILoginView.onStartLogin();
                startLogin(userName, password);
            } else {
                mILoginView.onPasswordError();
            }
        } else {
            mILoginView.onUserNameError();
        }
    }

    private void startLogin(String userName, String password) {
        GCUser gcUser = new GCUser();
        gcUser.setUsername(userName);
        gcUser.setPassword(password);
        gcUser.login(new SaveListener<GCUser>() {

            @Override
            public void done(GCUser gcUser, BmobException e) {
                if (e == null) {
                    Config.CURRENT_USER = gcUser;
                    Config.LOGIN_STATE = true;
                    mILoginView.onLoginSuccess();
                } else {
                    mILoginView.onLoginFail();
                }
            }
        });
    }
}

