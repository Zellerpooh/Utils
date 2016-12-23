package com.jinkworld.autolayout.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.jinkworld.autolayout.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Zellerpooh on 16/11/7.
 */

public class LoginTitle extends LinearLayout {
    private static final String TAG = "LoginTitle";
    private boolean isLoginChecked = true;
    @BindView(R.id.rl_login)
    RelativeLayout rlLogin;
    @BindView(R.id.rl_reg)
    RelativeLayout rlReg;
    @BindView(R.id.tv_login)
    TextView tvLogin;
    @BindView(R.id.tv_reg)
    TextView tvReg;
    private Context mContext;

    public LoginTitle(Context context) {
        this(context, null);
    }

    public LoginTitle(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    private void init(Context context) {
        mContext = context;
        LayoutInflater.from(context).inflate(R.layout.login_title, this, true);
        ButterKnife.bind(this);

    }


    @OnClick({R.id.tv_login, R.id.tv_reg})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_login:
                if (!isLoginChecked) {
                    rlLogin.setBackgroundColor(getResources().getColor(R.color.carissma));
                    rlReg.setBackgroundColor(getResources().getColor(R.color.zircon));
                    if (onTitleClickChangeListener != null) {
                        onTitleClickChangeListener.login();
                        isLoginChecked = true;
                    }
                }
                break;
            case R.id.tv_reg:
                if (isLoginChecked) {
                    rlReg.setBackgroundColor(getResources().getColor(R.color.carissma));
                    rlLogin.setBackgroundColor(getResources().getColor(R.color.zircon));
                    if (onTitleClickChangeListener != null) {
                        onTitleClickChangeListener.reg();
                        isLoginChecked = false;
                    }
                }
                break;
        }
    }

    /**
     * 切换登陆注册的接口
     */
    public interface OnTitleClickChangeListener {
        void login();

        void reg();
    }

    private OnTitleClickChangeListener onTitleClickChangeListener;

    public void setOnTitleClickChangeListener(OnTitleClickChangeListener onTitleClickChangeListener) {
        this.onTitleClickChangeListener = onTitleClickChangeListener;
    }
}
