package com.gechuangms.presenter.impl;

import com.gechuangms.presenter.IFindPasswordByEmailPresent;
import com.gechuangms.view.IFindPasswordByEmail;

import cn.bmob.v3.BmobUser;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.UpdateListener;

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
        BmobUser.resetPasswordByEmail(email, new UpdateListener() {
            @Override
            public void done(BmobException e) {
                if (e == null) {
                    mIFindPasswordByEmail.onSendEmailSuccess();
                } else {
                    mIFindPasswordByEmail.onSendEmailFail(e);
                }
            }
        });
    }
}
