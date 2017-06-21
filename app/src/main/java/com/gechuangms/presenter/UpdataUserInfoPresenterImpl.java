package com.gechuangms.presenter;

import com.gechuangms.app.Config;
import com.gechuangms.model.GCUser;
import com.gechuangms.view.IUpdataUserInfoView;

import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.UpdateListener;

/**
 * Created by Ezra on 2017/6/16.
 */

public class UpdataUserInfoPresenterImpl implements IUpdataUserInfoPresenter {

    private static final String TAG = "UpdataUserInfoPresenter";

    private IUpdataUserInfoView mIUpdataUserInfoView;

    public UpdataUserInfoPresenterImpl(IUpdataUserInfoView mIUpdataUserInfoView) {
        this.mIUpdataUserInfoView = mIUpdataUserInfoView;
    }

    @Override
    public void updataUserInfo(String department, String age, Boolean gender, String email, String home, String signature) {
        GCUser newUser = new GCUser();
        newUser.setDepartment(department);
        newUser.setAge(age);
        newUser.setGender(gender);
        newUser.setEmail(email);
        newUser.setHome(home);
        newUser.setSignature(signature);
        GCUser currentUserUser = Config.CURRENT_USER;
        newUser.update(currentUserUser.getObjectId(), new UpdateListener() {
            @Override
            public void done(BmobException e) {
                if (e == null) {
                    mIUpdataUserInfoView.onSuccess();
                } else {
                    mIUpdataUserInfoView.onFail(e);
                }
            }
        });
    }
}
