package net.iclassmate.zyxdemo.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.stx.xhb.xbanner.XBanner;

import net.iclassmate.zyxdemo.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xydbj on 2016.12.13.
 */
public class XBanner2Activity extends Activity implements View.OnClickListener {
    private XBanner banner;
    private List<String> images;
    private List<String> tips;
    private Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xbanner2);
        initView();
        initData();
        banner.setData(images, tips);
        banner.setmAdapter(adapter);
        banner.setmAutoPlayAble(false);
        banner.setOnPageChangeListener(pageChangeListener);
    }

    public void initView() {
        banner = (XBanner) findViewById(R.id.banner);
        btn = (Button) findViewById(R.id.xbanner2_btn);
        images = new ArrayList<>();
        tips = new ArrayList<>();
    }

    public void initData() {
        images.add("111");
        images.add("222");
        images.add("333");
        tips.add("");
        tips.add("");
        tips.add("");
    }
    public ViewPager.OnPageChangeListener pageChangeListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {
            if (position == 0 || position == 1){
                btn.setVisibility(View.INVISIBLE);
            } else if (position == 2){
                btn.setVisibility(View.VISIBLE);
            }
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };

    public XBanner.XBannerAdapter adapter = new XBanner.XBannerAdapter() {
        @Override
        public void loadBanner(XBanner banner, View view, int position) {
            ImageView iv = (ImageView) view;
            if (images.get(position).equals("111")) {
                iv.setImageResource(R.mipmap.img_huanyingye1);
            } else if (images.get(position).equals("222")) {
                iv.setImageResource(R.mipmap.img_huanyingye2);
            } else if (images.get(position).equals("333")) {
                iv.setImageResource(R.mipmap.img_huanyingye3);
            }
        }
    };

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.xbanner2_btn:
                Toast.makeText(XBanner2Activity.this, "立即登录", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
