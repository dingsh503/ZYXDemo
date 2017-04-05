package net.iclassmate.zyxdemo.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.squareup.picasso.Picasso;
import com.stx.xhb.xbanner.XBanner;
import com.stx.xhb.xbanner.transformers.Transformer;

import net.iclassmate.zyxdemo.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xydbj on 2016.12.13.
 */
public class XBanner1Activity extends Activity {

    private XBanner xBanner;
    private List<String> images;
    private List<String> titles;
    private RadioGroup transforms;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xbanner1);
        initView();
        initData();
        // 为XBanner绑定数据
        xBanner.setData(images, titles);
        // XBanner适配数据
        xBanner.setmAdapter(new XBanner.XBannerAdapter() {
            @Override
            public void loadBanner(XBanner banner, View view, int position) {
                Picasso.with(XBanner1Activity.this).load(images.get(position)).into((ImageView) view);
            }
        });
        // 设置XBanner的页面切换特效
        xBanner.setPageTransformer(Transformer.Default);
        // 设置XBanner页面切换的时间，即动画时长
        xBanner.setPageChangeDuration(1000);

        // RadioGroup中选中某个RadioButton时回调的方法
        transforms.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.rb_default:
                        xBanner.setPageTransformer(Transformer.Default);
                        break;
                    case R.id.rb_alpha:
                        xBanner.setPageTransformer(Transformer.Alpha);
                        break;
                    case R.id.rb_rotate:
                        xBanner.setPageTransformer(Transformer.Rotate);
                        break;
                    case R.id.rb_cube:
                        xBanner.setPageTransformer(Transformer.Cube);
                        break;
                    case R.id.rb_flip:
                        xBanner.setPageTransformer(Transformer.Flip);
                        break;
                    case R.id.rb_accordion:
                        xBanner.setPageTransformer(Transformer.Accordion);
                        break;
                    case R.id.rb_zoomfade:
                        xBanner.setPageTransformer(Transformer.ZoomFade);
                        break;
                    case R.id.rb_zoomcenter:
                        xBanner.setPageTransformer(Transformer.ZoomCenter);
                        break;
                    case R.id.rb_zoomstack:
                        xBanner.setPageTransformer(Transformer.ZoomStack);
                        break;
                    case R.id.rb_stack:
                        xBanner.setPageTransformer(Transformer.Stack);
                        break;
                    case R.id.rb_depth:
                        xBanner.setPageTransformer(Transformer.Depth);
                        break;
                }
            }
        });

        // XBanner中某一项的点击事件
        xBanner.setOnItemClickListener(new XBanner.OnItemClickListener() {
            @Override
            public void onItemClick(XBanner banner, int position) {
                Toast.makeText(XBanner1Activity.this, "点击了第" + (position + 1) + "张图片", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void initView() {
        xBanner = (XBanner) findViewById(R.id.banner);
        transforms = (RadioGroup) findViewById(R.id.transforms);
        images = new ArrayList<>();
        titles = new ArrayList<>();
    }

    public void initData() {
        images.add("http://img3.fengniao.com/forum/attachpics/913/114/36502745.jpg");
        titles.add("这是第1张图片这是第1张图片这是第1张图片这是第1张图片这是第1张图片这是第1张图片这是第1张图片这是第1张图片这是第1张图片");
        images.add("http://imageprocess.yitos.net/images/public/20160910/99381473502384338.jpg");
        titles.add("这是第2张图片这是第2张图片这是第2张图片这是第2张图片这是第2张图片这是第2张图片这是第2张图片这是第2张图片这是第2张图片");
        images.add("http://imageprocess.yitos.net/images/public/20160910/77991473496077677.jpg");
        titles.add("这是第3张图片这是第3张图片这是第3张图片这是第3张图片这是第3张图片这是第3张图片这是第3张图片这是第3张图片这是第3张图片");
        images.add("http://imageprocess.yitos.net/images/public/20160906/1291473163104906.jpg");
        titles.add("这是第4张图片这是第4张图片这是第4张图片这是第4张图片这是第4张图片这是第4张图片这是第4张图片这是第4张图片这是第4张图片");
    }

    //当Activity失去焦点时立即停止自动轮播；当Activity获得焦点时才开始自动轮播
    @Override
    protected void onResume() {
        super.onResume();
        xBanner.startAutoPlay();
    }

    @Override
    protected void onStop() {
        super.onStop();
        xBanner.stopAutoPlay();
    }

}
