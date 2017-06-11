package com.gechuangms.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import java.util.List;

/**
 * Created by Ezra on 2017/6/9.
 */

public abstract class CommonAdapter<T> extends RecyclerView.Adapter<ViewHolder> implements View.OnClickListener, View.OnLongClickListener {
    protected Context context;
    protected List<T> datas;

    protected int layoutId;

    public CommonAdapter(Context context, List<T> datas, int layoutId) {
        this.context = context;
        this.datas = datas;
        this.layoutId = layoutId;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ViewHolder viewHolder = ViewHolder.createViewHolder(context, parent, layoutId);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        T data = datas.get(position);
        convert(holder, data);
    }

    public abstract void convert(ViewHolder viewHolder, T t);

    @Override
    public int getItemCount() {
        return datas.size();
    }

    //自定义监听事件
    public static interface OnRecyclerViewItemClickListener {
        void onItemClick(View view);

        void onItemLongClick(View view);
    }

    private OnRecyclerViewItemClickListener mOnItemClickListener = null;

    public void setOnItemClickListener(OnRecyclerViewItemClickListener listener) {
        mOnItemClickListener = listener;
    }

    @Override
    public void onClick(View view) {
        if (mOnItemClickListener != null) {
            mOnItemClickListener.onItemClick(view);
        }
    }

    @Override
    public boolean onLongClick(View view) {
        if (mOnItemClickListener != null) {
            mOnItemClickListener.onItemLongClick(view);
        }
        return false;
    }

    ///////////////////////////////////////////////////////////////////////////
    // 对外开放的方法
    ///////////////////////////////////////////////////////////////////////////
    public void setListData(List<T> data) {
        datas.clear();
        datas.addAll(data);
        Log.i("Dy", "setListData: " + datas.size());
        notifyDataSetChanged();
    }

    public void addData(T t) {
        datas.add(t);
        notifyDataSetChanged();
    }

    public void addData(T t, int position) {
        datas.add(position, t);
        notifyItemChanged(position);
    }

    public void removeData(int position) {
        datas.remove(position);
        notifyItemRemoved(position);
    }

    public void removeData(T data) {
        int position = datas.indexOf(data);
        datas.remove(position);
        notifyItemRemoved(position);
    }

    public void clear() {
        datas.clear();
        notifyDataSetChanged();
    }
}
