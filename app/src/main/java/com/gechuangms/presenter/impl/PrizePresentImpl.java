package com.gechuangms.presenter.impl;

import com.gechuangms.model.GCPrize;
import com.gechuangms.presenter.IPrizePresenter;
import com.gechuangms.view.IPrizeView;

import java.util.List;

import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.FindListener;

/**
 * Created by Ezra on 2017/6/10.
 */

public class PrizePresentImpl implements IPrizePresenter {

    private static final String TAG = "PrizePresentImpl";

    private IPrizeView mIPrizeView;

    public PrizePresentImpl(IPrizeView mIPrizeView) {
        this.mIPrizeView = mIPrizeView;
    }

    @Override
    public void loadInfo() {
        BmobQuery<GCPrize> prizeBmobQuery = new BmobQuery<>();
        prizeBmobQuery.findObjects(new FindListener<GCPrize>() {
            @Override
            public void done(List<GCPrize> list, BmobException e) {
                if (e == null) {
                    mIPrizeView.onGetAdapter().setListData(list);
                    mIPrizeView.onSuccess();
                } else {
                    mIPrizeView.onFail(e);
                }
            }
        });
    }

    @Override
    public void refresh() {
        loadInfo();
        mIPrizeView.onRefershSuccess();
    }
}
