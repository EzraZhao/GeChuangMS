package com.gechuangms.adapter;

import android.content.Context;
import android.view.ViewGroup;

import java.util.List;

/**
 * 多种ItemViewType
 * Created by Ezra on 2017/6/9.
 */

public class MultiItemCommonAdapter<T> extends CommonAdapter<T> {

    protected MultiItemTypeSupport<T> support;

    public MultiItemCommonAdapter(Context context, List<T> data, MultiItemTypeSupport support) {
        super(context, data, -1);
        this.support = support;
    }

    @Override
    public int getItemViewType(int position) {
        return support.getItemViewType(position, datas.get(position));
    }

    /**
     * @param parent
     * @param viewType 为 getItemViewType(int) 返回值
     * @return
     */
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        int layoutId = support.getLayoutId(viewType);
        ViewHolder viewHolder = ViewHolder.createViewHolder(context, parent, layoutId);
        return viewHolder;
    }

    @Override
    public void convert(ViewHolder viewHolder, T t) {

    }
}
