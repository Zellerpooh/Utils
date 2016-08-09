package com.zellerpooh.mvpdemo;

import java.lang.ref.WeakReference;

/**
 * Created by Zellerpooh on 16/8/4.
 */
public abstract class BasePresenter<T> {

    protected WeakReference<T> mViewRef;

    /**
     * 关联(通过弱引用引用View对象)
     */
    public void attachView(T view) {

        mViewRef = new WeakReference<T>(view);
    }

    /**
     * 解除关联
     */
    public void detachView() {
        if (mViewRef != null) {
            mViewRef.clear();
            mViewRef = null;
        }
    }

    protected T getView(){
        return mViewRef.get();
    }
}
