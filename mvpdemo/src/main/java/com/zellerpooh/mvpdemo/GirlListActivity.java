package com.zellerpooh.mvpdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

public class GirlListActivity extends AppCompatActivity implements IGirlView {
    private ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_girl_list);
        listView= (ListView) findViewById(R.id.listView);
        new GirlPresenter(this).fetch();
    }

    @Override
    public void showLoading() {
        Toast.makeText(this,"正在加载",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showGirls(List<Girl> girls) {
        listView.setAdapter(new BaseAdapter() {
            @Override
            public int getCount() {
                return 0;
            }

            @Override
            public Object getItem(int position) {
                return null;
            }

            @Override
            public long getItemId(int position) {
                return 0;
            }

            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                return null;
            }
        });
    }
}
