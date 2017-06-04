package com.gechuangms.presenter.impl;

import com.gechuangms.model.GCMessage;
import com.gechuangms.presenter.IRelatedPresent;
import com.gechuangms.view.IRelatedView;

import java.util.List;

/**
 * Created by Ezra on 2017/6/3.
 */

public class RelatedPresentImpl implements IRelatedPresent {

    private static final String TAG = "RelatedPresentImpl";

    private IRelatedView mIRelatedView;
    private List<GCMessage> gcMessageList;

    public RelatedPresentImpl(IRelatedView mIRelatedView) {
        this.mIRelatedView = mIRelatedView;
    }

    @Override
    public void refreshMessage() {

    }

    @Override
    public List<GCMessage> getMessages() {
        return null;
    }
}
