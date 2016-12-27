package com.jinkworld.downloadmanager.lesson5;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.jinkworld.downloadmanager.R;

public class Lesson5Activity extends AppCompatActivity implements View.OnClickListener {

    private CheckView checkView;
    private Button check, unCheck;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson5);
        checkView = (CheckView) findViewById(R.id.checkView);
        check = (Button) findViewById(R.id.btn_check);
        unCheck = (Button) findViewById(R.id.btn_uncheck);
        check.setOnClickListener(this);
        unCheck.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_check:
                checkView.check();
                break;
            case R.id.btn_uncheck:
                checkView.unCheck();
                break;
        }
    }


}
