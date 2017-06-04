package com.gechuangms.ui.activity;

import com.gechuangms.R;
import com.gechuangms.app.Config;
import com.gechuangms.presenter.impl.SplashPresentImpl;
import com.gechuangms.view.ISplashView;

/**
 * Created by Ezra on 2017/6/4.
 */

public class SplashActivity extends BaseActivity implements ISplashView {

    private static final String TAG = "SplashActivity";

    private SplashPresentImpl mSplashPresentImpl;

    @Override
    protected void init() {
        super.init();
        mSplashPresentImpl = new SplashPresentImpl(this);
        mSplashPresentImpl.checkLoginStatus();
    }

    @Override
    public void onNotLogin() {
        postDelay(new Runnable() {
            @Override
            public void run() {
                startActivity(LoginActivity.class);
            }
        }, Config.DELAY);
    }

    @Override
    public void onLoggedIn() {
        startActivity(MainActivity.class);
    }

    @Override
    public int getLayoutRes() {
        return R.layout.activity_splash;
    }
}
