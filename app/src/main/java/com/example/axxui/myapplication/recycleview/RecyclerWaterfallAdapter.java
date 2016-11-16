package com.example.axxui.myapplication.recycleview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.axxui.myapplication.R;

import java.util.ArrayList;

/**
 * Created by axxui on 2016/11/16.
 */

public class RecyclerWaterfallAdapter extends RecyclerView.Adapter<RecyclerWaterfallAdapter.MyViewHolder> {

    private ArrayList<String> mList;
    private LayoutInflater inflater;
    private ArrayList<Integer> mHeights;

    public RecyclerWaterfallAdapter(Context context, ArrayList<String> mList) {
        this.mList = mList;
        this.inflater = LayoutInflater.from(context);
        mHeights = new ArrayList<>();
        for (int i = 0; i < mList.size(); i++) {
            mHeights.add((int) (100 + Math.random() * 300));
        }
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        MyViewHolder holder = new MyViewHolder(inflater.inflate(R.layout.adapt_recycle, parent, false));
        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        //设置textview的gao
        ViewGroup.LayoutParams lp=holder.tv_rcv.getLayoutParams();
        lp.height=mHeights.get(position);
        holder.tv_rcv.setLayoutParams(lp);

        holder.tv_rcv.setText(mList.get(position));

    }

    @Override
    public int getItemCount() {
        return mList != null ? mList.size() : 0;
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        private TextView tv_rcv;

        public MyViewHolder(View itemView) {
            super(itemView);
            tv_rcv = (TextView) itemView.findViewById(R.id.tv_rcv);
        }
    }
}
