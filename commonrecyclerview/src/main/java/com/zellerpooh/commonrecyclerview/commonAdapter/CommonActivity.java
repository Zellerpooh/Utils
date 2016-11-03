package com.zellerpooh.commonrecyclerview.commonAdapter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.zellerpooh.commonrecyclerview.R;

import java.util.ArrayList;
import java.util.List;

public class CommonActivity extends AppCompatActivity {

    private RecyclerView common_recyclerView;
    private List<String> mDatas;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_common);
        initData();
        common_recyclerView= (RecyclerView) findViewById(R.id.common_recyclerView);
        common_recyclerView.setLayoutManager(new LinearLayoutManager(this));
        common_recyclerView.setAdapter(new CommonAdapter<String>(this,R.layout.first_item_layout,mDatas) {
            @Override
            public void convert(final ViewHolder holder, String s) {
                holder.setText(R.id.tv_item,s);
                holder.setOnClickListener(R.id.layout_item, new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(CommonActivity.this,holder.getPosition()+"",Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });

    }
    protected void initData(){
        mDatas=new ArrayList<String>();
        for (int i = 'A'; i < 'z'; i++) {
            mDatas.add(""+(char)i);
        }
    }
}
