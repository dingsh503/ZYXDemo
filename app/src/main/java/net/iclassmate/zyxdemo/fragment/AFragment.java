package net.iclassmate.zyxdemo.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import net.iclassmate.zyxdemo.R;

/**
 * Created by xydbj on 2016.11.10.
 */
public class AFragment extends LazyFragment {
    private ImageView fragment_a_iv;
    private String url = "http://space-oss.iclassmate.cn/user/ctsi/filestore/buffer/2016111409/9267db2226ae423fb00928a957446b3e/9267db2226ae423fb00928a957446b3e.jpg";
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_a,container,false);
        fragment_a_iv = (ImageView) view.findViewById(R.id.fragment_a_iv);
        Picasso.with(getActivity()).load(url).into(fragment_a_iv);
        return view;
    }

    @Override
    public String setFragmentTitle() {
        return "A";
    }
}
