package com.zellerpooh.utils;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("add", String.valueOf(Arith.add(0.222,0.321)));
        Log.d("div", String.valueOf(Arith.div(0.222,0.321)));
        Log.d("mul", String.valueOf(Arith.mul(0.222,0.321)));
        Log.d("sub", String.valueOf(Arith.sub(0.222,0.321)));
    }
}
