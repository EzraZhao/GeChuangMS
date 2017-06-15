package com.gechuangms.ui.activity;

import android.os.Bundle;
import android.support.annotation.IdRes;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioGroup;

import com.gechuangms.R;
import com.gechuangms.app.Config;
import com.gechuangms.presenter.IRegisterPresent;
import com.gechuangms.presenter.impl.RegisterPresentImpl;
import com.gechuangms.view.IRegisterView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.bmob.v3.exception.BmobException;

/**
 * Created by Ezra on 2017/5/29.
 */

public class RegisterActivity extends BaseActivity implements IRegisterView {

    private static final String TAG = "RegisterActivity";

    @BindView(R.id.ic_default_user_image)
    ImageView mUserDefaultImage;
    @BindView(R.id.ed_register_account)
    EditText mUserAccount;
    @BindView(R.id.ed_register_password)
    EditText mUserPassword;
    @BindView(R.id.ed_register_name)
    EditText mUserName;
    @BindView(R.id.ed_register_phone)
    EditText mUserPhone;
//    @BindView(R.id.ed_register_department)
//    EditText mUserDepartment;
    @BindView(R.id.rg_group)
    RadioGroup mRgGroup;

    private IRegisterPresent mIRegisterPresent;
    private static int mGroup = 1;

    @Override
    protected void init() {
        super.init();
        mIRegisterPresent = new RegisterPresentImpl(this);

        mRgGroup.setOnCheckedChangeListener(mOnCheckedChangeListener);
    }

    @Override
    public int getLayoutRes() {
        return R.layout.activity_register;
    }

    @OnClick({R.id.bt_register_user_icon_ed, R.id.bt_register_sign_up, R.id.bt_already_hava_account})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.bt_register_user_icon_ed:
                toast(getString(R.string.useless));
                break;
            case R.id.bt_register_sign_up:
                register();
                break;
            case R.id.bt_already_hava_account:
                startActivity(LoginActivity.class);
                break;

        }
    }


    @Override
    public void onUserExits() {

        hideProgress();
        toast(getString(R.string.user_exits));
    }

    @Override
    public void onAccountError() {
        hideProgress();
        toast(getString(R.string.user_account_error));
    }

    @Override
    public void onPasswordError() {
        hideProgress();
        toast(getString(R.string.user_password_error));
    }

    @Override
    public void onRegisterSuccess() {
        hideProgress();
        startActivity(MainActivity.class);
    }

    @Override
    public void onStartRegister() {
        showProgress(getResources().getString(R.string.sign_up));
    }

    @Override
    public void onRegisterFail(BmobException e) {
        hideProgress();
        toast(e.getMessage());
    }

    private void register() {

        String account = mUserAccount.getText().toString().trim();
        String password = mUserPassword.getText().toString().trim();
        String name = mUserName.getText().toString().trim();
        String phone = mUserPhone.getText().toString().trim();
//        String department = mUserDepartment.getText().toString();
        int iconId = mUserDefaultImage.getId();
//        mIRegisterPresent.register(account, password, name, phone, department, mGroup, iconId);
        mIRegisterPresent.register(account, password, name, phone, mGroup, iconId);
    }

    private RadioGroup.OnCheckedChangeListener mOnCheckedChangeListener = new RadioGroup.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
            switch (checkedId) {
                case R.id.rb_member:
                    mGroup = Config.USER_GROUP_MEMBER;
                    Log.i(TAG, "onCheckedChanged: " + checkedId);
                    Log.i(TAG, "onCheckedChanged: " + mGroup);
                    break;
                case R.id.rb_officer:
                    mGroup = Config.USER_GROUP_OFFICER;
                    Log.i(TAG, "onCheckedChanged: " + checkedId);
                    Log.i(TAG, "onCheckedChanged: " + mGroup);
                    break;
            }
        }
    };

}
