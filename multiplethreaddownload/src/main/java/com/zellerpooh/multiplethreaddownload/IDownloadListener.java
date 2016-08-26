package com.zellerpooh.multiplethreaddownload;

import java.net.HttpURLConnection;

/**
 * 下载监听
 * Created by Zellerpooh on 16/8/16.
 */
public interface IDownloadListener {
    /**
     * 取消下载
     */
    public void onCancle();

    /**
     * 下载失败
     */
    public void onFail();

    /**
     * 下载预处理可以通过httpURLConnection获取文件长度
     * @param connection
     */
    public void onPreDownload(HttpURLConnection connection);

    /**
     * 下载监听
     * @param currentLocation
     */
    public void onProgress(long currentLocation);

    public void onStart(long startLocation);
    /**
     *子线程恢复下载的位置
     */
    public void onChildResume(long resumeLocation);

    /**
     * 恢复位置
     * @param resumeLocation
     */
    public void onResume(long resumeLocation);

    /**
     * 停止
     * @param stopLocation
     */
    public void onStop(long stopLocation);

    /**
     * 下载完成
     */
    public void onComplete();

}
