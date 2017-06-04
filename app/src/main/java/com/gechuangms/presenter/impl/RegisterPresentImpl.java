package com.gechuangms.presenter.impl;

import com.gechuangms.model.GCUser;
import com.gechuangms.presenter.IRegisterPresent;
import com.gechuangms.util.StringUtils;
import com.gechuangms.view.IRegisterView;

import org.litepal.crud.DataSupport;

import java.util.List;

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
    public void register(String account, String password, String name, String phone, String department, int group, int iconId) {
        if (StringUtils.checkUserName(account)) {
            if (StringUtils.checkPassword(password)) {
                mIRegisterView.onStartRegister();
                startRegister(account, password, name, phone, department, group, iconId);
            } else {
                mIRegisterView.onPasswordError();
            }
        } else {
            mIRegisterView.onAccountError();
        }
    }

    private void startRegister(String account, String password, String name, String phone, String department, int group, int iconId) {
        List<GCUser> gcUsers = DataSupport.findAll(GCUser.class);
        boolean flag = true;
        for (GCUser gcUser : gcUsers) {
            if (account == gcUser.getUserAccount()) {
                mIRegisterView.onUserExits();
                flag = false;
                break;
            }
        }
        if (flag) {
            int grade = getUserGrade(account);
            GCUser gcUser = new GCUser(account, password, group, name, "", grade, department, phone, iconId);
            gcUser.save();
            mIRegisterView.onRegisterSuccess();
        }
    }

    private int getUserGrade(String account) {
        String grade = account.substring(0, 3);
        return Integer.valueOf(grade);
    }
}
