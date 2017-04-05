package net.iclassmate.zyxdemo.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import net.iclassmate.zyxdemo.R;

import java.util.List;

/**
 * Created by xydbj on 2016.12.14.
 */
public class RefreshAdapter extends BaseAdapter {

    private List<String> list;
    private Context context;

    public RefreshAdapter(Context context, List<String> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item_refresh, null);
            holder = new ViewHolder();
            holder.tv = (TextView) convertView.findViewById(R.id.item_refresh_tv);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        holder.tv.setText(list.get(position));

        return convertView;
    }

    class ViewHolder {
        TextView tv;
    }
}
