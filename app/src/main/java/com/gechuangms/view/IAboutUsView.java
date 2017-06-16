package com.gechuangms.view;

import cn.bmob.v3.exception.BmobException;

/**
 * Created by Ezra on 2017/6/9.
 */

public interface IAboutUsView {

    void onSuccess();

    void onFail(BmobException e);
}
