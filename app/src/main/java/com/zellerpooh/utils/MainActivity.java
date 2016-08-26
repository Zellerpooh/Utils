package com.zellerpooh.utils;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.lang.ref.WeakReference;

/**
 * 测试activity
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("add", String.valueOf(Arith.add(0.222,0.321)));
        Log.d("div", String.valueOf(Arith.div(0.222,0.321)));
        Log.d("mul", String.valueOf(Arith.mul(0.222,0.321)));
        Log.d("sub", String.valueOf(Arith.sub(0.222,0.321)));
    }



    //使用弱引用的handler避免内存泄露,handler作为内部类使用时,会持有外部类Activity的引用,导致Activity无法销毁,会内存溢出.
    public abstract class WeakReferenceHandler<T> extends Handler {
        private WeakReference<T> mReference;

        public WeakReferenceHandler(T reference) {
            mReference = new WeakReference<T>(reference);
        }

        @Override
        public void handleMessage(Message msg) {
            if (mReference.get() == null) {
                return;
            }
            handleMessage(mReference.get(), msg);
        }
        protected abstract void handleMessage(T reference, Message msg);
    }
}
