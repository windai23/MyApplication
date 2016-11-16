package com.example.axxui.myapplication.utils;

import android.util.Log;

/**
 * Created by axxui on 2016/11/14.
 */

public class LogUtil {

    private static boolean is=true;
    public static void e(String s){
        if (is){
            Log.e("ahahah","------>>>>>"+s);
        }
    }

    public static void e(Object o,String s){
        if (is) {
            Log.e(o.getClass().getSimpleName(),"--------->>>>>"+s);
        }
    }
}
