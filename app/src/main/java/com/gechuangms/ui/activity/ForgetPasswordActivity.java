package com.gechuangms.ui.activity;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.gechuangms.R;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by Ezra on 2017/6/3.
 */

public class ForgetPasswordActivity extends BaseActivity {

    @BindView(R.id.bt_back)
    Button btBack;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.bt_email_go)
    Button ivEmailGo;
    @BindView(R.id.bt_phone_go)
    Button ivPhoneGo;

    @Override
    protected void init() {
        super.init();
        tvTitle.setText(R.string.find_password);
    }

    @OnClick({R.id.bt_back, R.id.bt_email_go, R.id.bt_phone_go})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.bt_back:
                // TODO: 2017/6/13  
                finish();
                break;
            case R.id.bt_email_go:
                startActivity(FindPasswordByEmailActivity.class);
                break;
            case R.id.bt_phone_go:
                startActivity(FindPasswordByPhoneActivity.class);
                break;
        }
    }

    @Override
    public int getLayoutRes() {
        return R.layout.activity_forget_password;
    }

}
