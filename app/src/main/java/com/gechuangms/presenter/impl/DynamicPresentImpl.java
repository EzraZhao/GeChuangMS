package com.gechuangms.presenter.impl;

import com.gechuangms.model.GCMessage;
import com.gechuangms.presenter.IDynamicPresentImpl;
import com.gechuangms.util.ThreadUtils;
import com.gechuangms.view.IDynamicView;

import java.util.List;

import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.FindListener;

/**
 * Created by Ezra on 2017/6/2.
 */

public class DynamicPresentImpl implements IDynamicPresentImpl {

    private static final String TAG = "DynamicPresentImpl";

    private IDynamicView mIdynamicView;

    public DynamicPresentImpl(IDynamicView iDynamicView) {
        mIdynamicView = iDynamicView;
    }

    @Override
    public void refreshMessage() {
        ThreadUtils.runOnBackgroundThread(new Runnable() {
            @Override
            public void run() {
                loadMessage();
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
    public void loadMessage() {
        BmobQuery<GCMessage> query = new BmobQuery<>();
        query.findObjects(new FindListener<GCMessage>() {
            @Override
            public void done(List<GCMessage> list, BmobException e) {
                if (e == null) {
                    setList(list);
                    mIdynamicView.onGetInfoSuccess();
                } else {
                    mIdynamicView.onGetInfoFail(e);
                }
            }
        });
    }

    private void setList(List<GCMessage> list) {
        mIdynamicView.onGetAdapter().setListData(list);
    }

}
