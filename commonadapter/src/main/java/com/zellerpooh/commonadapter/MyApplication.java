package com.zellerpooh.commonadapter;

import android.app.Application;

import org.xutils.x;

/**
 * Created by Zellerpooh on 16/8/26.
 */
public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        x.Ext.init(this);
        x.Ext.setDebug(BuildConfig.DEBUG); // 开启debug会影响性能
    }
}
