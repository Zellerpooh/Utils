package com.jinkworld.downloadmanager.aige.lesson1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.jinkworld.downloadmanager.R;

public class Lesson1Activity extends AppCompatActivity {

    private CustomView lesson1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson1);
        lesson1 = (CustomView) findViewById(R.id.activity_lesson1);
        new Thread(lesson1).start();
    }
}
