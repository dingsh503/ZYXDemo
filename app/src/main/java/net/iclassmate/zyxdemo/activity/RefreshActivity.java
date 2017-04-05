package net.iclassmate.zyxdemo.activity;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import com.dinuscxj.refresh.IRefreshStatus;
import com.dinuscxj.refresh.RecyclerRefreshLayout;

import net.iclassmate.zyxdemo.R;
import net.iclassmate.zyxdemo.adapter.RefreshAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xydbj on 2016.12.14.
 */
public class RefreshActivity extends Activity implements IRefreshStatus {
    private ListView lv;
    private RecyclerRefreshLayout refreshLayout;
    private List<String> datas;
    private RefreshAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_refresh);
        initView();
        initData();
        lv.setAdapter(adapter);
        adapter.notifyDataSetChanged();
        refreshLayout.setOnRefreshListener(onRefreshListener);
    }

    public void initView() {
        refreshLayout = (RecyclerRefreshLayout) findViewById(R.id.refresh_layout);
        lv = (ListView) findViewById(R.id.refresh_lv);
        datas = new ArrayList<>();
        adapter = new RefreshAdapter(this, datas);
    }

    public void initData() {
        for (int i = 0; i < 5; i++) {
            datas.add("---" + (i + 1) + "---");
        }
    }

    public RecyclerRefreshLayout.OnRefreshListener onRefreshListener = new RecyclerRefreshLayout.OnRefreshListener() {
        @Override
        public void onRefresh() {
            Toast.makeText(RefreshActivity.this, "onRefresh", Toast.LENGTH_SHORT).show();
            int size = datas.size();
            for (int i = 0; i < 5; i++) {
                datas.add("===" + (size + 1 + i) + "===");
            }
            adapter.notifyDataSetChanged();
            refreshLayout.setRefreshing(false);
        }
    };

    @Override
    public void reset() {
        Toast.makeText(RefreshActivity.this, "reset", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void refreshing() {
        Toast.makeText(RefreshActivity.this, "refreshing", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void pullToRefresh() {
        Toast.makeText(RefreshActivity.this, "pullToRefresh", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void releaseToRefresh() {
        Toast.makeText(RefreshActivity.this, "releaseToRefresh", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void pullProgress(float pullDistance, float pullProgress) {
        Toast.makeText(RefreshActivity.this, "pullProgress", Toast.LENGTH_SHORT).show();
    }
}
