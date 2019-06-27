package com.kk.tongfu.mvvmdemo.util;

import android.support.annotation.ColorRes;
import android.support.annotation.StringRes;
import android.support.v4.content.ContextCompat;

import com.kk.tongfu.mvvmdemo.app.DemoApplication;

/**
 * Created by tongfu
 * on 2019/6/27
 * Desc:
 */

public final class ResourceUtils {

    private ResourceUtils(){

    }

    public static String getString(@StringRes int resId){
        return DemoApplication.getInstance().getString(resId);
    }

    public static int getColor(@ColorRes int resId){
        return ContextCompat.getColor(DemoApplication.getInstance(),resId);
    }
}
