package net.iclassmate.zyxdemo.activity;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.provider.MediaStore;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import android.widget.Toast;

import net.iclassmate.zyxdemo.R;
import net.iclassmate.zyxdemo.adapter.AlbumAdapter;
import net.iclassmate.zyxdemo.bean.ImageState;
import net.iclassmate.zyxdemo.view.FullGridView;

import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by xydbj on 2017.2.17.
 */
public class AlbumActivity extends Activity implements OnClickListener {
    private FullGridView fullGridView;
    private List<ImageState> imageStateList;
    private List<ImageState> firstimageStateList;
    private List<String> listPath;
    private AlbumAdapter albumAdapter;
    private Context context;
    private TextView tv_cancel, tv_sure;
    public Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case 1011:
                    Collections.reverse(imageStateList);//图片倒叙排列
                    Collections.reverse(listPath);
                    albumAdapter.notifyDataSetChanged();
                    if(firstimageStateList != null && firstimageStateList.size() > 0){
                        for (int i = 0; i < firstimageStateList.size(); i++) {
                            ImageState imageState = firstimageStateList.get(i);
                            String path = imageState.getFilePath();
                            if(listPath.contains(path)){
                                int index = listPath.indexOf(path);
                                imageState.setCheck(true);
                                imageStateList.set(index, imageState);
                            }
                        }
                        albumAdapter.notifyDataSetChanged();
                    }
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_album);

        Intent intent = getIntent();
        firstimageStateList = (List<ImageState>) intent.getSerializableExtra("selectedPic");


        context = AlbumActivity.this;
        tv_sure = (TextView) findViewById(R.id.album_sure);
        tv_cancel = (TextView) findViewById(R.id.album_cancel);
        fullGridView = (FullGridView) findViewById(R.id.album_fgv);
        imageStateList = new ArrayList<>();
        listPath = new ArrayList<>();
        albumAdapter = new AlbumAdapter(context, imageStateList);
        fullGridView.setAdapter(albumAdapter);

        tv_sure.setOnClickListener(this);
        tv_cancel.setOnClickListener(this);
        selectedPic();
        albumAdapter.setImgClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                int count = selectedPic();
                ImageState imageState = (ImageState) v.getTag();
                boolean check = !imageState.isCheck();
                if(count > 9 && check){
                    Toast.makeText(AlbumActivity.this, "最多选择9张图片", Toast.LENGTH_SHORT).show();
                    return;
                }
                imageState.setCheck(check);
                int index = imageStateList.indexOf(imageState);
                imageStateList.set(index,imageState);
                albumAdapter.notifyDataSetChanged();
                selectedPic();
                if (check){
                    firstimageStateList.add(imageState);
                }else{
                    for (int i = 0; i < firstimageStateList.size(); i++) {
                        ImageState state = firstimageStateList.get(i);
                        if(state.getFilePath().endsWith(imageState.getFilePath())){
                            firstimageStateList.remove(i);
                            break;
                        }
                    }
                }
            }
        });

        openAlbum();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.album_cancel:
                finish();
                break;
            case R.id.album_sure:
                Intent intent = new Intent();
                intent.putExtra("selectedPic", (Serializable) firstimageStateList);
                setResult(RESULT_OK, intent);
                finish();
                break;
        }
    }

    public int selectedPic() {
        int count = 0;
        for (int i = 0; i < imageStateList.size(); i++) {
            ImageState imageState = imageStateList.get(i);
            if (imageState.isCheck()) {
                count++;
            }
        }
        if (count < 1) {
            tv_sure.setText("确定");
        } else {
            tv_sure.setText("确定（" + count + "）");
        }
        return count;
    }

    public void openAlbum() {
        if (!Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {
            Toast.makeText(this, "暂无外部存储", Toast.LENGTH_SHORT).show();
            return;
        }
        new Thread(new Runnable() {
            @Override
            public void run() {
                Uri uri = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
                ContentResolver contentResolver = AlbumActivity.this.getContentResolver();
                Cursor cursor = contentResolver.query(
                        uri,
                        null,
                        MediaStore.Images.Media.MIME_TYPE + "=? or " + MediaStore.Images.Media.MIME_TYPE + "=?",
                        new String[]{"image/jpeg", "image/png"},
                        MediaStore.Images.Media.DATE_MODIFIED);
//                imageStateList.clear();
                while (cursor.moveToNext()) {
                    String fullPath = cursor.getString(cursor.getColumnIndex(MediaStore.Images.Media.DATA));
                    String fileName = cursor.getString(cursor.getColumnIndex(MediaStore.Images.Media.DISPLAY_NAME));
                    File file = new File(fullPath);
                    if (file.exists() && file.isFile()) {
                        ImageState imageState = new ImageState();
                        imageState.setFilePath(fullPath);
//                        imageState.setFileName(fileName);
                        imageState.setCheck(false);
                        imageStateList.add(imageState);
                        listPath.add(fullPath);
                    }
                }
                cursor.close();
                mHandler.sendEmptyMessage(1011);
            }
        }).start();
    }
}
