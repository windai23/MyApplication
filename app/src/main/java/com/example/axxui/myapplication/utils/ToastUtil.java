package com.example.axxui.myapplication.utils;

import android.widget.Toast;

import com.example.axxui.myapplication.action.MyApplication;

/**
 * Created by axxui on 2016/11/14.
 */

public class ToastUtil {

    private static Toast toast;
    public static void show(String text){
        if(toast==null){
            toast=Toast.makeText(MyApplication.getContext(),text,Toast.LENGTH_SHORT);
        }
        toast.setText(text);
        toast.show();
    }
}
