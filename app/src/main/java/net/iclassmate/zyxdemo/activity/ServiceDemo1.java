package net.iclassmate.zyxdemo.activity;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.Environment;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.util.Log;

import com.yanzhenjie.nohttp.Headers;
import com.yanzhenjie.nohttp.NoHttp;
import com.yanzhenjie.nohttp.download.DownloadListener;
import com.yanzhenjie.nohttp.download.DownloadQueue;
import com.yanzhenjie.nohttp.download.DownloadRequest;

import net.iclassmate.zyxdemo.service.DownLoadProgressListener;
import net.iclassmate.zyxdemo.utils.HttpUtils;

/**
 * Created by xydbj on 2017.3.22.
 */

public class ServiceDemo1 extends Service {

    MyBinder myBinder;
    HttpUtils httpUtils;
    String url;
    String path = Environment.getExternalStorageDirectory().getPath() + "/zyxdownload";
    DownLoadProgressListener progressListener;
    DownloadRequest downloadRequest;

    public Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {

            }
        }
    };

    @Override
    public void onCreate() {
        super.onCreate();
        Log.i("info", "在Service服务中，onCreate()方法执行了");
        if (myBinder == null) {
            myBinder = new MyBinder();
        }
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        url = intent.getStringExtra("url");
        Log.i("info", "在Service服务中，onStartCommand()方法执行了,url=" + url);
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.i("info", "在Service服务中，onDestroy()方法执行了");
    }

    @Override
    public boolean onUnbind(Intent intent) {
        Log.i("info", "在Service服务中，onUnbind()方法执行了");
        return super.onUnbind(intent);
    }

    @Override
    public IBinder onBind(Intent intent) {
        url = intent.getStringExtra("url");
        Log.i("info", "在Service服务中，onBind()方法执行了,url=" + url);
        return myBinder;
    }

    class MyBinder extends Binder {
        void startDownLoad() {
            if (downloadRequest != null && downloadRequest.isStarted() && !downloadRequest.isFinished()) {
                downloadRequest.cancel();
            } else if (downloadRequest == null) {
                DownloadQueue downloadQueue = NoHttp.newDownloadQueue();
                downloadRequest = NoHttp.createDownloadRequest(url, path, "mydownload.mp4", true, false);
                downloadRequest.setHeader("referer", url);
                if (downloadRequest.isStarted()) {
                    Log.i("info", "文件正在下载");
                    return;
                }
                downloadQueue.add(0, downloadRequest, downloadListener);
            }
        }
    }

    public DownloadListener downloadListener = new DownloadListener() {
        @Override
        public void onDownloadError(int what, Exception exception) {
            Log.i("info", "下载出错，exception=" + exception.toString());
        }

        @Override
        public void onStart(int what, boolean isResume, long rangeSize, Headers responseHeaders, long allCount) {
            Log.i("info", "下载开始");
        }

        @Override
        public void onProgress(int what, int progress, long fileCount, long speed) {
            Log.i("info", "下载中...  progress=" + progress);
            progressListener.setDownLoadProgressListener(progress);
        }

        @Override
        public void onFinish(int what, String filePath) {
            Log.i("info", "下载结束");
        }

        @Override
        public void onCancel(int what) {
            Log.i("info", "下载取消");
        }
    };
}
