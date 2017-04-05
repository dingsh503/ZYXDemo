package net.iclassmate.zyxdemo.activity;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.view.MotionEvent;
import android.view.View;

import net.iclassmate.zyxdemo.R;
import net.iclassmate.zyxdemo.adapter.FragmentAdapter;
import net.iclassmate.zyxdemo.fragment.AFragment;
import net.iclassmate.zyxdemo.fragment.BFragment;
import net.iclassmate.zyxdemo.fragment.CFragment;
import net.iclassmate.zyxdemo.fragment.DFragment;
import net.iclassmate.zyxdemo.fragment.EFragment;
import net.iclassmate.zyxdemo.fragment.FFragment;
import net.iclassmate.zyxdemo.fragment.LazyFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xydbj on 2016.11.10.
 */
public class BaseUIActivity extends FragmentActivity {

    private ViewPager viewPager;
    private TabLayout tabLayout;
    private List<LazyFragment> fragmentList;
    private FragmentAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_baseui);
        viewPager = (ViewPager) findViewById(R.id.baseui_vp);
        tabLayout = (TabLayout) findViewById(R.id.baseui_tab);
        fragmentList = new ArrayList<>();
        setFragment();
    }

    public void setFragment() {
        AFragment aFragment = new AFragment();
        BFragment bFragment = new BFragment();
        CFragment cFragment = new CFragment();
        DFragment dFragment = new DFragment();
        EFragment eFragment = new EFragment();
        FFragment fFragment = new FFragment();

        fragmentList.add(aFragment);
        fragmentList.add(bFragment);
        fragmentList.add(cFragment);
        fragmentList.add(dFragment);
        fragmentList.add(eFragment);
        fragmentList.add(fFragment);

        adapter = new FragmentAdapter(getSupportFragmentManager(), fragmentList);

        viewPager.setAdapter(adapter);
        viewPager.setOffscreenPageLimit(1);
//        viewPager.setOnPageChangeListener(pageChangeListener);
//        viewPager.setOnTouchListener(touchListener);
        tabLayout.setupWithViewPager(viewPager);
    }

    public View.OnTouchListener touchListener = new View.OnTouchListener() {
        @Override
        public boolean onTouch(View v, MotionEvent event) {
            v.getParent().requestDisallowInterceptTouchEvent(true);
            return false;
        }
    };

    public ViewPager.OnPageChangeListener pageChangeListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {

        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };
}
