package net.iclassmate.zyxdemo.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import net.iclassmate.zyxdemo.R;

/**
 * Created by xydbj on 2016.11.11.
 */
public class FFragment extends LazyFragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_f,container,false);
        return view;
    }

    @Override
    public String setFragmentTitle() {
        return "F";
    }
}
