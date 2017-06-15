package com.gechuangms.presenter.impl;

import com.gechuangms.presenter.IFindPasswordByEmailPresent;
import com.gechuangms.view.IFindPasswordByEmail;

/**
 * Created by Ezra on 2017/6/14.
 */

public class FindPasswordByEmailPresentImpl implements IFindPasswordByEmailPresent {

    private static final String TAG = "FindPasswordByEmail";

    private IFindPasswordByEmail mIFindPasswordByEmail;

    public FindPasswordByEmailPresentImpl(IFindPasswordByEmail mIFindPasswordByEmail) {
        this.mIFindPasswordByEmail = mIFindPasswordByEmail;
    }

    @Override
    public void sendEmail(String email) {

    }
}
