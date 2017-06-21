package com.gechuangms.view;

import cn.bmob.v3.exception.BmobException;

/**
 * Created by Ezra on 2017/6/18.
 */

public interface ICallBack {

    void onSuccess();

    void onFail(BmobException e);

}
