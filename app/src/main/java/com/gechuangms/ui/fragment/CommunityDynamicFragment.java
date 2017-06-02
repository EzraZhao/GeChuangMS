package com.gechuangms.ui.fragment;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.gechuangms.R;
import com.gechuangms.adapter.DynamicMessageAdapter;
import com.gechuangms.presenter.impl.DynamicPresentImpl;
import com.gechuangms.view.IDynamicView;

import butterknife.BindView;

/**
 * Created by Ezra on 2017/5/29.
 */

public class CommunityDynamicFragment extends BaseFragment implements IDynamicView {

    private static final String TAG = "CommunityDynamicFragment";

    @BindView(R.id.dynamic_recycle_view)
    RecyclerView mRecyclerView;
    @BindView(R.id.dynamic_swipe_refresh)
    SwipeRefreshLayout mSwipeRefreshLayout;

    private DynamicMessageAdapter mDynamicMessageAdapter;
    private DynamicPresentImpl mDynamicPresent;

    @Override
    protected void init() {
        super.init();
        Log.i(TAG, "init");
        mDynamicPresent = new DynamicPresentImpl(this);
        //下拉刷新
        mSwipeRefreshLayout.setColorSchemeResources(R.color.colorAccent);
        mSwipeRefreshLayout.setOnRefreshListener(mOnRefreshListener);

        //设置消息适配器
        GridLayoutManager layoutManager = new GridLayoutManager(getContext(), 1);
        mRecyclerView.setLayoutManager(layoutManager);
        mDynamicMessageAdapter = new DynamicMessageAdapter(mGcMessageList);
        mRecyclerView.setAdapter(mDynamicMessageAdapter);
    }

    @Override
    protected int getLayoutRes() {
        return R.layout.fragment_dynamic;
    }

    @Override
    public void onRefreshMessage() {
        toast(getString(R.string.load_message_success));
        mDynamicMessageAdapter.notifyDataSetChanged();
    }

    private SwipeRefreshLayout.OnRefreshListener mOnRefreshListener = new SwipeRefreshLayout.OnRefreshListener() {
        @Override
        public void onRefresh() {
            mDynamicPresent.refreshMessage();
            mSwipeRefreshLayout.setRefreshing(false);
        }
    };
}
