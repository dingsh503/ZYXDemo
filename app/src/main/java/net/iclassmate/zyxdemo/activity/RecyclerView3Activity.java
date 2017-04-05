package net.iclassmate.zyxdemo.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.widget.Toast;

import net.iclassmate.zyxdemo.R;
import net.iclassmate.zyxdemo.adapter.MyAdapter;
import net.iclassmate.zyxdemo.view.ItemRemoveRecyclerView;
import net.iclassmate.zyxdemo.view.OnItemClickListener;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xydbj on 2016.11.21.
 */
public class RecyclerView3Activity extends Activity {

    private ItemRemoveRecyclerView itemRemoveRecyclerView;
    private List<String> list;
    private MyAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recyclerview3);
        initView();
        initData();
        adapter = new MyAdapter(this,list);
        itemRemoveRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        itemRemoveRecyclerView.setAdapter(adapter);
        itemRemoveRecyclerView.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Toast.makeText(RecyclerView3Activity.this, "** " + list.get(position) + " **", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onDeleteClick(int position) {
                adapter.removeItem(position);
            }

        });
    }

    public void initView() {
        itemRemoveRecyclerView = (ItemRemoveRecyclerView) findViewById(R.id.id_item_remove_recyclerview);
        list = new ArrayList<>();
    }

    public void initData() {
        for (int i = 0; i < 20; i++) {
            list.add("item" + i);
        }
    }
}
