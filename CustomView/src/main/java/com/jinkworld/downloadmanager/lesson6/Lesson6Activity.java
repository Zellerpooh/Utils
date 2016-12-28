package com.jinkworld.downloadmanager.lesson6;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.jinkworld.downloadmanager.R;

public class Lesson6Activity extends AppCompatActivity {

    private RadarView radarView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson6);
        radarView = (RadarView) findViewById(R.id.radarView);
    }

    public void changeClick(View view) {
        String[] titles = new String[]{"法语", "日语", "英语", "德语", "中文"};
        double[] data = new double[]{75, 50, 100, 26, 45};
        radarView.setTitles(titles);
        radarView.setData(data);
    }
}