package com.gechuangms.presenter;

import com.gechuangms.model.GCMessage;

import java.util.List;

/**
 * Created by Ezra on 2017/6/3.
 */

public interface IRelatedPresent {


    void refreshMessage();

    List<GCMessage> getMessages();

}
