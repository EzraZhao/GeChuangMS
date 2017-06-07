package com.gechuangms.model;

import android.util.Log;

import com.gechuangms.R;

import java.util.List;

import cn.bmob.v3.BmobObject;
import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.FindListener;
import cn.bmob.v3.listener.SaveListener;
import cn.bmob.v3.listener.UpdateListener;

/**
 * Created by Ezra on 2017/6/7.
 */

public class GCMSVersion extends BmobObject {

    private static final String TAG = "GCMSVersion";

    private String mGcmsVersion = "0.1";

    public void setmGcmsVersion(String mGcmsVersion) {
        this.mGcmsVersion = mGcmsVersion;
    }

    public String getmGcmsVersion() {
        return mGcmsVersion;
    }

    public static void versionInit() {
        BmobQuery<GCMSVersion> vQuery = new BmobQuery<>();
        vQuery.findObjects(new FindListener<GCMSVersion>() {
            @Override
            public void done(List<GCMSVersion> list, BmobException e) {
                if (list == null || list.size() == 0) {
                    creteGCMSVersionToBmob();
                    return;
                }
            }
        });
    }

    private static void creteGCMSVersionToBmob() {
        GCMSVersion gcmsVersion = new GCMSVersion();
        gcmsVersion.save(new SaveListener<String>() {
            @Override
            public void done(String s, BmobException e) {
            }
        });
    }

    public static void versionAdd() {
        BmobQuery<GCMSVersion> vQuery = new BmobQuery<>();
        vQuery.findObjects(new FindListener<GCMSVersion>() {
            @Override
            public void done(List<GCMSVersion> list, BmobException e) {
                if (e == null) {
                    GCMSVersion gcmsVersion = new GCMSVersion();
                    String oldVersion = gcmsVersion.mGcmsVersion;
                    double i = Double.valueOf(oldVersion);
                    String newVersion = String.valueOf(i + 0.1);
                    gcmsVersion.update(new UpdateListener() {
                        @Override
                        public void done(BmobException e) {
                            if (e != null) {
                                Log.i(TAG, "done: " + R.string.updata_version_error);
                            }
                        }
                    });
                } else {
                    Log.i(TAG, "done: " + R.string.upload_version_error);
                }
            }
        });
    }
}
