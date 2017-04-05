package net.iclassmate.zyxdemo.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import net.iclassmate.zyxdemo.fragment.LazyFragment;

import java.util.List;

/**
 * Created by xydbj on 2016.11.10.
 */
public class FragmentAdapter extends FragmentPagerAdapter {

    private List<LazyFragment> list;

    public FragmentAdapter(FragmentManager fm,List<LazyFragment> list) {
        super(fm);
        this.list = list;
    }


    @Override//标题
    public CharSequence getPageTitle(int position) {
        return list.get(position).setFragmentTitle();
    }

    @Override
    public Fragment getItem(int position) {
        return list.get(position);
    }

    @Override
    public int getCount() {
        return list.size();
    }
}
