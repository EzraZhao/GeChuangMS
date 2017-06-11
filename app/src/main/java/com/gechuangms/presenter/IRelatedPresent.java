package com.gechuangms.presenter;

/**
 * Created by Ezra on 2017/6/3.
 */

public interface IRelatedPresent {


    void refreshMessage();

    /**
     * 查询当前用户下的所有相关活动
     */
    void loadMessage();

}
