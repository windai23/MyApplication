package com.example.axxui.myapplication.recycleview;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;

import com.example.axxui.myapplication.R;

import java.util.ArrayList;

/**
 * recycleView 之瀑布流
 */
public class RecycleWaterfallActivity extends AppCompatActivity {

    private ArrayList<String> mList;
    private Context mContext;
    private RecyclerWaterfallAdapter adapter;
    private RecyclerView recycle_view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycle);

        mContext=this;
        initData();

        adapter=new RecyclerWaterfallAdapter(mContext,mList);
        recycle_view = (RecyclerView) findViewById(R.id.recycle_view);
        StaggeredGridLayoutManager layoutManager=new StaggeredGridLayoutManager(3,StaggeredGridLayoutManager.VERTICAL);
        recycle_view.setLayoutManager(layoutManager);
        recycle_view.addItemDecoration(new DividerGridItemDecoration(mContext));
        recycle_view.setAdapter(adapter);
    }

    private void initData() {
        if (mList==null){
            mList=new ArrayList<>();
        }

        for (int i='A';i<='z';i++){
            mList.add((char)i+"");
        }
    }
}
