package com.gechuangms.view;

import com.gechuangms.adapter.CommonAdapter;

import cn.bmob.v3.exception.BmobException;

/**
 * Created by Ezra on 2017/6/3.
 */

public interface IRelatedView extends ICallBack {

    void onRefreshMessage();

    CommonAdapter onGetAdapter();

}
