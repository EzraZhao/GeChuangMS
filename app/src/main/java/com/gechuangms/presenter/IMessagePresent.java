package com.gechuangms.presenter;

import com.gechuangms.model.GCMessage;

/**
 * Created by Ezra on 2017/6/3.
 */

public interface IMessagePresent {

    void loadMessage(String messageTitle);

    void joinActivity(GCMessage message);
}
