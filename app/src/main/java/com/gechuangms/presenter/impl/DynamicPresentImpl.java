package com.gechuangms.presenter.impl;

import com.gechuangms.presenter.IDynamicPresentImpl;
import com.gechuangms.view.IDynamicView;

/**
 * Created by Ezra on 2017/6/2.
 */

public class DynamicPresentImpl implements IDynamicPresentImpl {

    private IDynamicView mIdynamicView;

    public DynamicPresentImpl(IDynamicView iDynamicView) {
        mIdynamicView = iDynamicView;
    }

    @Override
    public void refreshMessage() {

    }
}
