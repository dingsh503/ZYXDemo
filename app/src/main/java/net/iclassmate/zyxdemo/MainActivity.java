package net.iclassmate.zyxdemo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import net.iclassmate.zyxdemo.activity.AlbumAndPhotoActivity;
import net.iclassmate.zyxdemo.activity.BaiduMapActivity;
import net.iclassmate.zyxdemo.activity.BannerActivity;
import net.iclassmate.zyxdemo.activity.BaseUIActivity;
import net.iclassmate.zyxdemo.activity.ButterKnifeActivity;
import net.iclassmate.zyxdemo.activity.CreateFileActivity;
import net.iclassmate.zyxdemo.activity.DataActivity;
import net.iclassmate.zyxdemo.activity.DiyNoHttpActivity;
import net.iclassmate.zyxdemo.activity.EventBus1Activity;
import net.iclassmate.zyxdemo.activity.FeedBackActivity;
import net.iclassmate.zyxdemo.activity.GsonActivity;
import net.iclassmate.zyxdemo.activity.ImagePickerActivity;
import net.iclassmate.zyxdemo.activity.IntentAnimActivity;
import net.iclassmate.zyxdemo.activity.LatestStudyActivity;
import net.iclassmate.zyxdemo.activity.MpChartActivity;
import net.iclassmate.zyxdemo.activity.MusicServiceActivity;
import net.iclassmate.zyxdemo.activity.MyIcon1Activity;
import net.iclassmate.zyxdemo.activity.NoHttpActivity;
import net.iclassmate.zyxdemo.activity.NumAnimTextViewActivity;
import net.iclassmate.zyxdemo.activity.OwnerActivity;
import net.iclassmate.zyxdemo.activity.RecyclerView1Activity;
import net.iclassmate.zyxdemo.activity.RecyclerView2Activity;
import net.iclassmate.zyxdemo.activity.RecyclerView3Activity;
import net.iclassmate.zyxdemo.activity.RefreshActivity;
import net.iclassmate.zyxdemo.activity.ServiceDemo1Activity;
import net.iclassmate.zyxdemo.activity.StateButtonActivity;
import net.iclassmate.zyxdemo.activity.SwipeRecyclerViewActivity;
import net.iclassmate.zyxdemo.activity.TwoCodeActivity;
import net.iclassmate.zyxdemo.activity.WXShareActivity;
import net.iclassmate.zyxdemo.activity.WebViewActivity;
import net.iclassmate.zyxdemo.activity.XBanner1Activity;
import net.iclassmate.zyxdemo.activity.XBanner2Activity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends Activity implements OnClickListener {
    @BindView(R.id.btn_1)
    Button btn1;
    @BindView(R.id.btn_2)
    Button btn2;
    @BindView(R.id.btn_3)
    Button btn3;
    @BindView(R.id.btn_4)
    Button btn4;
    @BindView(R.id.btn_5)
    Button btn5;
    @BindView(R.id.btn_6)
    Button btn6;
    @BindView(R.id.btn_7)
    Button btn7;
    @BindView(R.id.btn_8)
    Button btn8;
    @BindView(R.id.btn_9)
    Button btn9;
    @BindView(R.id.btn_10)
    Button btn10;
    @BindView(R.id.btn_11)
    Button btn11;
    @BindView(R.id.btn_12)
    Button btn12;
    @BindView(R.id.btn_13)
    Button btn13;
    @BindView(R.id.btn_14)
    Button btn14;
    @BindView(R.id.btn_15)
    Button btn15;
    @BindView(R.id.btn_16)
    Button btn16;
    @BindView(R.id.btn_17)
    Button btn17;
    @BindView(R.id.btn_18)
    Button btn18;
    @BindView(R.id.btn_19)
    Button btn19;
    @BindView(R.id.btn_20)
    Button btn20;
    @BindView(R.id.btn_21)
    Button btn21;
    @BindView(R.id.btn_22)
    Button btn22;
    @BindView(R.id.btn_23)
    Button btn23;
    @BindView(R.id.btn_24)
    Button btn24;
    @BindView(R.id.btn_25)
    Button btn25;
    @BindView(R.id.btn_26)
    Button btn26;
    @BindView(R.id.btn_27)
    Button btn27;
    @BindView(R.id.btn_28)
    Button btn28;
    @BindView(R.id.btn_29)
    Button btn29;
    @BindView(R.id.btn_30)
    Button btn30;
    @BindView(R.id.btn_31)
    Button btn31;
    @BindView(R.id.btn_32)
    Button btn32;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @Override
    public void onClick(View view) {
        Intent intent = null;
        switch (view.getId()) {
            case R.id.btn_1:
                intent = new Intent(MainActivity.this, GsonActivity.class);
                break;
            case R.id.btn_2:
                intent = new Intent(MainActivity.this, CreateFileActivity.class);
                break;
            case R.id.btn_3:
                intent = new Intent(MainActivity.this, BaseUIActivity.class);
                break;
            case R.id.btn_4:
                intent = new Intent(MainActivity.this, TwoCodeActivity.class);
                break;
            case R.id.btn_5:
                intent = new Intent(MainActivity.this, RecyclerView1Activity.class);
                break;
            case R.id.btn_6:
                intent = new Intent(MainActivity.this, RecyclerView2Activity.class);
                break;
            case R.id.btn_7:
                intent = new Intent(MainActivity.this, RecyclerView3Activity.class);
                break;
            case R.id.btn_8:
                intent = new Intent(MainActivity.this, StateButtonActivity.class);
                break;
            case R.id.btn_9:
                intent = new Intent(MainActivity.this, ImagePickerActivity.class);
                break;
            case R.id.btn_10:
                intent = new Intent(MainActivity.this, DataActivity.class);
                break;
            case R.id.btn_11:
                intent = new Intent(MainActivity.this, WXShareActivity.class);
                break;
            case R.id.btn_12:
                intent = new Intent(MainActivity.this, WebViewActivity.class);
                break;
            case R.id.btn_13:
                intent = new Intent(MainActivity.this, XBanner1Activity.class);
                break;
            case R.id.btn_14:
                intent = new Intent(MainActivity.this, XBanner2Activity.class);
                break;
            case R.id.btn_15:
                intent = new Intent(MainActivity.this, RefreshActivity.class);
                break;
            case R.id.btn_16:
                intent = new Intent(MainActivity.this, NumAnimTextViewActivity.class);
                break;
            case R.id.btn_17:
                intent = new Intent(MainActivity.this, OwnerActivity.class);
                break;
            case R.id.btn_18:
                intent = new Intent(MainActivity.this, IntentAnimActivity.class);
                break;
            case R.id.btn_19:
                intent = new Intent(MainActivity.this, LatestStudyActivity.class);
                break;
            case R.id.btn_20:
                intent = new Intent(MainActivity.this, NoHttpActivity.class);
                break;
            case R.id.btn_21:
                intent = new Intent(MainActivity.this, FeedBackActivity.class);
                break;
            case R.id.btn_22:
                intent = new Intent(MainActivity.this, AlbumAndPhotoActivity.class);
                break;
            case R.id.btn_23:
                intent = new Intent(MainActivity.this, DiyNoHttpActivity.class);
                break;
            case R.id.btn_24:
                intent = new Intent(MainActivity.this, BaiduMapActivity.class);
                break;
            case R.id.btn_25:
                intent = new Intent(MainActivity.this, MpChartActivity.class);
                break;
            case R.id.btn_26:
                intent = new Intent(MainActivity.this, EventBus1Activity.class);
                break;
            case R.id.btn_27:
                intent = new Intent(MainActivity.this, MyIcon1Activity.class);
                break;
            case R.id.btn_28:
                intent = new Intent(MainActivity.this, ButterKnifeActivity.class);
                break;
            case R.id.btn_29:
                intent = new Intent(MainActivity.this, SwipeRecyclerViewActivity.class);
                break;
            case R.id.btn_30:
                intent = new Intent(MainActivity.this, MusicServiceActivity.class);
                break;
            case R.id.btn_31:
                intent = new Intent(MainActivity.this, ServiceDemo1Activity.class);
                break;
            case R.id.btn_32:
                intent = new Intent(MainActivity.this, BannerActivity.class);
                break;
        }
        startActivity(intent);
    }
}
