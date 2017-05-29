package com.gechuangms.view;

/**
 * Created by Ezra on 2017/5/29.
 */

public interface ILoginView {

    public static final String TAG = "ILoginView";

    void onLoginSuccess();

    void onLoginFail();

    void onUserNameError();

    void onPasswordError();

    void onStartLogin();
}
