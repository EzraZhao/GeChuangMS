package com.gechuangms.ui.activity;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.gechuangms.R;
import com.gechuangms.presenter.IFindPasswordByEmailPresent;
import com.gechuangms.presenter.impl.FindPasswordByEmailPresentImpl;
import com.gechuangms.view.IFindPasswordByEmail;

import butterknife.BindView;
import butterknife.OnClick;
import cn.bmob.v3.exception.BmobException;

/**
 * Created by Ezra on 2017/6/13.
 */

public class FindPasswordByEmailActivity extends BaseActivity implements IFindPasswordByEmail {

    private static final String TAG = "FindPasswordByEmail";

    @BindView(R.id.bt_more)
    Button btMore;
    @BindView(R.id.ed_email)
    EditText edEmail;
    @BindView(R.id.iv_yes)
    ImageView ivYes;
    @BindView(R.id.tv_send_email_tips)
    TextView tvSendEmailTips;

    private IFindPasswordByEmailPresent mIFindPasswordByEmailPresent;

    private String mEmail;

    @Override
    protected void init() {
        super.init();
        mIFindPasswordByEmailPresent = new FindPasswordByEmailPresentImpl(this);

        if (getResources().getConfiguration().locale.getCountry().equals("CN")) {
            // TODO: 2017/6/14 替换背景图片
            btMore.setBackgroundResource(R.mipmap.ic_done);
        } else {
            btMore.setBackgroundResource(R.mipmap.ic_done);
        }
        btMore.setVisibility(View.VISIBLE);
    }

    @OnClick({R.id.bt_back, R.id.bt_more})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.bt_back:
                finish();
                break;
            case R.id.bt_more:
                mEmail = edEmail.getText().toString().trim();
                mIFindPasswordByEmailPresent.sendEmail(mEmail);
                break;
        }
    }

    @Override
    public void onSendEmailSuccess() {
        ivYes.setVisibility(View.VISIBLE);
        tvSendEmailTips.setVisibility(View.VISIBLE);
    }

    @Override
    public void onSendEmailFail(BmobException e) {
        toast(e.getMessage());
    }

    @Override
    public int getLayoutRes() {
        return R.layout.activity_find_by_email;
    }

}
