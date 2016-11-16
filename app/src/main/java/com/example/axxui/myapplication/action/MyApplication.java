package com.example.axxui.myapplication.action;

import android.app.Application;
import android.content.Context;

/**
 * Created by axxui on 2016/11/14.
 */

public class MyApplication extends Application {

    private static Context mContext;
    @Override
    public void onCreate() {
        super.onCreate();
        mContext=this;
    }

    public static Context getContext(){
        return mContext;
    }
}
