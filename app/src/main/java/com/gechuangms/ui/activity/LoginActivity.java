package com.gechuangms.ui.activity;

import com.gechuangms.R;
import com.gechuangms.view.ILoginView;

/**
 * Created by Ezra on 2017/5/29.
 */

public class LoginActivity extends BaseActivity implements ILoginView {
    @Override
    public void onLoginSuccess() {

    }

    @Override
    public void onLoginFail() {

    }

    @Override
    public void onUserNameError() {

    }

    @Override
    public void onPasswordError() {

    }

    @Override
    public void onStartLogin() {

    }

    @Override
    public int getLayoutRes() {
        return R.layout.activity_login;
    }
}
