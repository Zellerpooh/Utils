package com.zellerpooh.commonadapter.baseadapter;

import android.content.Context;

import java.util.List;

/**
 * Created by Zellerpooh on 16/8/26.
 */
public abstract class EnhancedQuickAdapter<T> extends QuickAdapter<T> {

    /**
     * Create a QuickAdapter.
     * @param context     The context.
     * @param layoutResId The layout resource id of each item.
     */
    public EnhancedQuickAdapter(Context context, int layoutResId) {
        super(context, layoutResId);
    }

    /**
     * Same as QuickAdapter#QuickAdapter(Context,int) but with
     * some initialization data.
     * @param context     The context.
     * @param layoutResId The layout resource id of each item.
     * @param data        A new list is created out of this one to avoid mutable list
     */
    public EnhancedQuickAdapter(Context context, int layoutResId, List<T> data) {
        super(context, layoutResId, data);
    }

    @Override
    protected final void convert(BaseAdapterHelper helper, T item) {
        boolean itemChanged = helper.associatedObject == null || !helper.associatedObject.equals(item);
        helper.associatedObject = item;
        convert(helper, item, itemChanged);
    }

    /**
     * @param helper      The helper to use to adapt the view.
     * @param item        The item you should adapt the view to.
     * @param itemChanged Whether or not the helper was bound to another object before.
     */
    protected abstract void convert(BaseAdapterHelper helper, T item, boolean itemChanged);
}
