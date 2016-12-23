package com.jinkworld.downloadmanager;

import android.app.DownloadManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.widget.Toast;

public class DownloadReceiver extends BroadcastReceiver {
    public DownloadReceiver() {
    }

    @Override
    public void onReceive(Context context, Intent intent) {

        if (intent.getAction().equals(DownloadManager.ACTION_DOWNLOAD_COMPLETE)) {




        } else if (intent.getAction().equals(DownloadManager.ACTION_NOTIFICATION_CLICKED)) {

            Toast.makeText(context, "Clicked", Toast.LENGTH_SHORT).show();

        }
    }
}
