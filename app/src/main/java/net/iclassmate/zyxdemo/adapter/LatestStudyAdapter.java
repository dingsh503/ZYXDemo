package net.iclassmate.zyxdemo.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import net.iclassmate.zyxdemo.bean.lateststudy.LatestStudy;

import java.util.List;

/**
 * Created by xydbj on 2016.12.29.
 */
public class LatestStudyAdapter extends BaseAdapter {

    private List<LatestStudy> list;
    private Context context;

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public int getViewTypeCount() {
        return super.getViewTypeCount();
    }

    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return null;
    }
}
