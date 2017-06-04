package com.gechuangms.presenter;

import com.gechuangms.model.GCMessage;

import java.util.List;

/**
 * Created by Ezra on 2017/6/2.
 */

public interface IDynamicPresentImpl {

    void refreshMessage();
    List<GCMessage> getMessages();
}
