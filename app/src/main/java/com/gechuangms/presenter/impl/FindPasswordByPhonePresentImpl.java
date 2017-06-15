package com.gechuangms.presenter.impl;

import com.gechuangms.presenter.IFindPasswordByPhonePresent;
import com.gechuangms.view.IFindPasswordByPhone;

import cn.bmob.v3.BmobSMS;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.QueryListener;

/**
 * Created by Ezra on 2017/6/14.
 */

public class FindPasswordByPhonePresentImpl implements IFindPasswordByPhonePresent {

    private static final String TAG = "FindPasswordByPhone";

    private IFindPasswordByPhone mIFindPasswordByPhone;

    public FindPasswordByPhonePresentImpl(IFindPasswordByPhone mIFindPasswordByPhone) {
        this.mIFindPasswordByPhone = mIFindPasswordByPhone;
    }

    @Override
    public void sendCode(String phone) {
        BmobSMS.requestSMSCode(phone, "", new QueryListener<Integer>() {
            @Override
            public void done(Integer integer, BmobException e) {

            }
        });
    }


    @Override
    public void updatePassword(String code, String newPassword) {

    }
}
