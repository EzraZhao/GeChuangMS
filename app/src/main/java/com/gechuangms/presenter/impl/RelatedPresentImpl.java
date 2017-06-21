package com.gechuangms.presenter.impl;

import android.util.Log;

import com.gechuangms.app.Config;
import com.gechuangms.model.GCMessage;
import com.gechuangms.model.GCUser;
import com.gechuangms.presenter.IRelatedPresent;
import com.gechuangms.view.IRelatedView;

import java.util.List;

import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.datatype.BmobPointer;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.FindListener;

/**
 * Created by Ezra on 2017/6/3.
 */

public class RelatedPresentImpl implements IRelatedPresent {

    private static final String TAG = "RelatedPresentImpl";

    private IRelatedView mIRelatedView;

    public RelatedPresentImpl(IRelatedView mIRelatedView) {
        this.mIRelatedView = mIRelatedView;
    }

    @Override
    public void refreshMessage() {
        loadMessage();
        mIRelatedView.onRefreshMessage();
    }

    @Override
    public void loadMessage() {
        BmobQuery<GCMessage> uQuery = new BmobQuery<>();
        GCUser user = Config.CURRENT_USER;
        uQuery.addWhereEqualTo(Config.JOIN, new BmobPointer(user));
        uQuery.findObjects(new FindListener<GCMessage>() {
            @Override
            public void done(List<GCMessage> list, BmobException e) {
                if (e == null) {
                    Log.i(TAG, "done: " + list.size());
                    setList(list);
                    mIRelatedView.onSuccess();
                } else {
                    mIRelatedView.onFail(e);
                }
            }
        });
    }

    private void setList(List<GCMessage> list) {
        mIRelatedView.onGetAdapter().setListData(list);
    }
}
