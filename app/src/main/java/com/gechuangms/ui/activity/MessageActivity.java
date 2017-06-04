package com.gechuangms.ui.activity;

import android.content.Intent;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.gechuangms.R;
import com.gechuangms.app.Config;
import com.gechuangms.model.GCMessage;
import com.gechuangms.presenter.impl.MessagePresentImpl;
import com.gechuangms.view.IMessageView;

import butterknife.BindView;

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
    ImageView mImMessageImage;
    @BindView(R.id.tv_activity_message_content)
    TextView mTvMessageContent;

    private MessagePresentImpl mMessagePresentImpl;

    @Override
    public int getLayoutRes() {
        return R.layout.activity_message;
    }

    @Override
    protected void init() {
        super.init();
        Log.i(TAG, "init");
        mMessagePresentImpl = new MessagePresentImpl(this);

        Intent intent = getIntent();
        String messageTitle = intent.getStringExtra(Config.MESSAGE_TITLE);

        showProgress(getResources().getString(R.string.load_messages));
        mMessagePresentImpl.loadMessage(messageTitle);



//        mWebView.getSettings().setJavaScriptEnabled(true);
//        mWebView.setWebViewClient(new WebViewClient());
//        mWebView.loadUrl("http://www.baidu.com");
    }

    @Override
    public void onLoadMessage(GCMessage gcMessage) {
        mTvMessageTitle.setText(gcMessage.getMessageTitle());
        mImMessageImage.setImageResource(gcMessage.getMessageImageId());
        mTvMessageContent.setText(gcMessage.getMessageContent());
        hideProgress();
    }
}
