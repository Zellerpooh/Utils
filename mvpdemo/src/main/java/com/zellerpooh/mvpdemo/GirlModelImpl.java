package com.zellerpooh.mvpdemo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Zellerpooh on 16/8/4.
 */
public class GirlModelImpl implements IGirlModel {
    @Override
    public void loadGirl(GirlOnloadListener girlOnloadListener) {
        //模拟加载数据

        List<Girl> data=new ArrayList<>();
        girlOnloadListener.onComplete(data);
    }
}
