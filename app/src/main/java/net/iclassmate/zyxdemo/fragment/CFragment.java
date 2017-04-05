package net.iclassmate.zyxdemo.fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import net.iclassmate.zyxdemo.R;
import net.iclassmate.zyxdemo.bean.Information;
import net.iclassmate.zyxdemo.utils.CallBackData;
import net.iclassmate.zyxdemo.utils.HttpManager;

/**
 * Created by xydbj on 2016.11.10.
 */
public class CFragment extends LazyFragment implements CallBackData {

    private String userId = "064ed5acaea946a9b49c3803900221ee";
    private TextView fragment_c_tv;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_c, container, false);
        fragment_c_tv = (TextView) view.findViewById(R.id.fragment_c_tv);
        getData();
        return view;
    }

    public void getData() {
        final HttpManager httpManager = new HttpManager(this);
//        httpManager.getUserInformation(userId);

        new Thread(new Runnable() {
            @Override
            public void run() {
            }
        }).start();
    }

    @Override
    public String setFragmentTitle() {
        return "C";
    }

    @Override
    public void sendData(Object object) {
        if (object != null) {
            if (object instanceof Information) {
                Log.i("info","---"+object.toString());
                fragment_c_tv.setText(object.toString());
            }
        }
    }
}
