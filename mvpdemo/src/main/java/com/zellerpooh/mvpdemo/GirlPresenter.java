package com.zellerpooh.mvpdemo;

import android.util.Log;

import java.util.List;

/**
 * Created by Zellerpooh on 16/8/4.
 * 中间者
 * 持有IGirlView,IGirlModel的引用
 * 通过fetch方法,连接View,Model
 */
public class GirlPresenter extends BasePresenter<IGirlView>{

    IGirlModel iGirlModel=new GirlModelImpl();



    /**
     * 将View和Model进行绑定
     */
   public void fetch(){
       getView().showLoading();
       //显示进度条
       getView().showLoading();
       iGirlModel.loadGirl(new IGirlModel.GirlOnloadListener() {
           @Override
           public void onComplete(List<Girl> girls) {
               Log.d("girls",girls.toString());
               getView().showGirls(girls);
           }
       });
   }



}
