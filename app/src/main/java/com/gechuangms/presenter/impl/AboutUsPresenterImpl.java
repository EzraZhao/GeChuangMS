package com.gechuangms.presenter.impl;

import com.gechuangms.app.Config;
import com.gechuangms.model.GCFeedback;
import com.gechuangms.presenter.IAboutUsPresenter;
import com.gechuangms.view.IAboutUsView;
import cn.bmob.v3.datatype.BmobRelation;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.SaveListener;

/**
 * Created by Ezra on 2017/6/16.
 */

public class AboutUsPresenterImpl implements IAboutUsPresenter {

    private static final String TAG = "AboutUsPresenterImpl";

    private IAboutUsView mIAboutUsView;

    public AboutUsPresenterImpl(IAboutUsView mIAboutUsView) {
        this.mIAboutUsView = mIAboutUsView;
    }

    @Override
    public void submitFeedback(String mFeedback) {
        GCFeedback feedback = new GCFeedback();
        feedback.setFeedback(mFeedback);
        BmobRelation relation = new BmobRelation();
        relation.add(Config.CURRENT_USER);
        feedback.setUser(relation);
        feedback.save(new SaveListener<String>() {
            @Override
            public void done(String s, BmobException e) {
                if (e == null) {
                    mIAboutUsView.onSuccess();
                } else {
                    mIAboutUsView.onFail(e);
                }
            }
        });
    }
}
