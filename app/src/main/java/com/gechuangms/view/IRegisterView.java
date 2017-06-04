package com.gechuangms.view;

/**
 * Created by Ezra on 2017/6/4.
 */

public interface IRegisterView {

    void onUserExits();

    void onAccountError();

    void onPasswordError();

    void onRegisterSuccess();

    void onStartRegister();
}
