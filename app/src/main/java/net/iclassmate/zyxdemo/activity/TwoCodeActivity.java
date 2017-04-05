package net.iclassmate.zyxdemo.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.uuzuche.lib_zxing.activity.CaptureActivity;
import com.uuzuche.lib_zxing.activity.CodeUtils;

import net.iclassmate.zyxdemo.R;

/**
 * Created by xydbj on 2016.11.16.
 */
public class TwoCodeActivity extends Activity {

    private Button btn_scan, btn_scan2;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_twocode);
        btn_scan = (Button) findViewById(R.id.btn_scan);
        btn_scan2 = (Button) findViewById(R.id.btn_scan2);
        btn_scan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TwoCodeActivity.this, CaptureActivity.class);
                startActivityForResult(intent, 1011);
            }
        });
        String str1 = "123.123";
        String str2 = "123.123.";
        String str3 = "null";
        String str4 = "";
        String str5 = null;
        int index = TextUtils.indexOf(str1, '.');
        boolean flag12 = TextUtils.equals(str1, str2);
        boolean flag3 = TextUtils.isEmpty(str3);
        boolean flag4 = TextUtils.isEmpty(str4);
        boolean flag5 = TextUtils.isEmpty(str5);
        Log.i("info", "index=" + index);
        Log.i("info", "flag12="+ flag12);
        Log.i("info", "flag3=" + flag3);
        Log.i("info", "flag4=" + flag4);
        Log.i("info", "flag5=" + flag5);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1011) {
            if (resultCode == RESULT_OK) {
                Bundle bundle = data.getExtras();
                if (bundle == null) {
                    return;
                }
                if (bundle.getInt(CodeUtils.RESULT_TYPE) == CodeUtils.RESULT_SUCCESS) {
                    String result = bundle.getString(CodeUtils.RESULT_STRING);
                    Toast.makeText(TwoCodeActivity.this, "扫描的结果是：" + result, Toast.LENGTH_SHORT).show();
                }
            }
        }
    }
}
