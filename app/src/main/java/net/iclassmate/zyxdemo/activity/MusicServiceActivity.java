package net.iclassmate.zyxdemo.activity;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import net.iclassmate.zyxdemo.R;
import net.iclassmate.zyxdemo.service.MusicService;


/**
 *
 * http://space.iclassmate.cn:10000/fs/api/v1/downFile/0a117a1a6a804059af640f72e8872950
 * 23.34MB的视频下载地址
 * Created by xydbj on 2017.3.21.
 */

public class MusicServiceActivity extends Activity implements View.OnClickListener {

    String TAG = "info";
    Button button01;
    Button button02;
    Button button03;
    Button button04;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_musicservice);
        init();
        initListener();
    }

    public void init() {
        button01 = (Button) findViewById(R.id.button01);
        button02 = (Button) findViewById(R.id.button02);
        button03 = (Button) findViewById(R.id.button03);
        button04 = (Button) findViewById(R.id.button04);
    }

    public void initListener() {
        button01.setOnClickListener(this);
        button02.setOnClickListener(this);
        button03.setOnClickListener(this);
        button04.setOnClickListener(this);
    }

    public ServiceConnection connection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            Toast.makeText(MusicServiceActivity.this, "ServiceConnection onServiceConnected", Toast.LENGTH_SHORT).show();
            Log.i(TAG, "ServiceConnection onServiceConnected");
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            Toast.makeText(MusicServiceActivity.this, "ServiceConnection onServiceDisconnected", Toast.LENGTH_SHORT).show();
            Log.i(TAG, "ServiceConnection onServiceDisconnected");
        }
    };

    @Override
    public void onClick(View view) {
        Intent intent = new Intent(MusicServiceActivity.this, MusicService.class);
        switch (view.getId()) {
            case R.id.button01:
                Log.i(TAG, "点击-----------");
                startService(intent);
                break;
            case R.id.button02:
                stopService(intent);
                break;
            case R.id.button03:
                bindService(intent, connection, Context.BIND_AUTO_CREATE);
                break;
            case R.id.button04:
                unbindService(connection);
                break;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(MusicServiceActivity.this, "MainHelloService onDestroy", Toast.LENGTH_SHORT).show();
        Log.i(TAG, "MainHelloService onDestroy");
    }
}
