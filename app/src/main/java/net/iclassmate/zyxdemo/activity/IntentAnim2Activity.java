package net.iclassmate.zyxdemo.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import net.iclassmate.zyxdemo.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by xydbj on 2016.12.19.
 */
public class IntentAnim2Activity extends Activity implements View.OnClickListener{
    @BindView(R.id.intentanim2_btn1)
    Button intentanim2Btn1;
    @BindView(R.id.intentanim2_btn2)
    Button intentanim2Btn2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intentanim2);
        ButterKnife.bind(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.intentanim2_btn1:
                finish();
                overridePendingTransition(0, R.anim.out_right);
                break;
            case R.id.intentanim2_btn2:

                break;
        }
    }
}
