package net.iclassmate.zyxdemo.utils;

import android.content.Context;
import android.widget.ImageView;

import com.jaiky.imagespickers.ImageLoader;
import com.squareup.picasso.Picasso;

/**
 * Created by xydbj on 2016.11.25.
 */
public class PicassoLoader implements ImageLoader {

    private static final long serialVersionUID = 1L;

    @Override
    public void displayImage(Context context, String path, ImageView imageView) {
        Picasso.with(context)
                .load(path)
                .placeholder(com.jaiky.imagespickers.R.drawable.global_img_default)
                .resize(106,106)
                .centerCrop()
                .into(imageView);
    }
}
