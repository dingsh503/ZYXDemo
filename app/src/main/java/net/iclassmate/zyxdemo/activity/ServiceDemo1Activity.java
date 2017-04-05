package net.iclassmate.zyxdemo.activity;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Environment;
import android.os.IBinder;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.yanzhenjie.nohttp.Headers;
import com.yanzhenjie.nohttp.NoHttp;
import com.yanzhenjie.nohttp.RequestMethod;
import com.yanzhenjie.nohttp.download.DownloadListener;
import com.yanzhenjie.nohttp.download.DownloadQueue;
import com.yanzhenjie.nohttp.download.DownloadRequest;

import net.iclassmate.zyxdemo.R;
import net.iclassmate.zyxdemo.service.DownLoadProgressListener;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by xydbj on 2017.3.22.
 */

public class ServiceDemo1Activity extends Activity implements DownLoadProgressListener {

    @BindView(R.id.btn_startservice)
    Button btnStart;
    @BindView(R.id.btn_stopservice)
    Button btnStop;
    @BindView(R.id.btn_bindservice)
    Button btnBindservice;
    @BindView(R.id.btn_unbindservice)
    Button btnUnbindservice;

    ServiceDemo1.MyBinder myBinder;
    //    String url = "http://space.iclassmate.cn:10000/fs/api/v1/downFile/0a117a1a6a804059af640f72e8872950";
    String url = "http://video.hskaoyan.com/cabhac/37e693c6a990ddaa8cfd28757cc5bbbd.mp4";
    @BindView(R.id.btn_downloadnow)
    Button btnDownloadnow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_servicedemo1);
        ButterKnife.bind(this);
    }

    public ServiceConnection connection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            myBinder = (ServiceDemo1.MyBinder) service;
            myBinder.startDownLoad();
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {

        }
    };

    @OnClick({R.id.btn_startservice, R.id.btn_stopservice, R.id.btn_bindservice, R.id.btn_unbindservice})
    public void onClick(View view) {
        Intent intent = new Intent(ServiceDemo1Activity.this, ServiceDemo1.class);
        switch (view.getId()) {
            case R.id.btn_startservice:
                Log.i("info", "点击开启服务");
                startService(intent);
                break;
            case R.id.btn_stopservice:
                Log.i("info", "点击停止服务");
                stopService(intent);
                break;
            case R.id.btn_bindservice:
                Log.i("info", "点击绑定服务");
                intent.putExtra("url", url);
                bindService(intent, connection, Context.BIND_AUTO_CREATE);
                break;
            case R.id.btn_unbindservice:
                Log.i("info", "点击解绑服务");
                unbindService(connection);
                break;
        }
    }

    @Override
    public void setDownLoadProgressListener(int progress) {
        Log.i("info", "在ServiceDemo1Activity中，setDownLoadProgressListener方法，progress=" + progress);
    }

    @OnClick(R.id.btn_downloadnow)
    public void onClick() {
        //我点击这个按钮，直接在activity中进行下载，
        downloadVideo(url);
    }

    public void downloadVideo(String url) {
        DownloadQueue downloadQueue = NoHttp.newDownloadQueue();
        String path = Environment.getExternalStorageDirectory().getPath() + "/zyx";
        DownloadRequest downloadRequest = NoHttp.createDownloadRequest(url, RequestMethod.GET, path, "mydownload.mp4", true, false);
//        downloadRequest.add("id", "0a117a1a6a804059af640f72e8872950");
        downloadRequest.setHeader("referer", url);
        downloadQueue.add(0, downloadRequest, downloadListener);
    }

    public DownloadListener downloadListener = new DownloadListener() {
        @Override
        public void onDownloadError(int what, Exception exception) {
            Log.i("info", "在Activity中直接下载：下载出错");
        }

        @Override
        public void onStart(int what, boolean isResume, long rangeSize, Headers responseHeaders, long allCount) {
            Log.i("info", "在Activity中直接下载：下载开始  what=" + what + ";isResume=" + isResume + ";rangeSize=" + rangeSize + ";allCount=" + allCount);
        }

        @Override
        public void onProgress(int what, int progress, long fileCount, long speed) {
            Log.i("info", "在Activity中直接下载：下载中······progress=" + progress + ";fileCount=" + fileCount + ";speed=" + speed);
        }

        @Override
        public void onFinish(int what, String filePath) {
            Log.i("info", "在Activity中直接下载：下载完成");
        }

        @Override
        public void onCancel(int what) {
            Log.i("info", "在Activity中直接下载：下载取消");
        }
    };
}
