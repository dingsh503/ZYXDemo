package net.iclassmate.zyxdemo.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;

import net.iclassmate.zyxdemo.R;
import net.iclassmate.zyxdemo.adapter.StaggeredAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xydbj on 2016.11.21.
 */
public class RecyclerView2Activity extends Activity {

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private List<String> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recyclerview2);
        initView();
        initData();
        mLayoutManager = new StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(mLayoutManager);
        adapter = new StaggeredAdapter(this, list);
        mRecyclerView.setAdapter(adapter);
    }

    public void initView() {
        mRecyclerView = (RecyclerView) findViewById(R.id.rv_recyclerview2);
        list = new ArrayList<>();
    }

    public void initData() {
        for (int i = 0; i < 60; i++) {
            list.add("item" + i);
        }
    }
}
