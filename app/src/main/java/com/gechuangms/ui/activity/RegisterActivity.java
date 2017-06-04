package com.gechuangms.ui.activity;

import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;

import com.gechuangms.R;
import com.gechuangms.app.Config;
import com.gechuangms.presenter.impl.RegisterPresentImpl;
import com.gechuangms.view.IRegisterView;

import butterknife.BindView;
import butterknife.OnClick;

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
    @BindView(R.id.ed_register_department)
    EditText mUserDepartment;
    @BindView(R.id.cb_is_member)
    CheckBox mCbIsMember;
    @BindView(R.id.cb_is_officer)
    CheckBox mCbIsOfficer;


    private RegisterPresentImpl mRegisterPresentImpl;
    private int mGroup;

    @Override
    protected void init() {
        super.init();
        mRegisterPresentImpl = new RegisterPresentImpl(this);
        mCbIsMember.setOnCheckedChangeListener(mOnMemberCheckedChangeListener);
        mCbIsOfficer.setOnCheckedChangeListener(mOnOfficerCheckedChangeListener);
    }

    @Override
    public int getLayoutRes() {
        return R.layout.activity_register;
    }

    @OnClick({R.id.bt_register_user_icon_ed, R.id.bt_register_sign_up, R.id.bt_already_hava_account})
    private void onClick(View view) {
        switch (view.getId()) {
            case R.id.bt_register_user_icon_ed:
                break;
            case R.id.bt_sign_up:
                onStartRegister();
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
        startActivity(LoginActivity.class);
    }

    @Override
    public void onStartRegister() {
        showProgress(getResources().getString(R.string.sign_up));
        register();
    }

    private void register() {
        String account = mUserAccount.getText().toString().trim();
        String password = mUserPassword.getText().toString().trim();
        String name = mUserName.getText().toString().trim();
        String phone = mUserPhone.getText().toString().trim();
        String department = mUserDepartment.getText().toString();
        int iconId = mUserDefaultImage.getId();
        mRegisterPresentImpl.register(account, password, name, phone, department, mGroup, iconId);
    }

    private CompoundButton.OnCheckedChangeListener mOnMemberCheckedChangeListener = new CompoundButton.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            if (isChecked) {
                mGroup = Config.USER_GROUP_MEMBER;
            }
        }
    };
    private CompoundButton.OnCheckedChangeListener mOnOfficerCheckedChangeListener = new CompoundButton.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            if (isChecked) {
                mGroup = Config.USER_GROUP_OFFICER;
            }
        }
    };
}
