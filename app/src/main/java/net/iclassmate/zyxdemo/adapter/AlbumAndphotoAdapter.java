package net.iclassmate.zyxdemo.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import net.iclassmate.zyxdemo.R;
import net.iclassmate.zyxdemo.bean.ImageState;

import java.util.List;

/**
 * Created by xydbj on 2017.2.16.
 */
public class AlbumAndphotoAdapter extends BaseAdapter {

    public Context context;
    public List<ImageState> list;

    public AlbumAndphotoAdapter(Context context,List<ImageState> list){
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
        if (convertView == null){
            convertView = LayoutInflater.from(context).inflate(R.layout.item_albumandphoto,parent,false);
            holder = new ViewHolder();
            holder.img = (ImageView) convertView.findViewById(R.id.item_albumandphoto_iv);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        return convertView;
    }
    class ViewHolder{
        ImageView img;
    }
}
