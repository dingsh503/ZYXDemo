package net.iclassmate.zyxdemo.activity;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.widget.Toast;

import com.yanzhenjie.recyclerview.swipe.Closeable;
import com.yanzhenjie.recyclerview.swipe.OnSwipeMenuItemClickListener;
import com.yanzhenjie.recyclerview.swipe.SwipeMenu;
import com.yanzhenjie.recyclerview.swipe.SwipeMenuCreator;
import com.yanzhenjie.recyclerview.swipe.SwipeMenuItem;
import com.yanzhenjie.recyclerview.swipe.SwipeMenuRecyclerView;

import net.iclassmate.zyxdemo.R;
import net.iclassmate.zyxdemo.adapter.OnItemClickListener;
import net.iclassmate.zyxdemo.adapter.SwipeRecyclerAdapter;
import net.iclassmate.zyxdemo.view.ListViewDecoration;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by xydbj on 2017.3.14.
 */

public class SwipeRecyclerViewActivity extends Activity {
    @BindView(R.id.recyclerview)
    SwipeMenuRecyclerView recyclerview;
    List<String> list;
    Context context;
    SwipeRecyclerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_swiperecyclerview);
        ButterKnife.bind(this);
        context = this;
        list = new ArrayList<>();
        initData();
        recyclerview.setLayoutManager(new LinearLayoutManager(context));//布局管理器
        recyclerview.setHasFixedSize(true);//如果Item够简单，置为true将提高性能
        recyclerview.setItemAnimator(new DefaultItemAnimator());//默认动画
        recyclerview.addItemDecoration(new ListViewDecoration(context));//recycleview的分割线
        recyclerview.setSwipeMenuCreator(swipeMenuCreator);//初始化侧面菜单
        recyclerview.setSwipeMenuItemClickListener(onSwipeMenuItemClickListener);//添加菜单监听器
        adapter = new SwipeRecyclerAdapter(list);
        recyclerview.setAdapter(adapter);
        adapter.setOnItemClickListener(onItemClickListener);
    }

    public OnItemClickListener onItemClickListener = new OnItemClickListener() {
        @Override
        public void onItemClick(int position) {
            Toast.makeText(context, "点击了第" + position + "项", Toast.LENGTH_SHORT).show();
        }
    };

    public OnSwipeMenuItemClickListener onSwipeMenuItemClickListener = new OnSwipeMenuItemClickListener() {
        @Override
        public void onItemClick(Closeable closeable, int adapterPosition, int menuPosition, int direction) {

            closeable.smoothCloseMenu();//关闭被点击的菜单

            if (direction == SwipeMenuRecyclerView.RIGHT_DIRECTION) {
                Toast.makeText(context, "ListView的第" + adapterPosition + "项,右侧Menu的第" + menuPosition + "项", Toast.LENGTH_SHORT).show();
                if (menuPosition == 0) {
                    list.set(adapterPosition,"增加Item-----" + adapterPosition);
                } else if (menuPosition == 1) {
                    list.remove(adapterPosition);
                }
                adapter.notifyDataSetChanged();
            } else if (direction == SwipeMenuRecyclerView.LEFT_DIRECTION) {
                Toast.makeText(context, "ListView的第" + adapterPosition + "项,左侧Menu的第" + menuPosition + "项", Toast.LENGTH_SHORT).show();
            }
        }
    };

    //初始化右侧按钮，也可以初始化左侧的按钮，这里只写了右侧的按钮
    public SwipeMenuCreator swipeMenuCreator = new SwipeMenuCreator() {
        @Override
        public void onCreateMenu(SwipeMenu swipeLeftMenu, SwipeMenu swipeRightMenu, int viewType) {

            int size = getResources().getDimensionPixelSize(R.dimen.item_height);
            //给右侧增加第一个按钮
            SwipeMenuItem addItem1 = new SwipeMenuItem(context)
                    .setBackgroundDrawable(R.drawable.selected_green)
                    .setImage(R.mipmap.ic_action_add)
                    .setHeight(size)
                    .setWidth(size);
            swipeRightMenu.addMenuItem(addItem1);
            //给右侧增加第二个按钮
            SwipeMenuItem addItem2 = new SwipeMenuItem(context)
                    .setBackgroundDrawable(R.drawable.selected_red)
                    .setImage(R.mipmap.ic_action_delete)
                    .setHeight(size)
                    .setWidth(size);
            swipeRightMenu.addMenuItem(addItem2);
        }
    };

    public void initData() {
        for (int i = 0; i < 20; i++) {
            list.add("Item---" + i);
        }
    }
}
