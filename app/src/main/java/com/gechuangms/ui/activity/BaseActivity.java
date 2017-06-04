package com.gechuangms.ui.activity;

import android.Manifest;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.gechuangms.R;
import com.gechuangms.app.Config;
import com.gechuangms.model.GCUser;

import org.litepal.tablemanager.Connector;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;

/**
 * Created by Ezra on 2017/5/29.
 */

public abstract class BaseActivity extends AppCompatActivity {

    public static final String TAG = "BaseActivity";

    private ProgressDialog mProgressDialog;
    private Handler mHandler = new Handler();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutRes());
        ButterKnife.bind(this);
        getPermission();
        init();
        createDataBase();
    }

    protected void init() {
    }

    public abstract int getLayoutRes();

    protected void startActivity(Class activity) {
        startActivity(activity, true);
    }

    protected void startActivity(Class activity, boolean finish) {
        Intent intent = new Intent(this, activity);
        startActivity(intent);
        if (finish) {
            finish();
        }
    }

    protected void showProgress(String msg) {
        if (mProgressDialog == null) {
            mProgressDialog = new ProgressDialog(this);
            mProgressDialog.setCancelable(true);
        }
        mProgressDialog.setMessage(msg);
        mProgressDialog.show();
    }

    protected void hideProgress() {
        if (mProgressDialog != null) {
            mProgressDialog.dismiss();
        }
    }

    protected void toast(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

    /**
     * 动态权限申请
     */
    private void getPermission() {
        List<String> permissionList = new ArrayList<>();
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_CONTACTS) != PackageManager.PERMISSION_GRANTED) {
            permissionList.add(Manifest.permission.READ_CONTACTS);
        }
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            permissionList.add(Manifest.permission.CALL_PHONE);
        }
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            permissionList.add(Manifest.permission.WRITE_EXTERNAL_STORAGE);
        }
        if (!permissionList.isEmpty()) {
            String[] permissions = permissionList.toArray(new String[permissionList.size()]);
            ActivityCompat.requestPermissions(this, permissions, Config.REQUEST_PERMISSION);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode) {
            case Config.REQUEST_PERMISSION:
                if (grantResults.length > 0) {
                    for (int result : grantResults) {
                        if (result != PackageManager.PERMISSION_GRANTED) {
                            toast(getResources().getString(R.string.must_acept_all_permission_can_use_app));
                            finish();
                            return;
                        }
                    }
                } else {
                    toast(getResources().getString(R.string.some_errors_happend));
                }
                break;
        }
    }

    protected void postDelay(Runnable runnable, long millis) {
        mHandler.postDelayed(runnable, millis);
    }

    private void createDataBase() {
        Connector.getDatabase();

        GCUser gcUser1 = new GCUser("2014201234", "123", Config.USER_GROUP_MEMBER, "17862511234");
        GCUser gcUser2 = new GCUser("2014202345", "123", Config.USER_GROUP_OFFICER, "17862511234");
        GCUser gcUser3 = new GCUser("2014203456", "123", Config.USER_GROUP_OFFICER, "17862511234");
        GCUser gcUser4 = new GCUser("2014204567", "123", Config.USER_GROUP_MEMBER, "17862511234");
        GCUser gcUser5 = new GCUser("2014205678", "123", Config.USER_GROUP_OFFICER, "17862511234");
        GCUser gcUser6 = new GCUser("2014206789", "123", Config.USER_GROUP_MEMBER, "17862511234");
        GCUser gcUser7 = new GCUser("2014207890", "123", Config.USER_GROUP_OFFICER, "17862511234");
        GCUser gcUser8 = new GCUser("2014208901", "123", Config.USER_GROUP_MEMBER, "17862511234");
        GCUser gcUser9 = new GCUser("2014209012", "123", Config.USER_GROUP_OFFICER, "17862511234");
        GCUser gcUser10 = new GCUser("2014200123", "123", Config.USER_GROUP_MEMBER, "17862511234");

        gcUser1.setUserSignature("If a thing is worth doing it is worth worth doing well.");
        gcUser1.save();
        gcUser2.save();
        gcUser3.save();
        gcUser4.save();
        gcUser5.save();
        gcUser6.save();
        gcUser7.save();
        gcUser8.save();
        gcUser9.save();
        gcUser10.save();

    }

}
