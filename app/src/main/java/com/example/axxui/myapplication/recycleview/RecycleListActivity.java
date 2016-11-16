package com.example.axxui.myapplication.recycleview;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.axxui.myapplication.R;
import com.example.axxui.myapplication.utils.ToastUtil;

import java.util.ArrayList;

/**
 * recycleView之listView
 */

public class RecycleListActivity extends AppCompatActivity {

    private SwipeRefreshLayout refreshLayout;
    private RecyclerView recycle_view;
    private ArrayList<String> list;
    private RecycleAdapter mRecycleAdapter;
    private Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycle);

        initData();
        mContext = this;
        refreshLayout = (SwipeRefreshLayout) findViewById(R.id.refreshLayout);
        onRefreshListen();

        mRecycleAdapter = new RecycleAdapter(mContext, list);
        recycle_view = (RecyclerView) findViewById(R.id.recycle_view);

        //第二个参数表示方向,第三个表示顺序,true表示反向
        LinearLayoutManager layoutManager = new LinearLayoutManager(mContext, LinearLayoutManager.VERTICAL, false);
        recycle_view.setLayoutManager(layoutManager);
        recycle_view.addItemDecoration(new DividerItemDecoration(mContext, DividerItemDecoration.VERTICAL_LIST));
        recycle_view.setAdapter(mRecycleAdapter);
        onClick();
    }
    private int a=0;
    private int b=a+10;
    private void onRefreshListen() {

        refreshLayout.post(new Runnable() {
            @Override
            public void run() {
                refreshLayout.setRefreshing(true);
            }
        });


        refreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                for (; a < b; a++) {
                    list.add(a+"");
                    mRecycleAdapter.notifyDataSetChanged();
                }
            }
        });
    }

    private void onClick() {
        mRecycleAdapter.setOnItemClickListen(new RecycleAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                ToastUtil.show(list.get(position));
            }

            @Override
            public void onItemLongCoick(View view, int position) {

            }
        });
    }

    private void initData() {
        if (list == null) {
            list = new ArrayList<>();
        }
        for (int i = 'A'; i <= 'z'; i++) {
            list.add((char) i + "");
        }
    }
}
