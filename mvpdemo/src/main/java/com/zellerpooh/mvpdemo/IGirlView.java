package com.zellerpooh.mvpdemo;

import java.util.List;

/**
 * Created by Zellerpooh on 16/8/4.
 */
public interface IGirlView {

    /**
     * 显示正在加载
     */
    void showLoading();

    /**
     *显示girl
     */
    void showGirls(List<Girl> girls);
}
