package com.gechuangms.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.gechuangms.R;

import butterknife.BindView;

/**
 * Created by Ezra on 2017/5/29.
 */

public class CommunityFriendsFragment extends BaseFragment {

    @BindView(R.id.tv_tips)
    TextView tvTips;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    protected int getLayoutRes() {
        return R.layout.fragment_friends;
    }

    @Override
    protected void init() {
        super.init();
    }
}
