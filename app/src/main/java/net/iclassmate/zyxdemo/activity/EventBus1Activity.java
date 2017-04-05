package net.iclassmate.zyxdemo.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import net.iclassmate.zyxdemo.R;
import net.iclassmate.zyxdemo.bean.FristEvent;

import de.greenrobot.event.EventBus;

/**
 * Created by xydbj on 2017.3.9.
 */

public class EventBus1Activity extends Activity implements View.OnClickListener {
    private Button btn;
    private TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eventbus1);

        EventBus.getDefault().register(this);//注册EventBus,最好写在onCreate方法中

        btn = (Button) findViewById(R.id.eventbus1_btn);
        tv = (TextView) findViewById(R.id.eventbus1_tv);
        btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.eventbus1_btn:
                Intent intent = new Intent(EventBus1Activity.this, EventBus2Activity.class);
                startActivity(intent);
                break;
        }
    }

    public void onEventMainThread(FristEvent event) {
        String str = "EventBus1Activity接收到消息了，内容是：" + event.getMessage();
        tv.setText(str);
        Toast.makeText(this, str, Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);//注销EventBus
    }
}
