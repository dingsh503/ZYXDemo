package net.iclassmate.zyxdemo.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import net.iclassmate.zyxdemo.R;

/**
 * Created by xydbj on 2016.11.10.
 */
public class BFragment extends LazyFragment {
    private TextView fragment_b_tv;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_b, container, false);
        fragment_b_tv = (TextView) view.findViewById(R.id.fragment_b_tv);
        return view;
    }

    @Override
    public String setFragmentTitle() {
        return "B";
    }
}
