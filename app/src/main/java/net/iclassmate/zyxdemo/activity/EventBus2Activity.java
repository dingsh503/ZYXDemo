package net.iclassmate.zyxdemo.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import net.iclassmate.zyxdemo.R;
import net.iclassmate.zyxdemo.bean.FristEvent;

import de.greenrobot.event.EventBus;

/**
 * Created by xydbj on 2017.3.9.
 */

public class EventBus2Activity extends Activity implements View.OnClickListener{
    private Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eventbus2);
        btn = (Button) findViewById(R.id.eventbus2_btn);
        btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.eventbus2_btn:
                EventBus.getDefault().post(new FristEvent("这是从EventBus2Activity发送的消息"));
                break;
        }
    }
}
