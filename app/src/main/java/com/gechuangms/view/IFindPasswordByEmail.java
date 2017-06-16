package com.gechuangms.view;

import cn.bmob.v3.exception.BmobException;

/**
 * Created by Ezra on 2017/6/14.
 */

public interface IFindPasswordByEmail {

    void onSendEmailSuccess();

    void onSendEmailFail(BmobException e);
}
