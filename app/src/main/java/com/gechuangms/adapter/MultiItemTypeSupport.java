package com.gechuangms.adapter;

/**
 * Created by Ezra on 2017/6/9.
 */

public interface MultiItemTypeSupport<T> {

    int getLayoutId(int itemType);

    int getItemViewType(int postion, T data);
}
