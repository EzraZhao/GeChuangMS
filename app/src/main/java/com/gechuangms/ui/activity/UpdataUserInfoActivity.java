package com.gechuangms.ui.activity;

import android.support.annotation.IdRes;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioGroup;

import com.gechuangms.R;
import com.gechuangms.presenter.IUpdataUserInfoPresenter;
import com.gechuangms.presenter.UpdataUserInfoPresenterImpl;
import com.gechuangms.view.IUpdataUserInfoView;

import butterknife.BindView;
import butterknife.OnClick;
import cn.bmob.v3.exception.BmobException;
import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by Ezra on 2017/6/15.
 */

public class UpdataUserInfoActivity extends BaseActivity implements IUpdataUserInfoView {

    private static final String TAG = "UpdataUserInfoActivity";

    @BindView(R.id.ic_default_user_image)
    CircleImageView icDefaultUserImage;
    @BindView(R.id.ed_department)
    EditText edDepartment;
    @BindView(R.id.ed_age)
    EditText edAge;
    @BindView(R.id.rg_gender)
    RadioGroup rgGender;
    @BindView(R.id.ed_email)
    EditText edEmail;
    @BindView(R.id.ed_home)
    EditText edHome;
    @BindView(R.id.ed_signature)
    EditText edSignature;


    private String mDepartment;
    private String mAge;
    private Boolean mGender;
    private String mEmail;
    private String mHome;
    private String mSignature;

    private IUpdataUserInfoPresenter mIUpdataUserInfoPresenter;

    @Override
    protected void init() {
        super.init();

        mIUpdataUserInfoPresenter = new UpdataUserInfoPresenterImpl(this);

        rgGender.setOnCheckedChangeListener(mOnCheckChangeListener);

    }

    @OnClick({R.id.bt_register_user_icon_ed, R.id.bt_back, R.id.bt_done})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.bt_back:
                finish();
                break;
            case R.id.bt_register_user_icon_ed:
                toast(getString(R.string.useless));
                break;
            case R.id.bt_done:
                updataInfo();
                break;
        }
    }

    private void updataInfo() {
        mDepartment = edDepartment.getText().toString().trim();
        mAge = edAge.getText().toString().trim();
        mEmail = edAge.getText().toString().trim();
        mSignature = edSignature.getText().toString().trim();
        mIUpdataUserInfoPresenter.updataUserInfo(mDepartment, mAge, mGender, mEmail, mHome, mSignature);
    }

    @Override
    public void onSuccess() {
        finish();
        toast(getString(R.string.updata_success));
    }

    @Override
    public void onFail(BmobException e) {
        toast(e.getMessage());
    }

    @Override
    public int getLayoutRes() {
        return R.layout.activity_updata_user_info;
    }

    private RadioGroup.OnCheckedChangeListener mOnCheckChangeListener = new RadioGroup.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
            switch (checkedId) {
                case R.id.rb_boy:
                    mGender = true;
                    break;
                case R.id.rb_girl:
                    mGender = false;
                    break;
            }
        }
    };
}
