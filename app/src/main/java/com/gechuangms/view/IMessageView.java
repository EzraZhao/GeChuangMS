package com.gechuangms.view;

import cn.bmob.v3.exception.BmobException;

/**
 * Created by Ezra on 2017/6/3.
 */

public interface IMessageView {

    void onJoinSuccess();

    void onJoinFail(BmobException e);
}
