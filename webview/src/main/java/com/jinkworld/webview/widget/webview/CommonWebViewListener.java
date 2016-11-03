package com.jinkworld.webview.widget.webview;

import android.webkit.WebView;

/**
 * 通用WebView的Listener
 * Created by Zellerpooh on 16/10/25.
 */

public interface CommonWebViewListener {
    /**
     * 页面加载进度
     */
    void onProgressChanged(int newProgress);

    /**
     * 页面加载完成
     */
    void onPageFinished(WebView view, String url);

    /**
     * 页面加载失败
     */
    void onPageError();

    /**
     * 拦截页面的跳转url，进行客户端url解析跳转
     */
    boolean shouldOverrideUrlLoading(String url);

    /**
     * 设置屏幕方向(横屏，竖屏)
     */
    void setScreenOrientation(int requestedOrientation);

    /**
     * 开始加载页面
     */
    void startPageLoad();
}
