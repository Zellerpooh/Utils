package com.zellerpooh.baseadapterrecyclerview.ryadapter.base;

/**
 * Created by Zellerpooh on 16/8/29.
 */
public interface ItemViewDelegate<T> {

    int getItemViewLayoutId();

    boolean isForViewType(T item,int position);

    void convert(ViewHolder holder,T t,int position);
}
