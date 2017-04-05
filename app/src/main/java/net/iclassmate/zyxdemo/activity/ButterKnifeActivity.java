package net.iclassmate.zyxdemo.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import net.iclassmate.zyxdemo.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnLongClick;

/**
 * Created by xydbj on 2017.3.13.
 */

public class ButterKnifeActivity extends Activity {

    @BindView(R.id.butterknife_btn)
    Button btn;
    @BindView(R.id.butterknife_txt)
    TextView txt;
    @BindView(R.id.butterknife_btn2)
    Button btn2;
    @BindView(R.id.butterknife_txt2)
    TextView txt2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_butterknife);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.butterknife_btn, R.id.butterknife_txt})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.butterknife_btn:
                Toast.makeText(this, "Button", Toast.LENGTH_SHORT).show();
                break;
            case R.id.butterknife_txt:
                Toast.makeText(this, "TextView", Toast.LENGTH_SHORT).show();
                setTxt();
                break;
        }
    }

    @OnClick(R.id.butterknife_txt2)
    public void setTxt() {
        txt2.setText("-----------------");
    }

    @OnLongClick(R.id.butterknife_btn2)
    public boolean clickBtn2() {
        Toast.makeText(this, "我刚才被长按了", Toast.LENGTH_SHORT).show();
        return true;
    }

}
