package net.iclassmate.zyxdemo.activity;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.LinearLayout;

import net.iclassmate.zyxdemo.R;

/**
 * Created by xydbj on 2016.12.9.
 */
public class WebViewActivity extends Activity {

    private WebView webView;
    private LinearLayout linearLayout;
    private Context mContext;
    private String url = "http://www.cnwkw.cn/player/?resourceId=8029&lessonId=338";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webview);
        init();

        try {
            WebSettings settings = webView.getSettings();
            // 支持javascript
            settings.setJavaScriptEnabled(true);
            // 设置可以支持缩放
            settings.setSupportZoom(true);
            // 设置出现缩放工具
            settings.setBuiltInZoomControls(true);
            settings.setDisplayZoomControls(false);
            // 扩大比例的缩放
            webView.getSettings().setUseWideViewPort(true);
            // 自适应屏幕
//            webView.getSettings().setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);
//            webView.getSettings().setLoadWithOverviewMode(true);

            webView.getSettings().setUseWideViewPort(true);
            webView.getSettings().setLoadWithOverviewMode(true);


            webView.setWebViewClient(new WebViewClient() {
                @Override
                public void onPageFinished(WebView view, String url) {
                    linearLayout.setVisibility(View.GONE);
                    //自动播放，不过有点问题
//                    webView.loadUrl("javascript:(function() { var videos = document.getElementsByTagName('video'); for(var i=0;i<videos.length;i++){videos[i].play();}})()");
                }
            });
            webView.setWebChromeClient(new WebChromeClient() {
                @Override
                public void onReceivedTitle(WebView view, String title) {
                }

                @Override
                public void onProgressChanged(WebView view, int newProgress) {
                    super.onProgressChanged(view, newProgress);
                    if (newProgress > 85) {
                        linearLayout.setVisibility(View.GONE);
                    }
                }
            });

            webView.getSettings().setPluginState(WebSettings.PluginState.ON);
            WindowManager wm = (WindowManager) mContext.getSystemService(Context.WINDOW_SERVICE);
            int width = wm.getDefaultDisplay().getWidth();
            if (width > 650) {
                this.webView.setInitialScale(190);
            } else if (width > 520) {
                this.webView.setInitialScale(160);
            } else if (width > 450) {
                this.webView.setInitialScale(140);
            } else if (width > 300) {
                this.webView.setInitialScale(120);
            } else {
                this.webView.setInitialScale(100);
            }
            settings.setUserAgentString("0"); // 0为手机默认, 1为PC台机，2为IPHONE
            settings.setUserAgentString("Mozilla/5.0 (Linux; U; Android 2.2.1; zh-cn; MB525 Build/3.4.2-117) AppleWebKit/533.1 (KHTML, like Gecko) Version/4.0 Mobile Safari/533.1");
            webView.loadUrl(url);
        } catch (Exception e) {

        }
    }

    private void init() {
        mContext = this;
        webView = (WebView) findViewById(R.id.webView);
        linearLayout = (LinearLayout) findViewById(R.id.view_linear);
    }
}
