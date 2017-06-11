package com.gechuangms.ui.activity;

import android.content.Intent;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.gechuangms.R;
import com.gechuangms.app.Config;
import com.gechuangms.model.GCPrize;

import butterknife.BindView;

/**
 * 获奖详情
 * Created by Ezra on 2017/6/9.
 */

public class PrizeItemActivity extends BaseActivity {

    private static final String TAG = "PrizeItemActivity";

    @BindView(R.id.activity_prize_toobar)
    Toolbar mPrizeToobar;
    @BindView(R.id.iv_prize_image)
    ImageView mPrizeImage;
    @BindView(R.id.collapsing_toolbar)
    CollapsingToolbarLayout mCollapsingToolbar;
    @BindView(R.id.tv_prize_desc)
    TextView mTvPrizeDesc;

    private GCPrize mGcPrize;

    @Override

    protected void init() {
        super.init();

        Intent data = getIntent();
        mGcPrize = (GCPrize) data.getSerializableExtra(Config.PRIZE);

        setSupportActionBar(mPrizeToobar);

        mCollapsingToolbar.setTitle(mGcPrize.getInfo());
        Glide.with(this).load(mGcPrize.getImageUrl()).into(mPrizeImage);
        mTvPrizeDesc.setText(mGcPrize.getDesc());
    }

    @Override
    public int getLayoutRes() {
        return R.layout.activity_prize_item;
    }

}
