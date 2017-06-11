package com.gechuangms.ui.activity;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.gechuangms.R;
import com.gechuangms.adapter.CommonAdapter;
import com.gechuangms.adapter.ViewHolder;
import com.gechuangms.app.Config;
import com.gechuangms.model.GCPrize;
import com.gechuangms.presenter.IPrizePresenter;
import com.gechuangms.presenter.impl.PrizePresentImpl;
import com.gechuangms.view.IPrizeView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import cn.bmob.v3.exception.BmobException;

/**
 * 获奖列表
 * Created by Ezra on 2017/6/10.
 */

public class PrizeActivity extends BaseActivity implements IPrizeView {

    private static final String TAG = "PrizeActivity";

    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;
    @BindView(R.id.swipe_refresh)
    SwipeRefreshLayout swipeRefresh;

    private IPrizePresenter mIPrizePresenter;
    private CommonAdapter<GCPrize> commonAdapter;
    private List<GCPrize> prizeList;

    @Override
    protected void init() {
        super.init();

        prizeList = new ArrayList<>();

        mIPrizePresenter = new PrizePresentImpl(this);

        showProgress(getString(R.string.load));
        mIPrizePresenter.loadInfo();

        initView();
    }

    private void initView() {

        commonAdapter = new CommonAdapter<GCPrize>(this, prizeList, R.layout.prize_item) {
            @Override
            public void convert(ViewHolder viewHolder, final GCPrize gcPrize) {
                viewHolder.setText(R.id.tv_prize_item_info, gcPrize.getInfo())
                        .setBitmapFromUrl(R.id.iv_prize_item_image, gcPrize.getImageUrl())
                        .setOnClickListener(R.id.cv_prize_item, new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                startActivity(PrizeItemActivity.class, Config.PRIZE, gcPrize);
                            }
                        });
            }
        };

        //瀑布流布局
        StaggeredGridLayoutManager layoutManager = new
                StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(commonAdapter);

        swipeRefresh.setColorSchemeResources(R.color.colorAccent);
        swipeRefresh.setOnRefreshListener(mOnRefreshListener);
    }

    @Override
    public int getLayoutRes() {
        return R.layout.activity_prize;
    }

    private SwipeRefreshLayout.OnRefreshListener mOnRefreshListener = new SwipeRefreshLayout.OnRefreshListener() {
        @Override
        public void onRefresh() {
            mIPrizePresenter.refresh();
            swipeRefresh.setRefreshing(false);
        }
    };

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
    public void onRefershSuccess() {
        toast(getString(R.string.load_success));
    }

    @Override
    public CommonAdapter onGetAdapter() {
        return commonAdapter;
    }

}
