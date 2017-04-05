package net.iclassmate.zyxdemo.application;

import android.app.Application;
import android.content.Context;

import com.uuzuche.lib_zxing.activity.ZXingLibrary;
import com.yanzhenjie.nohttp.NoHttp;
import com.yanzhenjie.nohttp.OkHttpNetworkExecutor;
import com.yanzhenjie.nohttp.cache.DBCacheStore;
import com.yanzhenjie.nohttp.cookie.DBCookieStore;


/**
 * Created by xydbj on 2016.11.17.
 */
public class MyApplication extends Application {

    Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        context = this;
        ZXingLibrary.initDisplayOpinion(context);
        NoHttp.initialize(context, new NoHttp.Config()
                        .setConnectTimeout(30 * 1000)
                        .setReadTimeout(30 * 1000)
                        .setCacheStore(
                                new DBCacheStore(context)// 配置缓存到数据库。
                                        .setEnable(true)// true启用缓存，fasle禁用缓存。
                        )
                        .setCookieStore(new DBCookieStore(context)
                                .setEnable(true)// true启用自动维护Cookie，fasle禁用自动维护Cookie。
                        )
                        .setNetworkExecutor(new OkHttpNetworkExecutor())
        );
//        Logger.setDebug(true);
//        Logger.setTag("info");
    }
}
