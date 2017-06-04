package com.gechuangms.presenter.impl;

import android.database.Cursor;
import android.util.Log;

import com.gechuangms.model.GCMessage;
import com.gechuangms.presenter.IMessagePresent;
import com.gechuangms.util.ThreadUtils;
import com.gechuangms.view.IMessageView;

import org.litepal.crud.DataSupport;

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
    public void loadMessage(final String messageTitle) {
        ThreadUtils.runOnBackgroundThread(new Runnable() {
            @Override
            public void run() {
                Cursor cursor = DataSupport.findBySQL("select * from gcmessage where messagetitle='" + messageTitle + "'");
                if (cursor.moveToFirst()) {
                    String title = cursor.getString(cursor.getColumnIndex("messagetitle"));
                    int imageId = cursor.getInt(cursor.getColumnIndex("messageimageid"));
                    String content = cursor.getString(cursor.getColumnIndex("messagecontent"));
                    mGcMessage.setMessageTitle(title);
                    mGcMessage.setMessageImageId(imageId);
                    mGcMessage.setMessageContent(content);
                } while (cursor.moveToNext());
                Log.i(TAG, mGcMessage.getMessageTitle());
            }
        });
        ThreadUtils.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                mIMessageView.onLoadMessage(mGcMessage);
            }
        });
    }
}
