package com.gechuangms.ui.activity;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.gechuangms.R;
import com.gechuangms.presenter.ILoginPresent;
import com.gechuangms.presenter.impl.LoginPresentImpl;
import com.gechuangms.view.ILoginView;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by Ezra on 2017/5/29.
 */

public class LoginActivity extends BaseActivity implements ILoginView {

    private static final String TAG = "LoginActivity";

    @BindView(R.id.ed_login_user_account)
    EditText mEdUserAccount;
    @BindView(R.id.ed_login_user_password)
    EditText mEdUserPassword;
    @BindView(R.id.bt_sign_in)
    Button mBtSignIn;
    @BindView(R.id.bt_sign_up)
    Button mBtSignUp;
    @BindView(R.id.bt_forget_password)
    Button mBtForget;

    private ILoginPresent mILoginPresent;

    @Override
    protected void init() {
        super.init();
        mILoginPresent = new LoginPresentImpl(this);
    }

    @OnClick({R.id.bt_sign_in, R.id.bt_sign_up, R.id.bt_forget_password})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.bt_sign_in:
                login();
                break;
            case R.id.bt_sign_up:
                startActivity(RegisterActivity.class, false);
                break;
            case R.id.bt_forget_password:
                startActivity(ForgetPasswordActivity.class, false);
                break;
        }
    }

    private void login() {
        Log.i(TAG, "login: ");
        String userName = mEdUserAccount.getText().toString().trim();
        String passwrod = mEdUserPassword.getText().toString().trim();
        mILoginPresent.login(userName, passwrod);
    }

    @Override
    public void onLoginSuccess() {
        hideProgress();
        startActivity(MainActivity.class);
    }

    @Override
    public void onLoginFail() {
        hideProgress();
        toast(getString(R.string.sign_in_faild));
    }

    @Override
    public void onUserNameError() {
        hideProgress();
        toast(getString(R.string.user_account_error));
    }

    @Override
    public void onPasswordError() {
        hideProgress();
        toast(getString(R.string.user_password_error));
    }

    @Override
    public void onStartLogin() {
        showProgress(getResources().getString(R.string.sign_in));
    }

    @Override
    public int getLayoutRes() {
        return R.layout.activity_login;
    }
}
