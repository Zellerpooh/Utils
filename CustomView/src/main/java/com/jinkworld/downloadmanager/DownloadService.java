package com.jinkworld.downloadmanager;

import android.app.DownloadManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.widget.Toast;

/**
 * Created by Zellerpooh on 16/11/15.
 */

public class DownloadService {
    private DownloadManager downloadManager;
    private long id;
    private Context mContext;

    public DownloadService(Context context) {
        downloadManager = (DownloadManager) context.getSystemService(Context.DOWNLOAD_SERVICE);
        this.mContext = context;
    }

    public void download(String url) {
        DownloadManager.Request request = new DownloadManager.Request(Uri.parse(url));
        request.setAllowedNetworkTypes(DownloadManager.PAUSED_QUEUED_FOR_WIFI);
        request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE);
        request.setTitle("下载安装包...");
        id = downloadManager.enqueue(request);
        IntentFilter counterActionFilter = new IntentFilter(DownloadManager.ACTION_DOWNLOAD_COMPLETE);
        Receiver receiver = new Receiver();
        mContext.registerReceiver(receiver, counterActionFilter);
    }

    class Receiver extends BroadcastReceiver {

        @Override
        public void onReceive(Context context, Intent intent) {
            if (intent.getAction().equals(DownloadManager.ACTION_DOWNLOAD_COMPLETE)) {
                Uri uri = downloadManager.getUriForDownloadedFile(id);
                Toast.makeText(context, uri.toString(), Toast.LENGTH_SHORT).show();
                Intent intent1 = new Intent(Intent.ACTION_VIEW);
                intent1.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent1.setAction(android.content.Intent.ACTION_VIEW);
                intent1.setDataAndType(uri, "application/vnd.android.package-archive");
                mContext.startActivity(intent1);
            } else if (intent.getAction().equals(DownloadManager.ACTION_NOTIFICATION_CLICKED)) {

                Toast.makeText(context, "Clicked", Toast.LENGTH_SHORT).show();

            }
        }
    }
}
