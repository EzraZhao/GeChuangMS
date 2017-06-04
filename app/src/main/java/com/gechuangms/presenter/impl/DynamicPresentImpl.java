package com.gechuangms.presenter.impl;

import com.gechuangms.model.GCMessage;
import com.gechuangms.presenter.IDynamicPresentImpl;
import com.gechuangms.util.ThreadUtils;
import com.gechuangms.view.IDynamicView;

import org.litepal.crud.DataSupport;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Ezra on 2017/6/2.
 */

public class DynamicPresentImpl implements IDynamicPresentImpl {

    private static final String TAG = "DynamicPresentImpl";

    private IDynamicView mIdynamicView;
    private List<GCMessage> mGcMessageList;

    public DynamicPresentImpl(IDynamicView iDynamicView) {
        mIdynamicView = iDynamicView;
        mGcMessageList = DataSupport.findAll(GCMessage.class);
    }

    @Override
    public void refreshMessage() {
        ThreadUtils.runOnBackgroundThread(new Runnable() {
            @Override
            public void run() {
                Collections.shuffle(mGcMessageList);
            }
        });

        ThreadUtils.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                mIdynamicView.onRefreshMessage();
            }
        });
    }

    @Override
    public List<GCMessage> getMessages() {
        return mGcMessageList;
    }
}
