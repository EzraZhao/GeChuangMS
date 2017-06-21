package com.gechuangms.view;

import com.gechuangms.adapter.CommonAdapter;
import cn.bmob.v3.exception.BmobException;

/**
 * Created by Ezra on 2017/6/9.
 */

public interface IPrizeView extends ICallBack {

    CommonAdapter onGetAdapter();

    void onRefershSuccess();
}
