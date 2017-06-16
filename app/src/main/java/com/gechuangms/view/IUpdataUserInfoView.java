package com.gechuangms.view;

import cn.bmob.v3.exception.BmobException;

/**
 * Created by Ezra on 2017/6/16.
 */

public interface IUpdataUserInfoView {

    void onUpdataSuccess();

    void onUpdataFail(BmobException e);
}
