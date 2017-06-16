package com.gechuangms.ui.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.gechuangms.R;
import com.gechuangms.presenter.IAboutUsPresenter;
import com.gechuangms.presenter.impl.AboutUsPresenterImpl;
import com.gechuangms.view.IAboutUsView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.bmob.v3.exception.BmobException;

/**
 * Created by Ezra on 2017/6/9.
 */

public class AboutUsActivity extends BaseActivity implements IAboutUsView {

    private static final String TAG = "AboutUsActivity";

    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.ed_m)
    EditText edM;

    private IAboutUsPresenter mIAboutUsPresenter;

    private String mFeedback;

    @Override
    protected void init() {
        super.init();

        mIAboutUsPresenter = new AboutUsPresenterImpl(this);

        tvTitle.setText(getString(R.string.str_nav_about_us));
    }

    @OnClick({R.id.bt_back, R.id.bt_submit})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.bt_back:
                finish();
                break;
            case R.id.bt_submit:
                submit();
                break;
        }
    }

    private void submit() {
        mFeedback = edM.getText().toString().trim();
        mIAboutUsPresenter.submitFeedback(mFeedback);
    }

    @Override
    public int getLayoutRes() {
        return R.layout.activity_about_us;
    }

    @Override
    public void onSuccess() {
        toast(getString(R.string.thanks_for_feedback));
    }

    @Override
    public void onFail(BmobException e) {
        toast(e.getMessage());
    }
}
