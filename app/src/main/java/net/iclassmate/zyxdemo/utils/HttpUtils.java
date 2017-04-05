package net.iclassmate.zyxdemo.utils;

import android.os.Environment;
import android.util.Log;

import com.yanzhenjie.nohttp.Headers;
import com.yanzhenjie.nohttp.NoHttp;
import com.yanzhenjie.nohttp.RequestMethod;
import com.yanzhenjie.nohttp.download.DownloadListener;
import com.yanzhenjie.nohttp.download.DownloadQueue;
import com.yanzhenjie.nohttp.download.DownloadRequest;
import com.yanzhenjie.nohttp.rest.OnResponseListener;
import com.yanzhenjie.nohttp.rest.Request;
import com.yanzhenjie.nohttp.rest.RequestQueue;
import com.yanzhenjie.nohttp.rest.Response;
import com.yanzhenjie.nohttp.rest.StringRequest;

import net.iclassmate.zyxdemo.Constant;
import net.iclassmate.zyxdemo.service.DownLoadProgressListener;

/**
 * Created by xydbj on 2017.1.12.
 */
public class HttpUtils {

    private CallBackData callBackData;
    private DownLoadProgressListener progressListener;

    public HttpUtils(CallBackData callBackData) {
        this.callBackData = callBackData;
    }

    public HttpUtils(DownLoadProgressListener progressListener) {
        this.progressListener = progressListener;
    }

    public void getUserInfo(String userId) {
        RequestQueue queue = NoHttp.newRequestQueue(3);
        String url = String.format(Constant.GET_USERINFO, userId);
        Log.i("info", "url====" + url);
        Request<String> request = new StringRequest(url, RequestMethod.GET);
        request.add("userId", userId);
        queue.add(0, request, new OnResponseListener<String>() {
            @Override
            public void onStart(int what) {

            }

            @Override
            public void onSucceed(int what, Response<String> response) {
                if (response.isSucceed() && response.responseCode() == 200) {
                    String result = response.get();
                    callBackData.sendData(result);
                }
            }

            @Override
            public void onFailed(int what, Response<String> response) {

            }

            @Override
            public void onFinish(int what) {

            }
        });
    }

    public void downloadVideo(String url) {
        DownloadQueue downloadQueue = NoHttp.newDownloadQueue();
        String path = Environment.getExternalStorageDirectory().getPath() + "/zyxdownload";
        DownloadRequest downloadRequest = NoHttp.createDownloadRequest(url, path, "mydownload.mp4", true, false);
        downloadRequest.add("id", "0a117a1a6a804059af640f72e8872950");
        downloadQueue.add(0, downloadRequest, new DownloadListener() {
            @Override
            public void onDownloadError(int what, Exception exception) {
                Log.i("info", "HttpUtils:下载出错");
            }

            @Override
            public void onStart(int what, boolean isResume, long rangeSize, Headers responseHeaders, long allCount) {
                Log.i("info", "HttpUtils:下载开始,allCount=" + allCount);
            }

            @Override
            public void onProgress(int what, int progress, long fileCount, long speed) {
                //                progressListener.setDownLoadProgressListener(progress);
                Log.i("info", "HttpUtils:onProgress(),what=" + what);
                Log.i("info", "HttpUtils:onProgress(),progress=" + progress);
                Log.i("info", "HttpUtils:onProgress(),fileCount=" + fileCount);
            }

            @Override
            public void onFinish(int what, String filePath) {
                Log.i("info", "HttpUtils:下载完成,filePath=" + filePath);
            }

            @Override
            public void onCancel(int what) {

            }
        });
    }

}
