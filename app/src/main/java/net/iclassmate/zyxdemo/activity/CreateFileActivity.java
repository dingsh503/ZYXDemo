package net.iclassmate.zyxdemo.activity;

import android.app.Activity;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import net.iclassmate.zyxdemo.R;

import java.io.File;

/**
 * Created by xydbj on 2016.11.10.
 */
public class CreateFileActivity extends Activity implements View.OnClickListener {

   private EditText editText;
   private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_createfile);
        editText = (EditText) findViewById(R.id.et);
        button = (Button) findViewById(R.id.btn);
        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn:
                String fileName = editText.getText().toString().trim();
                Log.i("info", "fileName=" + fileName);
                String genPath = Environment.getExternalStorageDirectory().getPath();
                Log.i("info", "genPath=" + genPath);
                File file = new File(genPath, fileName);
                if (!file.exists()) {
                    file.mkdir();
                    Toast.makeText(CreateFileActivity.this, "创建成功", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(CreateFileActivity.this, "文件夹已存在", Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }
}
