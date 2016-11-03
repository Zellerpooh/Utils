package com.zellerpooh.commonrecyclerview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Zellerpooh on 16/8/29.
 */
public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.MyViewHolder> {

    private Context mContext;
    private List<String> mDatas;

    private OnItemClickListener mOnItemClickListener;

    public HomeAdapter(Context context,List<String> datas){
        this.mContext=context;
        this.mDatas=datas;
    }
    public interface OnItemClickListener{
        void onItmClick(View view,int position);
        void onItemLongClick(View view, int position);
    }
    public void setOnItemClickListener(OnItemClickListener onItemClickLitener){
        this.mOnItemClickListener=onItemClickLitener;

    }
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        MyViewHolder holder=new MyViewHolder(LayoutInflater.from(mContext).inflate(R.layout.first_item_layout,parent,false));
        return holder;
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {
        holder.tv.setText(mDatas.get(position));

        //如果设置了回调,则设置点击事件
        if (mOnItemClickListener!=null){
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int pos=holder.getLayoutPosition();
                    mOnItemClickListener.onItmClick(holder.itemView,pos);
                }
            });

            holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    int pos=holder.getLayoutPosition();
                    mOnItemClickListener.onItemLongClick(holder.itemView,pos);
                    return false;
                }
            });

        }


    }

    @Override
    public int getItemCount() {
        return mDatas.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{
        TextView tv;
        public MyViewHolder(View view){
            super(view);
            tv= (TextView) view.findViewById(R.id.tv_item);
        }
    }
}
