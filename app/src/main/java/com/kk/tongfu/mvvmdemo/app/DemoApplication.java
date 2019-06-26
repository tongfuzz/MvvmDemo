package com.kk.tongfu.mvvmdemo.app;

import android.app.Application;

/**
 * Created by tongfu
 * on 2019/6/26
 * Desc:
 */

public class DemoApplication extends Application {

    private static DemoApplication mDemoApplication;

    @Override
    public void onCreate() {
        super.onCreate();
        mDemoApplication=this;
    }

    public static DemoApplication getInstance(){
        return mDemoApplication;
    }
}
