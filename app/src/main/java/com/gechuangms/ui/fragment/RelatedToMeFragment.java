package com.gechuangms.ui.fragment;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import com.gechuangms.R;
import com.gechuangms.adapter.CommonAdapter;
import com.gechuangms.adapter.ViewHolder;
import com.gechuangms.app.Config;
import com.gechuangms.model.GCMessage;
import com.gechuangms.presenter.IRelatedPresent;
import com.gechuangms.presenter.impl.RelatedPresentImpl;
import com.gechuangms.ui.activity.MessageActivity;
import com.gechuangms.view.IRelatedView;
import java.util.ArrayList;
import java.util.List;
import butterknife.BindView;
import cn.bmob.v3.exception.BmobException;

/**
 * Created by Ezra on 2017/5/29.
 */

public class RelatedToMeFragment extends BaseFragment implements IRelatedView {

    private static final String TAG = "RelatedToMeFragment";

    @BindView(R.id.related_recycler_view)
    RecyclerView mRecyclerView;
    @BindView(R.id.related_swipe_refresh)
    SwipeRefreshLayout mSwipeRefresh;


    private IRelatedPresent mIRelatedPresent;
    private CommonAdapter<GCMessage> commonAdapter;
    private List<GCMessage> messageList;

    @Override
    protected void init() {
        super.init();
        mIRelatedPresent = new RelatedPresentImpl(this);

        messageList = new ArrayList<>();

        showProgress(getString(R.string.load));
        mIRelatedPresent.loadMessage();

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
        mSwipeRefresh.setColorSchemeResources(R.color.colorAccent);
        mSwipeRefresh.setOnRefreshListener(mOnRefreshListener);
    }


    @Override
    protected int getLayoutRes() {
        return R.layout.frageent_realted;
    }

    @Override
    public void onRefreshMessage() {
        hideProgress();
    }

    @Override
    public void onGetMessageSuccess() {
        hideProgress();
        toast(getString(R.string.load_success));
    }

    @Override
    public void onGetMessageFail(BmobException e) {
        hideProgress();
        toast(e.getMessage());
    }

    @Override
    public CommonAdapter onGetAdapter() {
        return commonAdapter;
    }

    private SwipeRefreshLayout.OnRefreshListener mOnRefreshListener = new SwipeRefreshLayout.OnRefreshListener() {
        @Override
        public void onRefresh() {
            mIRelatedPresent.refreshMessage();
            mSwipeRefresh.setRefreshing(false);
        }
    };

}
