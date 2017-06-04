package com.gechuangms.presenter.impl;

import com.gechuangms.app.Config;
import com.gechuangms.model.GCToken;
import com.gechuangms.model.GCUser;
import com.gechuangms.presenter.ILoginPresent;
import com.gechuangms.util.StringUtils;
import com.gechuangms.view.ILoginView;

import org.litepal.crud.DataSupport;

import java.util.ArrayList;
import java.util.List;

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
        mGCUsers = DataSupport.findAll(GCUser.class);
        for (GCUser gcUser : mGCUsers) {
            if (userName.equals(gcUser.getUserAccount())) {
                if (password.equals(gcUser.getUserPassword())) {
                    GCToken gcToken = new GCToken(Config.ISLOGIN);
                    gcToken.save();
                    mILoginView.onLoginSuccess();
                }
            } else {
                mILoginView.onLoginFail();
            }
        }
    }
}
