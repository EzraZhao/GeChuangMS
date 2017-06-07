package com.gechuangms.view;

import cn.bmob.v3.exception.BmobException;

/**
 * Created by Ezra on 2017/6/4.
 */

public interface IRegisterView {

    void onUserExits();

    void onAccountError();

    void onPasswordError();

    void onRegisterSuccess();

    void onStartRegister();

    void onRegisterFail(BmobException e);
}
