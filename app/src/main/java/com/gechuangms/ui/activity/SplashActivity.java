package com.gechuangms.ui.activity;

import android.content.pm.PackageManager;
import android.support.annotation.NonNull;

import com.gechuangms.R;
import com.gechuangms.app.Config;
import com.gechuangms.model.GCMSVersion;
import com.gechuangms.presenter.impl.SplashPresentImpl;
import com.gechuangms.util.ThreadUtils;
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
        mSplashPresentImpl = new SplashPresentImpl(SplashActivity.this, this);
        ThreadUtils.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                //版本初始化
                GCMSVersion.versionInit();
                //权限申请
                mSplashPresentImpl.requestPermissions();
            }
        });

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



    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode) {
            case Config.REQUEST_PERMISSION:
                if (grantResults.length > 0) {
                    for (int result : grantResults) {
                        if (result != PackageManager.PERMISSION_GRANTED) {
                            toast(getResources().getString(R.string.must_acept_all_permission_can_use_app));
                            finish();
                            return;
                        }
                    }
                } else {
                    toast(getResources().getString(R.string.some_errors_happend));
                }
                break;
        }
    }
}
