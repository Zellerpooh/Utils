package com.zellerpooh.mvpdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridLayout;
import android.widget.GridView;
import android.widget.Toast;

import java.util.List;

public class GirlGridActivity extends BaseActivity<IGirlView,GirlPresenter> implements IGirlView{
    private GridView gridView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_girl_grid);
        mPresenter.fetch();
        gridView= (GridView) findViewById(R.id.gridView);
    }

    @Override
    public void showLoading() {
        Toast.makeText(GirlGridActivity.this,"正在加载",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showGirls(List<Girl> girls) {
        gridView.setAdapter(new BaseAdapter() {
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

    @Override
    protected GirlPresenter createPresenter() {
        return new GirlPresenter();
    }
}
