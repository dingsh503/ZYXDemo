package net.iclassmate.zyxdemo.activity;

import android.app.Activity;
import android.content.Intent;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import net.iclassmate.zyxdemo.R;
import net.iclassmate.zyxdemo.view.CircleImageView;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by xydbj on 2017.3.9.
 */

public class MyIcon1Activity extends Activity implements View.OnClickListener {

    @BindView(R.id.glide_iv)
    ImageView glideIv;
    private CircleImageView circleImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_myicon1);
        ButterKnife.bind(this);
        circleImageView = (CircleImageView) findViewById(R.id.myicon1_iv);
        circleImageView.setOnClickListener(this);

        Bitmap bitmap = getImageFromAssetsFile("aaa.jpg");
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, baos);
        byte[] bytes = baos.toByteArray();
        Glide.with(this).load(bytes).into(glideIv);
    }

    private Bitmap getImageFromAssetsFile(String fileName) {
        Bitmap image = null;
        AssetManager am = getResources().getAssets();
        try {
            InputStream is = am.open(fileName);
            image = BitmapFactory.decodeStream(is);
            is.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return image;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.myicon1_iv:
                Intent intent = new Intent(MyIcon1Activity.this, MyIcon2Activity.class);
                startActivity(intent);
                break;
        }
    }

    public static byte[] readInputStream(InputStream inputStream) {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        byte[] bytes = new byte[1024];
        int len = -1;
        try {
            if (inputStream != null) {
                while ((len = inputStream.read(bytes)) != -1) {
                    outputStream.write(bytes, 0, len);
                }
            }
            outputStream.close();
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return outputStream.toByteArray();
    }
}
