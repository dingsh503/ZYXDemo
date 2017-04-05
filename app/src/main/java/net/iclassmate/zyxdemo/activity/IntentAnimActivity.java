package net.iclassmate.zyxdemo.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import net.iclassmate.zyxdemo.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by xydbj on 2016.12.19.
 */
public class IntentAnimActivity extends Activity implements View.OnClickListener {

    @BindView(R.id.intentanim_btn1)
    Button intentanimBtn1;
    @BindView(R.id.intentanim_btn2)
    Button intentanimBtn2;
    @BindView(R.id.intentanim_btn3)
    Button intentanimBtn3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intentanim);
        ButterKnife.bind(this);
    }

    /**
     * overridePendingTransition(int enterAnim, int exitAnim)
     * <p/>
     * enterAnim 定义Activity进入屏幕时的动画
     * <p/>
     * exitAnim 定义Activity退出屏幕时的动画
     * <p/>
     * overridePendingTransition 方法必须在startActivity()或者 finish()方法的后面。
     */
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.intentanim_btn1:
                Intent intent = new Intent(IntentAnimActivity.this, IntentAnim2Activity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.in_right, 0);
                break;
            case R.id.intentanim_btn2:
                Intent intent2 = new Intent(IntentAnimActivity.this, IntentAnim2Activity.class);
                startActivity(intent2);
                overridePendingTransition(R.anim.botton_in,0);
                break;
            case R.id.intentanim_btn3:
                Intent intent3 = new Intent(IntentAnimActivity.this, IntentAnim2Activity.class);
                startActivity(intent3);
                //实现zoommin 和 zoomout,即类似iphone的进入和退出时的效果
                overridePendingTransition(R.anim.zoomin, R.anim.zoomout);
                break;
        }
    }
}
