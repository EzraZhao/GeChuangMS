package com.gechuangms.view;

import com.gechuangms.adapter.CommonAdapter;

import cn.bmob.v3.exception.BmobException;

/**
 * Created by Ezra on 2017/6/2.
 */
public interface IDynamicView {

    void onGetInfoSuccess();

    void onGetInfoFail(BmobException e);

    void onRefreshMessage();

    CommonAdapter onGetAdapter();

}
