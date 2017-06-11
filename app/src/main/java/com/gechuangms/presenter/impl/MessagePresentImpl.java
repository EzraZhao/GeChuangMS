package com.gechuangms.presenter.impl;

import com.gechuangms.app.Config;
import com.gechuangms.model.GCMessage;
import com.gechuangms.presenter.IMessagePresent;
import com.gechuangms.view.IMessageView;

import cn.bmob.v3.datatype.BmobRelation;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.SaveListener;
import cn.bmob.v3.listener.UpdateListener;

/**
 * Created by Ezra on 2017/6/3.
 */

public class MessagePresentImpl implements IMessagePresent {

    private static final String TAG = "MessagePresentImpl";

    private IMessageView mIMessageView;
    private GCMessage mGcMessage = new GCMessage();

    public MessagePresentImpl(IMessageView mIMessageView) {
        this.mIMessageView = mIMessageView;
    }

    @Override
    public void joinActivity(GCMessage message) {
        BmobRelation relation = new BmobRelation();
        relation.add(Config.CURRENT_USER);
        message.setJoin(relation);
        message.update(new UpdateListener() {
            @Override
            public void done(BmobException e) {
                if (e == null) {
                    mIMessageView.onJoinSuccess();
                } else {
                    mIMessageView.onJoinFail(e);
                }
            }
        });
    }
}
