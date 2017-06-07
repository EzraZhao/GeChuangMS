package com.gechuangms.ui.fragment;

import com.gechuangms.R;
import com.gechuangms.presenter.impl.RelatedPresentImpl;
import com.gechuangms.view.IRelatedView;

/**
 * Created by Ezra on 2017/5/29.
 */

public class RelatedToMeFragment extends BaseFragment implements IRelatedView {

    private static final String TAG = "RelatedToMeFragment";

    private RelatedPresentImpl mRelatedPresent;

    @Override
    protected void init() {
        super.init();
        mRelatedPresent = new RelatedPresentImpl(this);
    }

    @Override
    protected int getLayoutRes() {
        return R.layout.frageent_realted;
    }

    @Override
    public void onRefreshMessage() {

    }
}
