package com.zellerpooh.commonadapter;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import com.zellerpooh.commonadapter.baseadapter.BaseAdapterHelper;
import com.zellerpooh.commonadapter.baseadapter.QuickAdapter;
import com.zellerpooh.commonadapter.entity.New;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.ViewInject;

import java.util.ArrayList;
import java.util.List;

/**
 * 简单Demo for CommonAdapter
 */

@ContentView(R.layout.activity_main)
public class MainActivity extends BaseActivity {

    @ViewInject(R.id.lv_main)
    private ListView listView;
    private List<New> mDatas = new ArrayList<New>();
    private NewAdapter myAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initData();
        myAdapter=new NewAdapter(this,R.layout.item_layout,mDatas);
        listView.setAdapter(myAdapter);

    }

    private void initData() {
        for (int i = 0; i < 20; i++) {
            New mNew=new New("坚持","不经一番彻骨寒,怎得梅花扑鼻香","https://ss0.bdstatic.com/94oJfD_bAAcT8t7mm9GUKT-xh_/timg?image&quality=100&size=b4000_4000&sec=1472199126&di=037683551a487cd5e8ca2e9c63cf59b6&src=http://tupian.enterdesk.com/2013/mxy/10/12/3/5.jpg");
            mDatas.add(mNew);
        }
    }


    private class NewAdapter extends QuickAdapter<New>{


        public NewAdapter(Context context, int layoutResId, List<New> data) {
            super(context, layoutResId, data);
        }

        @Override
        protected void convert(BaseAdapterHelper helper, final New item) {
            helper.setText(R.id.tv_title,item.getTitle());
            helper.setText(R.id.tv_content,item.getContent());
            helper.setImageUrl(R.id.iv_img,item.getUrl());
            helper.setOnClickListener(R.id.iv_img, new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(MainActivity.this,item.getTitle(),Toast.LENGTH_SHORT).show();
                }
            });

        }
    }
}
