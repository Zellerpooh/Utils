package com.jinkworld.webview;

import android.content.Intent;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {


    @BindView(R.id.btn_towebview)
    Button btnTowebview;
    @BindView(R.id.webView_qq)
    WebView webViewQq;
    @BindView(R.id.activity_main)
    LinearLayout activityMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        webViewQq.loadUrl("file:///android_asset/my.html");

        ImageView androidImageView = (ImageView) findViewById(R.id.android);
        Drawable drawable = androidImageView.getDrawable();
        if (drawable instanceof Animatable) {
            ((Animatable) drawable).start();
        }
        ImageView startImageView = (ImageView) findViewById(R.id.star);
        Drawable starDrawable = startImageView.getDrawable();
        if (starDrawable instanceof Animatable) {
            ((Animatable) starDrawable).start();
        }
        ImageView   squareImageView = (ImageView) findViewById(R.id.square);
        Drawable squareDrawable = squareImageView.getDrawable();
        if (squareDrawable instanceof Animatable) {
            ((Animatable) squareDrawable).start();
        }

    }


    @OnClick(R.id.btn_towebview)
    public void onClick() {
        Intent intent = new Intent(this, SampleActivity.class);
        intent.putExtra("URL", "http://www.jianshu.com/");
        startActivity(intent);
    }
}
