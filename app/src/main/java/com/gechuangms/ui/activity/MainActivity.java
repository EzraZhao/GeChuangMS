package com.gechuangms.ui.activity;

import android.support.annotation.IdRes;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import com.gechuangms.R;
import com.gechuangms.factory.FragmentFactory;
import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.OnTabSelectListener;

import butterknife.BindView;
import cn.bmob.v3.BmobUser;

public class MainActivity extends BaseActivity implements View.OnClickListener {

    private static final String TAG = "MainActivity";

    @BindView(R.id.bottomBar)
    BottomBar mBottomBar;
    @BindView(R.id.fragment_container)
    FrameLayout mFragmentContainer;
    @BindView(R.id.main_toobar)
    Toolbar mToobar;
    @BindView(R.id.drawer_layout)
    DrawerLayout mDrawerLayout;
    @BindView(R.id.main_nav_header)
    LinearLayout navHeader;
    @BindView(R.id.nav_brief_introduction)
    LinearLayout navBriefIntroduction;
    @BindView(R.id.nav_elegant_demeanour)
    LinearLayout navElegantDemeanour;
    @BindView(R.id.nav_about_us)
    LinearLayout navAboutUs;
    @BindView(R.id.nav_new_blood)
    LinearLayout navNewBlood;
    @BindView(R.id.nav_log_out)
    Button navLogOut;

    private FragmentManager mFragmentManager;

    @Override
    public int getLayoutRes() {
        return R.layout.activity_main;
    }

    synchronized
    @Override
    protected void init() {
        super.init();
        Log.i(TAG, "init");

        //设置fragment切换监听
        mFragmentManager = getSupportFragmentManager();
        mBottomBar.setOnTabSelectListener(mOnTabSelectListener);
        setSupportActionBar(mToobar);
        //设置actionBar（侧滑界面提示按钮）
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setHomeAsUpIndicator(R.mipmap.ic_logo_menu);
        }

        //设置相关控件点击事件
        navHeader.setOnClickListener(this);
        navBriefIntroduction.setOnClickListener(this);
        navElegantDemeanour.setOnClickListener(this);
        navAboutUs.setOnClickListener(this);
        navNewBlood.setOnClickListener(this);
        navLogOut.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.main_nav_header:
                startActivity(UpdataUserInfoActivity.class,false);
                break;
            case R.id.nav_brief_introduction:
                startActivity(IntroductionActivity.class, false);
                break;
            case R.id.nav_elegant_demeanour:
                startActivity(PrizeActivity.class, false);
                break;
            case R.id.nav_about_us:
                startActivity(AboutUsActivity.class, false);
                break;
            case R.id.nav_new_blood:
                startActivity(NewBloodActivity.class, false);
                break;
            case R.id.nav_log_out:
                BmobUser.logOut();
                startActivity(LoginActivity.class);
                break;
        }
    }

    private OnTabSelectListener mOnTabSelectListener = new OnTabSelectListener() {
        @Override
        public void onTabSelected(@IdRes int tabId) {
            FragmentTransaction fragmentTransaction = mFragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.fragment_container, FragmentFactory.getInstance().getFragment(tabId)).commit();
        }
    };

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                mDrawerLayout.openDrawer(GravityCompat.START);
                break;
            case R.id.toolbar_something:
                toast("something");
                break;
        }
        return true;
    }

}
