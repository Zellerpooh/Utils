package com.zellerpooh.commonadapter.baseadapter;

/**
 * Created by Zellerpooh on 16/8/26.
 */
public interface MultiItemTypeSupport<T>
{
    int getLayoutId(int position , T t);

    int getViewTypeCount();

    int getItemViewType(int postion,T t );
}
