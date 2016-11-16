package com.example.axxui.myapplication;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.axxui.myapplication.recycleview.RecycleGridActivity;
import com.example.axxui.myapplication.recycleview.RecycleListActivity;
import com.example.axxui.myapplication.recycleview.RecycleWaterfallActivity;
import com.example.axxui.myapplication.utils.ToastUtil;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView rcv_main;
    private MainAdapter mRecycleAdapter;
    private ArrayList<String> list;
    private Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mContext=this;

        initData();
        mRecycleAdapter=new MainAdapter(this,list);
        mRecycleAdapter.setOnItemClickListener(new MainAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                String s=list.get(position);
                ToastUtil.show(s);
                Clickd(s);
            }

            @Override
            public void onItemLongClick(View view, int position) {
                String s=list.get(position);
                ToastUtil.show(s+"hahahah");
            }
        });
        rcv_main= (RecyclerView) findViewById(R.id.rcv_main);
        LinearLayoutManager layoutManager=new LinearLayoutManager(this);
        rcv_main.setLayoutManager(layoutManager);
        rcv_main.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL));
        rcv_main.setAdapter(mRecycleAdapter);
    }

    private void Clickd(String s) {
        switch (s){
            case "RecycleView-List":
                startActivity(new Intent(mContext, RecycleListActivity.class));
                break;
            case "RecycleView-Grid":
                startActivity(new Intent(mContext, RecycleGridActivity.class));
                break;
            case "RecycleView-瀑布":
                startActivity(new Intent(mContext, RecycleWaterfallActivity.class));
                break;
        }
    }

    private void initData() {
        if (list==null){
            list=new ArrayList<>();
        }
        list.add("RecycleView-List");
        list.add("RecycleView-Grid");
        list.add("RecycleView-瀑布");
    }
}
