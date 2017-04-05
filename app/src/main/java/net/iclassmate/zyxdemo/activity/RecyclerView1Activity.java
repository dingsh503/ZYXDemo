package net.iclassmate.zyxdemo.activity;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;

import net.iclassmate.zyxdemo.R;
import net.iclassmate.zyxdemo.adapter.TestAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xydbj on 2016.11.21.
 */
public class RecyclerView1Activity extends ActionBarActivity {

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private List<String> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycleview1);
        initView();
        initData();
        mLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mAdapter = new TestAdapter(this, list);
        mRecyclerView.setAdapter(mAdapter);
//        mRecyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL_LIST));
    }

    public void initView() {
        mRecyclerView = (RecyclerView) findViewById(R.id.rv_recyclerview1);
        list = new ArrayList<>();
    }

    public void initData() {
        for (int i = 0; i < 60; i++) {
            list.add("item" + i);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.recyclerview_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id){
            case R.id.action_listView:
                mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
                break;
            case R.id.action_gridView:
                mRecyclerView.setLayoutManager(new GridLayoutManager(this,4));
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
