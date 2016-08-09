package com.zellerpooh.mvpdemo;

import java.util.List;

/**
 * 处理girls的数据
 * Created by Zellerpooh on 16/8/4.
 */
public interface IGirlModel {
    //加载完成,回调
    void loadGirl(GirlOnloadListener girlOnloadListener);

    interface GirlOnloadListener{
        void onComplete(List<Girl> girls);
    }

}
