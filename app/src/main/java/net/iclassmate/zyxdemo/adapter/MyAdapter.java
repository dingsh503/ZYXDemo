package net.iclassmate.zyxdemo.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import net.iclassmate.zyxdemo.R;
import net.iclassmate.zyxdemo.view.MyViewHolder;

import java.util.List;

/**
 * Created by xydbj on 2016.11.21.
 */
public class MyAdapter extends RecyclerView.Adapter {

    private Context context;
    private LayoutInflater mInflater;
    private List<String> mList;

    public MyAdapter(Context context, List<String> mList) {
        this.context = context;
        this.mList = mList;
        mInflater = LayoutInflater.from(context);
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.recyclerview_item_layout, parent, false);
        MyViewHolder holder = new MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        MyViewHolder viewHolder = (MyViewHolder) holder;
        viewHolder.content.setText(mList.get(position));
    }

    @Override
    public int getItemCount() {
        return mList != null ? mList.size() : 0;
    }

    public void removeItem(int position) {
        mList.remove(position);
        notifyDataSetChanged();
    }
}
