package com.gechuangms.ui.activity;

import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.gechuangms.R;
import com.gechuangms.app.Config;
import com.gechuangms.model.GCMessage;
import com.gechuangms.presenter.IMessagePresent;
import com.gechuangms.presenter.impl.MessagePresentImpl;
import com.gechuangms.view.IMessageView;

import butterknife.BindView;
import butterknife.OnClick;
import cn.bmob.v3.exception.BmobException;

/**
 * Created by Ezra on 2017/6/3.
 */

public class MessageActivity extends BaseActivity implements IMessageView {

    private static final String TAG = "MessageActivity";

//    @BindView(R.id.wv_message_web_view)
//    WebView mWebView;
    @BindView(R.id.tv_activity_message_title)
    TextView mTvMessageTitle;
    @BindView(R.id.iv_activity_message_image)
    ImageView mIvMessageImage;
    @BindView(R.id.tv_activity_message_content)
    TextView mTvMessageContent;
    @BindView(R.id.tv_title)
    TextView mTvTitle;
    @BindView(R.id.bt_more)
    Button mBtMore;

    private IMessagePresent mIMessagePresent;
    private GCMessage mGCMessage;


    @Override
    public int getLayoutRes() {
        return R.layout.activity_message;
    }

    @Override
    protected void init() {
        super.init();
        Log.i(TAG, "init");

        mTvTitle.setText(R.string.message);
        mBtMore.setVisibility(View.VISIBLE);

        mIMessagePresent = new MessagePresentImpl(this);

        initView();

//        mWebView.getSettings().setJavaScriptEnabled(true);
//        mWebView.setWebViewClient(new WebViewClient());
//        mWebView.loadUrl("http://www.baidu.com");
    }

    private void initView() {
        Intent data = getIntent();
        mGCMessage = (GCMessage) data.getSerializableExtra(Config.MESSAGE);

        mTvMessageTitle.setText(mGCMessage.getTitle());
        Glide.with(this).load(mGCMessage.getImageUrl()).into(mIvMessageImage);
        mTvMessageContent.setText(mGCMessage.getContent());
    }

    @Override
    public void onSuccess() {
        toast(getString(R.string.join_activity_success));
    }

    @Override
    public void onFail(BmobException e) {
        toast(e.getMessage());
    }

    @OnClick({R.id.bt_back, R.id.bt_more})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.bt_back:
                finish();
                break;
            case R.id.bt_more:
                if (mGCMessage.getType().equals(Config.MESSAGE_TYPE_ACTIVITY)) {
                    mIMessagePresent.joinActivity(mGCMessage);
                } else {
                    toast(getString(R.string.join_tips));
                }
                break;
        }
    }
}

