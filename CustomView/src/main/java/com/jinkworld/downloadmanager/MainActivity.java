package com.jinkworld.downloadmanager;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ScrollView;

import com.jinkworld.downloadmanager.aige.lesson1.Lesson1Activity;
import com.jinkworld.downloadmanager.commandpattern.DrawActivity;
import com.jinkworld.downloadmanager.lesson5.Lesson5Activity;
import com.jinkworld.downloadmanager.lesson6.Lesson6Activity;
import com.jinkworld.downloadmanager.lesson7.Lesson7Activity;
import com.jinkworld.downloadmanager.memotopattern.MemotoActivity;
import com.jinkworld.downloadmanager.pie.PieActivity;

public class MainActivity extends AppCompatActivity {
    public static final String load_url = "http://qiniu-app-cdn.pgyer.com/ce0346232b634a6cb1f39ec16f4f2b75.apk?e=1479175852&attname=app-debug.apk&token=6fYeQ7_TVB5L0QSzosNFfw2HU8eJhAirMF5VxV9G:6J3UdcR77rxqFbC2-AYU-zM4kCk=";
    private ScrollView scrollView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        scrollView = (ScrollView) findViewById(R.id.scrollView);
    }

    public void download(View view) {
        DownloadService downloadService = new DownloadService(this);
        downloadService.download(load_url);
    }

    public void lesson1(View view) {
        Intent intent = new Intent(this, Lesson1Activity.class);
        startActivity(intent);
    }

    public void pieView(View view) {
        Intent intent = new Intent(this, PieActivity.class);
        startActivity(intent);
    }

    public void lesson5(View v) {
        Intent intent = new Intent(this, Lesson5Activity.class);
        startActivity(intent);
    }

    public void lesson6(View view) {
        Intent intent = new Intent(this, Lesson6Activity.class);
        startActivity(intent);
    }

    public void lesson7(View view) {
        Intent intent = new Intent(this, Lesson7Activity.class);
        startActivity(intent);
    }

    public void drawLesson(View view) {
        Intent intent = new Intent(this, DrawActivity.class);
        startActivity(intent);
    }

    public void memotoclick(View view) {
        Intent intent = new Intent(this, MemotoActivity.class);
        startActivity(intent);
    }

}
