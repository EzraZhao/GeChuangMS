package com.gechuangms.presenter.impl;

import com.gechuangms.model.GCToken;
import com.gechuangms.presenter.ISplashPresent;
import com.gechuangms.view.ISplashView;

import org.litepal.crud.DataSupport;

import java.util.List;

/**
 * Created by Ezra on 2017/6/4.
 */

public class SplashPresentImpl implements ISplashPresent {

    private static final String TAG = "SplashPresentImpl";

    private ISplashView mISplashView;

    public SplashPresentImpl(ISplashView mISplashView) {
        this.mISplashView = mISplashView;
    }

    @Override
    public void checkLoginStatus() {
        List<GCToken> tokens = DataSupport.findAll(GCToken.class);
        if (tokens.get(0).isToken()) {
            mISplashView.onLoggedIn();
        } else {
            mISplashView.onNotLogin();
        }
    }
}
