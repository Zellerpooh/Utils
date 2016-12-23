package com.jinkworld.downloadmanager.pie;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.jinkworld.downloadmanager.R;

import java.util.ArrayList;

public class PieActivity extends AppCompatActivity {

    private PieView pieView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pie);
        pieView = (PieView) findViewById(R.id.pieView);

        ArrayList<PieData> datas = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            PieData piedata = new PieData("name" + i, i);
            datas.add(piedata);
        }
        pieView.setData(datas);
    }
}
