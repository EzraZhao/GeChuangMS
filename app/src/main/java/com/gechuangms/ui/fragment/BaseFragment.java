package com.gechuangms.ui.fragment;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.io.Serializable;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by Ezra on 2017/5/29.
 */

public abstract class BaseFragment extends Fragment {

    public static final String TAG = "BaseFragment";

    private ProgressDialog mProgressDialog;
    private Unbinder unbinder;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(getLayoutRes(), null);
        unbinder = ButterKnife.bind(this, root);
        init();
        return root;
    }

    protected void init() {
        Log.d(TAG, "init: ");
    }

    protected abstract int getLayoutRes();

    protected void showProgress(String msg) {
        if (mProgressDialog == null) {
            mProgressDialog = new ProgressDialog(getContext());
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
        Toast.makeText(getContext(), msg, Toast.LENGTH_SHORT).show();
    }

    protected void startActivity(Class activity) {
        startActivity(activity, false);
    }

    protected void startActivity(Class activity, String key, String extra) {
        Intent intent = new Intent(getContext(), activity);
        intent.putExtra(key, extra);
        startActivity(intent);
    }

    protected void startActivity(Class activity, String key, Serializable s) {
        Intent intent = new Intent(getContext(), activity);
        intent.putExtra(key, s);
        startActivity(intent);
    }

    protected void startActivity(Class activity, boolean finish) {
        Intent intent = new Intent(getContext(), activity);
        startActivity(intent);
        if (finish) {
            getActivity().finish();
        }
    }

    /**
     *  Reset ProgressDialog when finish activity, since we will reuse the fragment created before,
     *  and the dialog refer to the finished activity if we not reset here.
     */
    @Override
    public void onDestroy() {
        super.onDestroy();
        mProgressDialog = null;
        if (unbinder != null) {
            unbinder.unbind();
        }
    }

}
