package net.iclassmate.zyxdemo.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.yanzhenjie.recyclerview.swipe.SwipeMenuAdapter;

import net.iclassmate.zyxdemo.R;

import java.util.List;

/**
 * Created by xydbj on 2017.3.15.
 */

public class SwipeRecyclerAdapter extends SwipeMenuAdapter<SwipeRecyclerAdapter.MyViewHolder> {

    private List<String> list;
    private OnItemClickListener onItemClickListener;

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public SwipeRecyclerAdapter(List<String> list) {
        this.list = list;
    }

    @Override
    public int getItemCount() {
        return list == null ? 0 : list.size();
    }

    @Override
    public View onCreateContentView(ViewGroup parent, int viewType) {
        return LayoutInflater.from(parent.getContext()).inflate(R.layout.item_swipe, parent, false);
    }

    @Override
    public MyViewHolder onCompatCreateViewHolder(View realContentView, int viewType) {
        return new MyViewHolder(realContentView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.tv_title.setText(list.get(position));
        holder.setOnItemClickListener(onItemClickListener);
    }

    static class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView tv_title;
        TextView tv_content;
        ImageView img;
        OnItemClickListener onItemClickListener;

        public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
            this.onItemClickListener = onItemClickListener;
        }

        MyViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            tv_title = (TextView) itemView.findViewById(R.id.item_swipe_title);
            tv_content = (TextView) itemView.findViewById(R.id.item_swipe_content);
            img = (ImageView) itemView.findViewById(R.id.item_swipe_iv);
        }

        @Override
        public void onClick(View v) {
            if (onItemClickListener != null){
                onItemClickListener.onItemClick(getAdapterPosition());
            }
        }
    }
}
