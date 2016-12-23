package com.jinkworld.autolayout.login;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.jinkworld.autolayout.R;
import com.jinkworld.autolayout.widget.LoginTitle;

import butterknife.BindView;
import butterknife.ButterKnife;

public class IndexActivity extends AppCompatActivity {

    @BindView(R.id.loginTitle)
    LoginTitle loginTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_index);
        ButterKnife.bind(this);
        loginTitle.setOnTitleClickChangeListener(new LoginTitle.OnTitleClickChangeListener() {
            @Override
            public void login() {
                Toast.makeText(IndexActivity.this, "login", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void reg() {
                Toast.makeText(IndexActivity.this, "reg", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
