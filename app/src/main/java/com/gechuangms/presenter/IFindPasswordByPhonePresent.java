package com.gechuangms.presenter;

/**
 * Created by Ezra on 2017/6/14.
 */

public interface IFindPasswordByPhonePresent {

    void sendCode(String phone);

    void updatePassword(String code, String newPassword);
}
