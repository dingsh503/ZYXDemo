package net.iclassmate.zyxdemo.activity;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import com.google.gson.Gson;

import net.iclassmate.zyxdemo.R;
import net.iclassmate.zyxdemo.bean.UserInformation;
import net.iclassmate.zyxdemo.utils.CallBackData;
import net.iclassmate.zyxdemo.utils.HttpUtils;

/**
 * Created by xydbj on 2017.2.28.
 */

public class DiyNoHttpActivity extends Activity implements CallBackData {

    private TextView tv_old, tv_new;
    private UserInformation userInformation;
    private HttpUtils httpUtils;
    private String userId = "064ed5acaea946a9b49c3803900221ee";
    private Gson gson;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diynohttp);
        init();
        httpUtils.getUserInfo(userId);
    }

    public void init() {
        tv_old = (TextView) findViewById(R.id.diynohttp_old);
        tv_new = (TextView) findViewById(R.id.diynohttp_new);
        userInformation = new UserInformation();
        httpUtils = new HttpUtils(this);
        gson = new Gson();
    }

    @Override
    public void sendData(Object object) {
        if (object != null) {
            if (object instanceof String) {
                String result = (String) object;
                tv_old.setText("网络请求的数据：" + result);
                userInformation = gson.fromJson(result, UserInformation.class);
                tv_new.setText("Gson解析之后的数据：" + userInformation.toString());
            }
        }
    }
}
