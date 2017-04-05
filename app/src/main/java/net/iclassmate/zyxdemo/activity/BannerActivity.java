package net.iclassmate.zyxdemo.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import net.iclassmate.zyxdemo.R;
import net.iclassmate.zyxdemo.adapter.MyGridViewAdapter;
import net.iclassmate.zyxdemo.adapter.ViewpagerAdapter;
import net.iclassmate.zyxdemo.bean.ProductBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xydbj on 2017.3.24.
 */

public class BannerActivity extends Activity {

    private ViewPager my_viewPager;
    private LinearLayout my_linearLayout;
    private ImageView[] ivPoints;//小圆点图片集合
    private int totalPage;//总页数
    private int maxNum = 8;//每页显示的最大数
    private List<ProductBean> list;//总数据源
    private List<View> viewPagerList;//多少个GirdView放到集合里

    private String[] proName = {"名称0", "名称1", "名称2", "名称3", "名称4", "名称5",
            "名称6", "名称7", "名称8", "名称9", "名称10", "名称11", "名称12", "名称13",
            "名称14", "名称15", "名称16", "名称17", "名称18", "名称19"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bannergridview);
        //初始化控件
        initView();
        //添加业务逻辑
        initData();
    }

    private void initView() {
        my_viewPager = (ViewPager) findViewById(R.id.my_viewpager);
        my_linearLayout = (LinearLayout) findViewById(R.id.my_linearlayout);
        list = new ArrayList<>();
        for (int i = 0; i < proName.length; i++) {
            list.add(new ProductBean(proName[i], R.mipmap.ic_launcher));
        }
    }

    private void initData() {
        totalPage = (int) Math.ceil(list.size() * 1.0 / maxNum);//总页数向上取整
        viewPagerList = new ArrayList<>();
        for (int i = 0; i < totalPage; i++) {
            final GridView gridview = (GridView) View.inflate(this, R.layout.banner_gridview, null);
            gridview.setAdapter(new MyGridViewAdapter(this, list, i, maxNum));
            gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Object obj = gridview.getItemAtPosition(position);
                    if (obj != null && obj instanceof ProductBean) {
                        Toast.makeText(BannerActivity.this, ((ProductBean) obj).getName(), Toast.LENGTH_SHORT).show();
                    }
                }
            });
            viewPagerList.add(gridview);
        }
        my_viewPager.setAdapter(new ViewpagerAdapter(viewPagerList));

        //卧槽，我终于上传成功了！！！！
        //添加小圆点
        ivPoints = new ImageView[totalPage];
        for (int i = 0; i < totalPage; i++) {
            ivPoints[i] = new ImageView(this);
            if (i == 0) {
                ivPoints[i].setImageResource(R.mipmap.ic_banner_current);
            } else {
                ivPoints[i].setImageResource(R.mipmap.ic_banner_dian);
            }
            ivPoints[i].setPadding(8, 8, 8, 8);
            my_linearLayout.addView(ivPoints[i]);
        }

        //添加滑动，小圆点变色的监听
        my_viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {

            }

            @Override
            public void onPageSelected(int position) {
                for (int i = 0; i < totalPage; i++) {
                    if (i == position) {
                        ivPoints[i].setImageResource(R.mipmap.ic_banner_current);
                    } else {
                        ivPoints[i].setImageResource(R.mipmap.ic_banner_dian);
                    }
                }
            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });
    }
}
