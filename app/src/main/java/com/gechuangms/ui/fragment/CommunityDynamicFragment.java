package com.gechuangms.ui.fragment;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.gechuangms.R;
import com.gechuangms.adapter.CommonAdapter;
import com.gechuangms.adapter.ViewHolder;
import com.gechuangms.app.Config;
import com.gechuangms.model.GCMessage;
import com.gechuangms.presenter.IDynamicPresentImpl;
import com.gechuangms.presenter.impl.DynamicPresentImpl;
import com.gechuangms.ui.activity.MessageActivity;
import com.gechuangms.view.IDynamicView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import cn.bmob.v3.exception.BmobException;

/**
 * Created by Ezra on 2017/5/29.
 */

public class CommunityDynamicFragment extends BaseFragment implements IDynamicView {

    private static final String TAG = "CommunityDynamicFragment";

    @BindView(R.id.dynamic_recycle_view)
    RecyclerView mRecyclerView;
    @BindView(R.id.dynamic_swipe_refresh)
    SwipeRefreshLayout mSwipeRefreshLayout;

    private IDynamicPresentImpl mIDynamicPresent;
    private CommonAdapter<GCMessage> commonAdapter;
    private List<GCMessage> messageList;

    @Override
    protected void init() {
        super.init();

        mIDynamicPresent = new DynamicPresentImpl(this);

        messageList = new ArrayList<>();

        showProgress(getString(R.string.load));
        mIDynamicPresent.loadMessage();

        initMessageView();
    }

    private void initMessageView() {
        commonAdapter = new CommonAdapter<GCMessage>(getContext(), messageList, R.layout.fragment_dynamic_item) {
            @Override
            public void convert(ViewHolder viewHolder, final GCMessage gcMessage) {
                viewHolder.setText(R.id.tv_message_title, gcMessage.getTitle())
                        .setBitmapFromUrl(R.id.iv_message_image, gcMessage.getImageUrl())
                        .setOnClickListener(R.id.cv_dynamic_item, new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                startActivity(MessageActivity.class, Config.MESSAGE, gcMessage);
                            }
                        });
            }
        };

        //设置消息适配器
        GridLayoutManager layoutManager = new GridLayoutManager(getContext(), 1);
        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setAdapter(commonAdapter);
        //下拉刷新
        mSwipeRefreshLayout.setColorSchemeResources(R.color.colorAccent);
        mSwipeRefreshLayout.setOnRefreshListener(mOnRefreshListener);
    }


    @Override
    protected int getLayoutRes() {
        return R.layout.fragment_dynamic;
    }

    @Override
    public void onGetInfoSuccess() {
        hideProgress();
        toast(getString(R.string.load_success));
    }

    @Override
    public void onGetInfoFail(BmobException e) {
        hideProgress();
        toast(e.getMessage());
    }

    @Override
    public void onRefreshMessage() {
        toast(getString(R.string.load_success));
    }

    @Override
    public CommonAdapter onGetAdapter() {
        return commonAdapter;
    }

    private SwipeRefreshLayout.OnRefreshListener mOnRefreshListener = new SwipeRefreshLayout.OnRefreshListener() {
        @Override
        public void onRefresh() {
            mIDynamicPresent.refreshMessage();
            mSwipeRefreshLayout.setRefreshing(false);
        }
    };

}
