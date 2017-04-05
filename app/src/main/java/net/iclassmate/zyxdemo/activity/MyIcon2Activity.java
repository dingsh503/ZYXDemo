package net.iclassmate.zyxdemo.activity;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.widget.ImageView;

import net.iclassmate.zyxdemo.R;
import net.iclassmate.zyxdemo.utils.BitmapUtils;
import net.iclassmate.zyxdemo.view.MyCirView;

/**
 * Created by xydbj on 2017.3.9.
 */

public class MyIcon2Activity extends Activity {
    private ImageView imageView;
    private MyCirView myCirView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_myicon2);
        imageView = (ImageView) findViewById(R.id.myicon2_iv);
        myCirView = (MyCirView) findViewById(R.id.mycirview);
        Matrix matrix = new Matrix();
        Bitmap bitmap = ((BitmapDrawable) getResources().getDrawable(R.mipmap.aaa)).getBitmap();
        matrix.setRotate(90);
        bitmap = Bitmap.createBitmap(bitmap,0,0,bitmap.getWidth(),bitmap.getHeight(),matrix,true);
//        imageView.setImageBitmap(bitmap);
        Bitmap bit = BitmapUtils.zoom(bitmap,54,80);
        imageView.setImageBitmap(bit);
    }
}
