package com.jinkworld.webview;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;
import android.widget.Toast;

import com.jinkworld.webview.widget.webview.BaseWebActivity;
import com.jinkworld.webview.widget.webview.CommonWebViewListener;

/**
 * Created by Zellerpooh on 16/10/27.
 */

public class SampleActivity extends BaseWebActivity {
    private String url = "";
    private Intent intent;
    private static final String TAG = "SampleActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //设置标题
        url = getIntent().getStringExtra("URL");

        if (savedInstanceState != null) {
            mWebView.restoreState(savedInstanceState);
        } else {
            mWebView.initWebView(new CommonWebViewListener() {
                @Override
                public void onProgressChanged(int newProgress) {
                    Log.d(TAG, "newProgress:" + newProgress);
                    if (newProgress == 100) {
                        progressBar.setVisibility(View.GONE);
                    }
                    progressBar.setProgress(newProgress);
                }

                @Override
                public void onPageFinished(WebView view, String url) {
                    Log.d(TAG, "onPageFinished" + "url:" + url);
                }

                @Override
                public void onPageError() {

                }

                @Override
                public boolean shouldOverrideUrlLoading(String url) {
                    Log.d(TAG, "shouldOverrideUrlLoading:" + url);
                    if (url.contains("www.jianshu.com/p")) {
                        Toast.makeText(SampleActivity.this, "override", Toast.LENGTH_SHORT).show();
                    }
                    mWebView.loadUrl(url);
                    return true;
                }

                @Override
                public void setScreenOrientation(int requestedOrientation) {

                }

                @Override
                public void startPageLoad() {
                    progressBar.setVisibility(View.VISIBLE);
                }
            });
        }
        mWebView.loadUrl(url);
    }

}
