package com.gechuangms.adapter;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.gechuangms.R;
import com.gechuangms.model.GCMessage;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Ezra on 2017/5/31.
 */

public class DynamicMessageAdapter extends RecyclerView.Adapter<DynamicMessageAdapter.ViewHolder> {

    private static final String TAG = "DynamicMessageAdapter";

    private Context mContext;
    protected List<GCMessage> mGcMessageList;

    public DynamicMessageAdapter(List<GCMessage> mGcMessageList) {
        Log.i(TAG, "DynamicMessageAdapter");
        this.mGcMessageList = mGcMessageList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (mContext == null) {
            mContext = parent.getContext();
        }
        View view = LayoutInflater.from(mContext).inflate(R.layout.fragment_dynamic_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Log.i(TAG, "onBindViewHolder");
        GCMessage gcMessage = mGcMessageList.get(position);
        holder.mMessageTitle.setText(gcMessage.getMessageTitle());
        Glide.with(mContext).load(gcMessage.getMessageImageId()).into(holder.mMessageImage);
    }

    @Override
    public int getItemCount() {
        return mGcMessageList.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {


        CardView mCardView;
        @BindView(R.id.iv_message_image)
        ImageView mMessageImage;
        @BindView(R.id.tv_message_title)
        TextView mMessageTitle;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            mCardView = (CardView) itemView;
        }
    }


}
