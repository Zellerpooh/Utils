package com.zellerpooh.multiplethreaddownload;

import android.content.Context;

import java.io.File;

/**
 * Created by Zellerpooh on 16/8/16.
 */
public class DownloadEntity {
    //文件总长度
    long fileSize;
    //下载链接
    String downloadUrl;
    //线程Id
    int threadId;
    //起始下载位置
    long startLocation;
    //结束下载文章
    long endLocation;
    //下载文件
    File tempFile;
    Context context;

    public DownloadEntity(Context context,long fileSize,String downloadUrl,File file,
                          int threadId,long startLocation,long endLocation){

        this.context=context;
        this.downloadUrl=downloadUrl;
        this.tempFile=file;
        this.threadId=threadId;
        this.startLocation=startLocation;
        this.endLocation=endLocation;
        this.context=context;

    }
}
