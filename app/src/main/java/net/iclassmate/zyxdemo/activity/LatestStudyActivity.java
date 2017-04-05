package net.iclassmate.zyxdemo.activity;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.widget.Toast;

import net.iclassmate.zyxdemo.R;
import net.iclassmate.zyxdemo.bean.lateststudy.LatestStudy;
import net.iclassmate.zyxdemo.utils.JsonUtils;
import net.iclassmate.zyxdemo.view.FullListView;

/**
 * Created by xydbj on 2016.12.29.
 */
public class LatestStudyActivity extends Activity {
    private FullListView flv;
    private String userId = "13051529625";
    private LatestStudy latestStudy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lateststudy);
        flv = (FullListView) findViewById(R.id.lateststudy_flv);
        latestStudy = new LatestStudy();
//        getData(userId);
    }

    public Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case 200:
                    String result = (String) msg.obj;
                    Log.i("info", "数据请求成功：" + result);
                    latestStudy = JsonUtils.StartJson(result);
                    Log.i("info", "数据解析成功：" + latestStudy.toString());
                    break;
                case 404:
                    Toast.makeText(LatestStudyActivity.this, "数据请求失败", Toast.LENGTH_SHORT).show();
                    break;
            }
        }
    };

//    public void getData(String userId) {
//        OkHttpClient client = new OkHttpClient();
//        Request request = new Request.Builder()
//                .url("http://space.iclassmate.cn:10000/fs/api/v1/getRecentlyLearn?userId=" + userId)
//                .get()
//                .build();
//        client.newCall(request).enqueue(new Callback() {
//            @Override
//            public void onFailure(Request request, IOException e) {
//                mHandler.sendEmptyMessage(404);
//            }
//
//            @Override
//            public void onResponse(Response response) throws IOException {
//                if (response.code() == 200) {
//                    String result = response.body().string();
//                    Message msg = new Message();
//                    msg.obj = result;
//                    msg.what = response.code();
//                    mHandler.sendMessage(msg);
//                }
//            }
//        });
//    }
}
