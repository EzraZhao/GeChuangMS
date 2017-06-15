package com.gechuangms.ui.activity;

import android.net.Uri;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

import com.gechuangms.R;
import com.gechuangms.app.Config;
import com.gechuangms.view.IIntroductionView;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Ezra on 2017/6/9.
 */

public class IntroductionActivity extends BaseActivity implements IIntroductionView {


    @BindView(R.id.vv_introduction_video)
    VideoView vvIntroductionVideo;

    @Override
    protected void init() {
        super.init();
        Uri uri = Uri.parse(Config.VIDEO_URL);

        vvIntroductionVideo.setMediaController(new MediaController(this));
        vvIntroductionVideo.setVideoURI(uri);
        //videoView.start();
        vvIntroductionVideo.requestFocus();
        vvIntroductionVideo.start();
    }

    @Override
    public int getLayoutRes() {
        return R.layout.activity_introduction;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }
}
