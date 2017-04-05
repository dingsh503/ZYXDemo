package net.iclassmate.zyxdemo.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import net.iclassmate.zyxdemo.R;
import net.iclassmate.zyxdemo.bean.ProductBean;

import java.util.List;

/**
 * Created by xydbj on 2017.3.24.
 */

public class MyGridViewAdapter extends BaseAdapter {

    Context context;
    List<ProductBean> lists;
    int pageNum;//当前是第几页
    int maxNum;//每页最多显示多少个

    public MyGridViewAdapter(Context context, List<ProductBean> lists, int pageNum, int maxNum) {
        this.context = context;
        this.lists = lists;
        this.pageNum = pageNum;
        this.maxNum = maxNum;
    }

    @Override
    public int getCount() {
        if (lists.size() > (pageNum + 1) * maxNum) {
            return maxNum;
        } else {
            return lists.size() - pageNum * maxNum;
        }
    }

    @Override
    public Object getItem(int position) {
        return lists.get(position + pageNum * maxNum);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item_view, parent, false);
            holder = new ViewHolder();
            holder.tv = (TextView) convertView.findViewById(R.id.item_view_tv);
            holder.img = (ImageView) convertView.findViewById(R.id.item_view_img);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        //重新确定position因为拿到的总是数据源，数据源是分页加载到每页的GridView上的
        int pos = position + pageNum * maxNum;
        holder.tv.setText(lists.get(pos).getName());
        holder.img.setImageResource(lists.get(pos).getId());

        //添加item监听
        //    convertView.setOnClickListener(new View.OnClickListener() {
        //
        //      @Override
        //      public void onClick(View arg0) {
        //        // TODO Auto-generated method stub
        //        Toast.makeText(context, "您点击了" + lists.get(pos).getName(), Toast.LENGTH_SHORT).show();
        //      }
        //    });
        return convertView;
    }

    static class ViewHolder {
        TextView tv;
        ImageView img;
    }
}
