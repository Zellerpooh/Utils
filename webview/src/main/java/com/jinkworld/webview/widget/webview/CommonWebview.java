package com.jinkworld.webview.widget.webview;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.Toast;
import android.widget.ZoomButtonsController;

import com.jinkworld.webview.R;
import com.jinkworld.webview.SampleActivity;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.security.PublicKey;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by Zellerpooh on 16/10/22.
 */

public class CommonWebview extends WebView {

    private static final boolean DEFAULT_AUTOHIDE = false;
    private static final boolean DEFAULT_OVERRIDEURL = false;
    private Context context;
    private CommonWebViewListener m_progresslistener;
    private boolean m_autohide;
    private boolean m_overrideurl;
    private View customView;
    private FrameLayout m_fullscreenvideo;

    public CommonWebview(Context context) {
        super(context);
        this.context = context;
        m_autohide = DEFAULT_AUTOHIDE;
        m_overrideurl = DEFAULT_OVERRIDEURL;
    }

    public CommonWebview(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.CommonWebView, 0, 0);
        m_autohide = a.getBoolean(R.styleable.CommonWebView_cwv_autohide, DEFAULT_AUTOHIDE);
        m_overrideurl = a.getBoolean(R.styleable.CommonWebView_cwv_overrideurl, DEFAULT_AUTOHIDE);
    }

    public CommonWebview(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.context = context;
        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.CommonWebView, defStyleAttr, 0);
        m_autohide = a.getBoolean(R.styleable.CommonWebView_cwv_autohide, DEFAULT_AUTOHIDE);
        m_overrideurl = a.getBoolean(R.styleable.CommonWebView_cwv_overrideurl, DEFAULT_AUTOHIDE);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public CommonWebview(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        this.context = context;
        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.CommonWebView, defStyleAttr, 0);
        m_autohide = a.getBoolean(R.styleable.CommonWebView_cwv_autohide, DEFAULT_AUTOHIDE);
        m_overrideurl = a.getBoolean(R.styleable.CommonWebView_cwv_overrideurl, DEFAULT_AUTOHIDE);
    }

    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public CommonWebview(Context context, AttributeSet attrs, int defStyleAttr, boolean privateBrowsing) {
        super(context, attrs, defStyleAttr, privateBrowsing);
        this.context = context;
        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.CommonWebView, defStyleAttr, 0);
        m_autohide = a.getBoolean(R.styleable.CommonWebView_cwv_autohide, DEFAULT_AUTOHIDE);
        m_overrideurl = a.getBoolean(R.styleable.CommonWebView_cwv_overrideurl, DEFAULT_AUTOHIDE);
    }


    /**
     * 外部初始化WebView
     *
     * @param commonWebViewListener
     */
    public void initWebView(CommonWebViewListener commonWebViewListener) {
        m_progresslistener = commonWebViewListener;
        initWebSettings();
        this.setWebChromeClient(webChromeClient);
        this.setWebViewClient(webViewClient);
//        this.setDownloadListener(downloadListener);
    }

    private WebViewClient webViewClient = new WebViewClient() {
        boolean bReceivedError = false;
        Map<String, Long> urlMap = new HashMap<String, Long>();

        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            super.onPageStarted(view, url, favicon);
            m_progresslistener.startPageLoad();
            clearTimeoutInfo();
            if (!urlMap.containsKey(url)) {
                bReceivedError = false;
            }
        }

        @Override
        public void onPageFinished(WebView view, String url) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
                view.getSettings().setBlockNetworkImage(false);//加载完毕后，关闭图片阻塞
            }
            // 网址能正常访问，调用客户端页面加载完成接口
            if (!bReceivedError) {
                if (m_autohide) {
                    view.setVisibility(VISIBLE);
                }
                m_progresslistener.onPageFinished(view, url);
            }
            super.onPageFinished(view, url);
        }

        @Override
        public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
            super.onReceivedError(view, errorCode, description, failingUrl);
            if (!bReceivedError) {
                bReceivedError = true;
                m_progresslistener.onPageError();
            }
            if (m_autohide) {
                view.setVisibility(GONE);
            }
            urlMap.put(failingUrl, (new java.util.Date()).getTime() + 500);
        }

        @Override
        public void onScaleChanged(WebView view, float oldScale, float newScale) {
            super.onScaleChanged(view, oldScale, newScale);
        }

        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            //拦截页面超链接的url，进行常规处理或者有客户端自行处理
            return m_progresslistener.shouldOverrideUrlLoading(url);
        }

        @Override
        public WebResourceResponse shouldInterceptRequest(WebView view, WebResourceRequest request) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                String url = request.getUrl().toString();
                if (null != url && url.startsWith("http://wap.zjtoolbarc60.10086.cn")) {
                    try {
                        InputStream in = new ByteArrayInputStream("".getBytes("UTF-8"));
                        return new WebResourceResponse("text/plain", "utf-8", in);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
            return super.shouldInterceptRequest(view, request);
        }

        private void clearTimeoutInfo() {
            Iterator<String> iter = urlMap.keySet().iterator();
            while (iter.hasNext()) {
                String key = iter.next();
                Long timeout = urlMap.get(key);
                if (timeout < (new java.util.Date()).getTime()) {
                    urlMap.remove(key);
                }
            }
        }

    };
    /**
     *
     */
    private WebChromeClient webChromeClient = new WebChromeClient() {
        CustomViewCallback customViewCallback;
        private View videoloading;

        @Override
        public boolean onJsAlert(WebView view, String url, String message, JsResult result) {
            Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
            result.cancel();
            return true;
        }

        @Override
        public void onProgressChanged(WebView view, int newProgress) {
            m_progresslistener.onProgressChanged(newProgress);
            super.onProgressChanged(view, newProgress);
        }

        @Override
        public void onShowCustomView(View view, CustomViewCallback callback) {
            doShowCustomView(view, callback);
            super.onShowCustomView(view, callback);
        }

        private void doShowCustomView(View view, CustomViewCallback callback) {
            m_progresslistener.setScreenOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
            CommonWebview.this.setVisibility(GONE);
            //如果一个视图已经存在，那么立刻终止并新建一个
            if (customView != null) {
                callback.onCustomViewHidden();
                return;
            }
            if (null != m_fullscreenvideo) {
                m_fullscreenvideo.addView(view);
                customView = view;
                customViewCallback = callback;
                m_fullscreenvideo.setVisibility(VISIBLE);
            }
        }

        @Override
        public void onHideCustomView() {
            doHideCustomView();
            super.onHideCustomView();
        }

        private void doHideCustomView() {
            m_progresslistener.setScreenOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
            if (null == customView) {
                return;
            }
            if (null != customView) {
                customView.setVisibility(GONE);
                if (null != m_fullscreenvideo) {
                    m_fullscreenvideo.removeView(customView);
                }
                customView = null;
            }
            if (null != m_fullscreenvideo) {
                m_fullscreenvideo.setVisibility(GONE);
            }
            if (null != customViewCallback) {
                customViewCallback.onCustomViewHidden();
            }
            CommonWebview.this.setVisibility(VISIBLE);
        }

        @Override
        public View getVideoLoadingProgressView() {
            if (videoloading == null) {
                LayoutInflater inflater = LayoutInflater.from(context);
                videoloading = inflater.inflate(R.layout.video_loading_progress, null);
            }
            return videoloading;
        }
    };

    /**
     * 初始化WebView设置
     */
    private void initWebSettings() {
        WebSettings webSettings = this.getSettings();
        webSettings.setJavaScriptEnabled(true);//启用支持javascript
        //H5缓存
        webSettings.setAppCacheEnabled(true);//H5启用缓存
        webSettings.setAppCachePath(getContext().getCacheDir().getAbsolutePath());//cache目录
        webSettings.setAppCacheMaxSize(1024 * 1024 * 8);//设置应用缓存的最大尺寸8M
        //H5本地存储
        webSettings.setDatabaseEnabled(true);//启动数据库
        webSettings.setCacheMode(WebSettings.LOAD_DEFAULT);//设置缓存模式
        webSettings.setDatabasePath(getContext().getDatabasePath("database").getAbsolutePath());
        webSettings.setDomStorageEnabled(true);//启动webview的html5的本地存储功能。

        webSettings.setAllowFileAccess(true);//设置启用或禁止访问文件数据
        webSettings.setJavaScriptCanOpenWindowsAutomatically(true); //支持通过JS打开新窗口
        webSettings.setGeolocationEnabled(true);//启用地理定位
        webSettings.setGeolocationDatabasePath(getContext().getCacheDir().getAbsolutePath());
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            this.getSettings().setBlockNetworkImage(true);//加载url前，设置图片阻塞
        }
        webSettings.setPluginState(WebSettings.PluginState.ON);
        webSettings.setRenderPriority(WebSettings.RenderPriority.HIGH);
        //这句不取消，界面会出问题
        //this.getSettings().setUseWideViewPort(true); //无限缩放
        webSettings.setLoadWithOverviewMode(true); //设置Web视图缩小内容以适应屏幕宽度
        webSettings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.NARROW_COLUMNS);//适应内容大小
        webSettings.setSupportZoom(false);
        webSettings.setBuiltInZoomControls(false);
        //去掉缩放按钮
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
            webSettings.setDisplayZoomControls(false);
        } else {
            //低版本隐藏缩放按钮
            try {
                Class webview = Class.forName("android.webkit.WebView");
                Method method = webview.getMethod("getZoomButtonsController");
                ZoomButtonsController zoom_controll = (ZoomButtonsController) method.invoke(this, true);
                zoom_controll.getZoomControls().setVisibility(View.GONE);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN)
            webSettings.setAllowUniversalAccessFromFileURLs(true);//启用ajax
        this.requestFocusFromTouch();//webview必须设置支持获取手势焦点。
        this.setHorizontalScrollBarEnabled(false);//取消显示
        this.setVerticalScrollBarEnabled(false);//取消显示
        this.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
    }


}
