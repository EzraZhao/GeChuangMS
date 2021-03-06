package com.gechuangms.presenter.impl;

import android.util.Log;

import com.gechuangms.app.Config;
import com.gechuangms.model.GCUser;
import com.gechuangms.presenter.IRegisterPresent;
import com.gechuangms.util.StringUtils;
import com.gechuangms.view.IRegisterView;

import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.SaveListener;

/**
 * Created by Ezra on 2017/6/4.
 */

public class RegisterPresentImpl implements IRegisterPresent {

    private static final String TAG = "RegisterPresentImpl";

    private IRegisterView mIRegisterView;

    public RegisterPresentImpl(IRegisterView mIRegisterView) {
        this.mIRegisterView = mIRegisterView;
    }

    @Override
//    public void register(String account, String password, String name, String phone, String department, int group, int iconId) {
    public void register(String account, String password, String name, String phone, int group, int iconId) {
        if (StringUtils.checkUserName(account)) {
            if (StringUtils.checkPassword(password)) {
                mIRegisterView.onStartRegister();
//                startRegister(account, password, name, phone, department, group, iconId);
                startRegister(account, password, name, phone, group, iconId);
            } else {
                mIRegisterView.onPasswordError();
            }
        } else {
            mIRegisterView.onAccountError();
        }
    }

//    private void startRegister(String account, String password, String name, String phone, String department, int group, int iconId) {
    private void startRegister(String account, String password, String name, String phone, int group, int iconId) {
        Log.i(TAG, "startRegister: ");
        GCUser gcUser = new GCUser();
        gcUser.setUsername(account);
        gcUser.setPassword(password);
        gcUser.setName(name);
        gcUser.setMobilePhoneNumber(phone);
//        gcUser.setDepartment(department);
        gcUser.setGroup(group);
        gcUser.setGrade(getUserGrade(account));
        gcUser.setIconUrl(Config.DEFAULT_ICON_URL);
        gcUser.signUp(new SaveListener<GCUser>() {
            @Override
            public void done(GCUser gcUser, BmobException e) {
                if (e == null) {
                    Config.CURRENT_USER = gcUser;
                    mIRegisterView.onSuccess();
                } else {
                    mIRegisterView.onFail(e);
                }
            }
        });

    }
    private int getUserGrade(String account) {
        String grade = account.substring(0, 4);
        return Integer.valueOf(grade);
    }
}
