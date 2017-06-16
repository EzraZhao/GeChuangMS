package com.gechuangms.ui.activity;

import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.gechuangms.R;
import com.gechuangms.presenter.IFindPasswordByPhonePresent;
import com.gechuangms.presenter.impl.FindPasswordByPhonePresentImpl;
import com.gechuangms.util.ThreadUtils;
import com.gechuangms.view.IFindPasswordByPhone;

import butterknife.BindView;
import butterknife.OnClick;
import cn.bmob.v3.exception.BmobException;

/**
 * Created by Ezra on 2017/6/13.
 */

public class FindPasswordByPhoneActivity extends BaseActivity implements IFindPasswordByPhone {

    private static final String TAG = "FindPasswordByPhone";

    @BindView(R.id.bt_more)
    Button btMore;
    @BindView(R.id.ed_phone)
    EditText edPhone;
    @BindView(R.id.ed_code)
    EditText edCode;
    @BindView(R.id.bt_code)
    Button btCode;
    @BindView(R.id.ed_new_password)
    EditText edNewPassword;
    @BindView(R.id.im_no)
    ImageView imNo;
    @BindView(R.id.tv_update_password_error_tips)
    TextView tvUpdatePasswordErrorTips;
    @BindView(R.id.iv_yes)
    ImageView ivYes;
    @BindView(R.id.tv_update_password_success_tips)
    TextView tvUpdatePasswordSuccessTips;

    private String mPhone;
    private String mCode;
    private String mPassword;

    private IFindPasswordByPhonePresent mIFindPasswordByPhonePresent;

    @Override
    protected void init() {
        super.init();
        mIFindPasswordByPhonePresent = new FindPasswordByPhonePresentImpl(this);

        initView();
    }

    private void initView() {
        if (getResources().getConfiguration().locale.getCountry().equals("CN")) {
            // TODO: 2017/6/14 替换背景图片
            btMore.setBackgroundResource(R.mipmap.ic_done);
        } else {
            btMore.setBackgroundResource(R.mipmap.ic_done);
        }
        btMore.setVisibility(View.VISIBLE);
    }

    @OnClick({R.id.bt_back, R.id.bt_more, R.id.bt_code})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.bt_back:
                finish();
                break;
            case R.id.bt_more:
                mCode = edCode.getText().toString().trim();
                mPassword = edNewPassword.getText().toString().trim();
                if (!TextUtils.isEmpty(mCode) && !TextUtils.isEmpty(mPassword)) {
                    mIFindPasswordByPhonePresent.updatePassword(mCode, mPassword);
                } else {
                    toast(getString(R.string.code_or_password_can_no_be_empty));
                }
                break;
            case R.id.bt_code:
                mPhone = edPhone.getText().toString().trim();
                if (!TextUtils.isEmpty(mPhone)) {
                    mIFindPasswordByPhonePresent.sendCode(mPhone);
                } else {
                    toast(getString(R.string.phone_can_no_be_empty));
                }
                break;
        }
    }

    @Override
    public void onSendCodeSuccess() {
        btCode.setEnabled(false);
    }

    @Override
    public void onUpdatePasswordSuccess() {
        ivYes.setVisibility(View.VISIBLE);
        tvUpdatePasswordSuccessTips.setVisibility(View.VISIBLE);
        ThreadUtils.runOnBackgroundThread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2 * 1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        startActivity(LoginActivity.class);
    }

    @Override
    public void onUpdatePasswordFail(BmobException e) {
        imNo.setVisibility(View.VISIBLE);
        tvUpdatePasswordErrorTips.setVisibility(View.VISIBLE);
        toast(e.getMessage());
    }

    @Override
    public int getLayoutRes() {
        return R.layout.activity_find_by_phone;
    }

}
