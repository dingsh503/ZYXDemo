package net.iclassmate.zyxdemo.activity;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

import com.google.gson.Gson;
import com.yanzhenjie.nohttp.NoHttp;
import com.yanzhenjie.nohttp.RequestMethod;
import com.yanzhenjie.nohttp.error.NetworkError;
import com.yanzhenjie.nohttp.rest.OnResponseListener;
import com.yanzhenjie.nohttp.rest.Request;
import com.yanzhenjie.nohttp.rest.RequestQueue;
import com.yanzhenjie.nohttp.rest.Response;
import com.yanzhenjie.nohttp.rest.StringRequest;

import net.iclassmate.zyxdemo.R;
import net.iclassmate.zyxdemo.bean.ItemPool;
import net.iclassmate.zyxdemo.bean.Loginfo;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by xydbj on 2017.1.12.
 */
public class NoHttpActivity extends Activity implements OnClickListener {

    private Button nohttp_btn1, nohttp_btn2, nohttp_btn3, nohttp_btn4;
    private TextView nohttp_tv1,nohttp_tv2;

    private String url_get = "http://space.iclassmate.cn:10000/fs/api/v1/bootPage?product=1";
    private String url_get2 = "http://space.iclassmate.cn:10000/fs/api/v1/itemPool?";
    private String url_post = "http://space.iclassmate.cn:10000/user/api/v1/isExistEntPhone";
    private String url_post2 = "http://space.iclassmate.cn:10000/user/api/v1/login";
    private String result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nohttp);
        nohttp_btn1 = (Button) findViewById(R.id.nohttp_btn1);
        nohttp_btn2 = (Button) findViewById(R.id.nohttp_btn2);
        nohttp_btn3 = (Button) findViewById(R.id.nohttp_btn3);
        nohttp_btn4 = (Button) findViewById(R.id.nohttp_btn4);
        nohttp_tv1 = (TextView) findViewById(R.id.nohttp_tv1);
        nohttp_tv2 = (TextView) findViewById(R.id.nohttp_tv2);

        nohttp_btn1.setOnClickListener(this);
        nohttp_btn2.setOnClickListener(this);
        nohttp_btn3.setOnClickListener(this);
        nohttp_btn4.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.nohttp_btn1:
                get();//不带参数的get请求
                break;
            case R.id.nohttp_btn2:
                get(4);//带参数的get请求
                break;
            case R.id.nohttp_btn3://带参数的post请求 键值对
                post("15801362521");
                break;
            case R.id.nohttp_btn4:
                post("15801362521", "123456");//带json串的post请求
                break;
        }
    }
    public void post(String phoneNum){
        RequestQueue queue = NoHttp.newRequestQueue();
        Request<String> request = new StringRequest(url_post+"/"+phoneNum, RequestMethod.POST);
        request.add("phone",phoneNum);
        queue.add(0, request, new OnResponseListener<String>() {
            @Override
            public void onStart(int what) {

            }

            @Override
            public void onSucceed(int what, Response<String> response) {
                if (response.isSucceed() && response.responseCode() == 200){
                    result = response.get();
                    nohttp_tv1.setText(result);
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

    public void post(String userName, String passWord) {
        RequestQueue queue = NoHttp.newRequestQueue();
        Request<String> request = new StringRequest(url_post2, RequestMethod.POST);
        JSONObject object = new JSONObject();
        try {
            object.put("pwd", passWord);
            object.put("userName", userName);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        request.setDefineRequestBodyForJson(object);
        queue.add(0, request, new OnResponseListener<String>() {
            @Override
            public void onStart(int what) {

            }

            @Override
            public void onSucceed(int what, Response<String> response) {
                if (response.isSucceed() && response.responseCode() == 200) {
                    String result = response.get();
                    Log.i("info", "用NoHttp进行带json串参数的post请求：" + result);
                    nohttp_tv1.setText(result);
                    Gson gson = new Gson();
                    Loginfo loginfo = gson.fromJson(result, Loginfo.class);
                    Log.i("info", "Gson解析带json串参数的post请求：" + loginfo.toString());
                    nohttp_tv2.setText(loginfo.toString());
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

    public void get(int num) {
        RequestQueue queue = NoHttp.newRequestQueue(3);
        Request<String> request = new StringRequest(url_get2, RequestMethod.GET);
        request.add("num", num);
        queue.add(0, request, new OnResponseListener<String>() {
            @Override
            public void onStart(int what) {

            }

            @Override
            public void onSucceed(int what, Response<String> response) {
                if (response.isSucceed()) {
                    result = response.get();
                    Log.i("info", "用NoHttp进行带参数的get请求：" + result);
                    nohttp_tv1.setText(result);
                    Gson gson = new Gson();
                    ItemPool itemPool = gson.fromJson(result, ItemPool.class);
                    Log.i("info", "用Gson进行原始数据解析：" + itemPool.toString());
                    nohttp_tv2.setText(itemPool.toString());
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

    public void get() {
        RequestQueue queue = NoHttp.newRequestQueue(3);//默认是3
        Request<String> request = new StringRequest(url_get, RequestMethod.GET);
        queue.add(0, request, new OnResponseListener<String>() {
            @Override
            public void onStart(int what) {
                // 这里可以show()一个wait dialog。
            }

            @Override
            public void onSucceed(int what, Response<String> response) {
                if (response.responseCode() == 200) {
                    result = response.get();
                    Log.i("info", "用NoHttp进行不带参数的get请求：" + result);
                    nohttp_tv1.setText(result);

                }
            }

            @Override
            public void onFailed(int what, Response<String> response) {
                Exception exception = response.getException();
                if (exception instanceof NetworkError) {

                }
            }

            @Override
            public void onFinish(int what) {
                // 这里可以dismiss()上面show()的wait dialog。
            }
        });
    }


}
