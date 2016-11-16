package com.example.axxui.myapplication.recycleview;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.axxui.myapplication.R;
import com.example.axxui.myapplication.utils.ToastUtil;

import java.util.ArrayList;

public class RecycleGridActivity extends AppCompatActivity {

    private RecyclerView recycle_view;
    private ArrayList<String> mList;
    private RecycleAdapter mAdapter;
    private Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycle);

        initData();
        mContext=this;
        recycle_view = (RecyclerView) findViewById(R.id.recycle_view);
        GridLayoutManager layoutManager=new GridLayoutManager(mContext,3);
        recycle_view.setLayoutManager(layoutManager);
        recycle_view.addItemDecoration(new DividerGridItemDecoration(mContext));
        mAdapter=new RecycleAdapter(mContext,mList);
        recycle_view.setAdapter(mAdapter);

        click();
    }

    private void click() {
        mAdapter.setOnItemClickListen(new RecycleAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                ToastUtil.show(mList.get(position));
            }

            @Override
            public void onItemLongCoick(View view, int position) {
                ToastUtil.show(mList.get(position)+"long");
            }
        });
    }

    private void initData() {
        if (mList==null) {
            mList=new ArrayList<>();
        }
        for (int i='A';i<='z';i++){
            mList.add((char)i+"");
        }
    }
}
