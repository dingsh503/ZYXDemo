package net.iclassmate.zyxdemo.adapter;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by xydbj on 2017.3.24.
 */

public class ViewpagerAdapter extends PagerAdapter {

    List<View> viewList;

    public ViewpagerAdapter(List<View> viewList) {
        this.viewList = viewList;
    }


    @Override
    public int getCount() {
        return viewList != null ? viewList.size() : 0;
    }

    @Override
    public boolean isViewFromObject(View view, Object o) {
        return view == o;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        container.addView(viewList.get(position));
        return viewList.get(position);
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }
}
