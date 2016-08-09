package com.zellerpooh.mvpdemo;

import android.util.Log;

import java.util.List;

/**
 * Created by Zellerpooh on 16/8/4.
 */
public class GirlPresenter2 {
    IGirlView mGirlView ;
    IGirlModel mGirlModel=new GirlModelImpl();

    public GirlPresenter2(IGirlView mGirlView) {
        this.mGirlView = mGirlView;
    }

    /**
     * 将View和Model进行绑定
     */
    public void fetch(){
        //显示进度条
        mGirlView.showLoading();
        mGirlModel.loadGirl(new IGirlModel.GirlOnloadListener() {
            @Override
            public void onComplete(List<Girl> girls) {
                Log.d("girls",girls.toString());
                mGirlView.showGirls(girls);
            }
        });
    }
}
