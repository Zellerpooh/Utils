package com.zellerpooh.mvpdemo;

import android.app.Activity;
import android.os.Bundle;
import android.os.PersistableBundle;

/**
 * Created by Zellerpooh on 16/8/4.
 */
public abstract class BaseActivity<V, T extends BasePresenter<V>> extends Activity {

    protected T mPresenter;

    @Override
    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        mPresenter = createPresenter();
        //关联View
        mPresenter.attachView((V) this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //解除关联
        mPresenter.detachView();
    }

    protected abstract T createPresenter();
}
