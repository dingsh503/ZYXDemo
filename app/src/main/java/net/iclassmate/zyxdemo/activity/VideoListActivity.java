package net.iclassmate.zyxdemo.activity;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

import net.iclassmate.zyxdemo.R;
import net.iclassmate.zyxdemo.service.VideoDownService;

/**
 * Created by xydbj on 2017.3.21.
 */

public class VideoListActivity extends Activity implements View.OnClickListener {
    Button btn;
    Context context;
    ProgressBar progressBar;
    String url = "http://space.iclassmate.cn:10000/fs/api/v1/downFile/0a117a1a6a804059af640f72e8872950";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_videolist);
        context = VideoListActivity.this;
        btn = (Button) findViewById(R.id.videolist_btn);
        progressBar = (ProgressBar) findViewById(R.id.videolist_progressBar);
        btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(context, VideoDownService.class);
        intent.putExtra("videoUrl",url);
        bindService(intent, connection, Context.BIND_AUTO_CREATE);
    }

    public ServiceConnection connection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {

        }

        @Override
        public void onServiceDisconnected(ComponentName name) {

        }
    };
}
