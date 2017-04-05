package net.iclassmate.zyxdemo.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;
import android.support.v4.util.LruCache;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupMenu;
import android.widget.Toast;

import net.iclassmate.zyxdemo.R;
import net.iclassmate.zyxdemo.bean.ImageState;
import net.iclassmate.zyxdemo.utils.LoadImageSd;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by xydbj on 2017.2.16.
 */
public class AlbumAndPhotoActivity extends Activity implements View.OnClickListener {

    private List<ImageState> list;
    private HorizontalScrollView hsv;
    private LinearLayout hsv_ll;
    private ImageView item_albumandphoto_iv;
    private Button btn_camera, btn_gallery;
    private LoadImageSd load;
    private LruCache<String, Bitmap> lruCache;
    private String camera_photo_name;

    private static final int CAMERA = 1;
    private static final int IMAGE = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_albumandphoto);
        initView();
        setListener();
    }

    public void initView() {
        list = new ArrayList<>();

        btn_camera = (Button) findViewById(R.id.albumandphoto_btn_camera);
        btn_gallery = (Button) findViewById(R.id.albumandphoto_btn_gallery);
        hsv = (HorizontalScrollView) findViewById(R.id.albumandphoto_hsv);
        hsv_ll = (LinearLayout) findViewById(R.id.albumandphoto_hsv_ll);
        View view = LayoutInflater.from(this).inflate(R.layout.item_albumandphoto, null);
        item_albumandphoto_iv = (ImageView) view.findViewById(R.id.item_albumandphoto_iv);
        item_albumandphoto_iv.setOnClickListener(this);
        hsv_ll.addView(view);

        load = new LoadImageSd();
        lruCache = load.getLruCache();
    }

    public void setListener() {
        btn_camera.setOnClickListener(this);
        btn_gallery.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.item_albumandphoto_iv:
                PopupMenu popupMenu = new PopupMenu(AlbumAndPhotoActivity.this, item_albumandphoto_iv);
                popupMenu.getMenuInflater().inflate(R.menu.albumandphoto_menu, popupMenu.getMenu());
                popupMenu.setOnMenuItemClickListener(onMenuItemClickListener);
                popupMenu.show();
                break;
            case R.id.albumandphoto_btn_camera:
                takePhoto();
                break;
            case R.id.albumandphoto_btn_gallery:
                Log.i("info", "点击相册");
                Intent intent = new Intent(AlbumAndPhotoActivity.this, AlbumActivity.class);
                intent.putExtra("selectedPic", (Serializable) list);
                startActivityForResult(intent, IMAGE);
                break;
        }
    }

    public PopupMenu.OnMenuItemClickListener onMenuItemClickListener = new PopupMenu.OnMenuItemClickListener() {
        @Override
        public boolean onMenuItemClick(MenuItem item) {
            switch (item.getItemId()) {
                case R.id.albumandphoto_menu_photo:
                    takePhoto();
                    break;
                case R.id.albumandphoto_menu_album:
                    Intent intent = new Intent(AlbumAndPhotoActivity.this, AlbumActivity.class);
                    intent.putExtra("selectedPic", (Serializable) list);
                    startActivityForResult(intent, IMAGE);
                    break;
                case R.id.albumandphoto_other:
                    Toast.makeText(AlbumAndPhotoActivity.this,"其他",Toast.LENGTH_SHORT).show();
                    break;
            }
            return false;
        }
    };


    public void takePhoto() {
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        String path = Environment.getExternalStorageDirectory() + "/xyd";
        File f = new File(path);
        if (!f.exists()) {
            f.mkdirs();
        }
        camera_photo_name = System.currentTimeMillis() + ".jpg";
        File file = new File(path, camera_photo_name);
        intent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(file));
        startActivityForResult(intent, CAMERA);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            if (requestCode == CAMERA) {
                try {
                    String sdStatus = Environment.getExternalStorageState();
                    if (!sdStatus.equals(Environment.MEDIA_MOUNTED)) {//检测SD卡是否可用
                        Log.i("info", "SD card is not avaiable writeable right now.");
                        return;
                    }
                    String path = Environment.getExternalStorageDirectory() + "/xyd";
                    File file = new File(path);
                    if (!file.exists()) {
                        file.mkdirs();
                    }
                    String fileName = path + "/" + camera_photo_name;
                    Bitmap bitmap = compressImageFromFile(fileName);//从文件夹中获取压缩后的图片
                    FileOutputStream b = new FileOutputStream(fileName);
                    bitmap.compress(Bitmap.CompressFormat.JPEG, 60, b);
                    sendBroadcast(new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE, Uri.fromFile(new File(fileName))));
                    ImageState imageState = new ImageState();
                    imageState.setFilePath(fileName);
                    list.add(imageState);
                    showPic();
                } catch (FileNotFoundException e) {
                    Toast.makeText(this, "获取照片失败,请重新拍照", Toast.LENGTH_SHORT).show();
                    return;
                } catch (NullPointerException e) {
                    Toast.makeText(this, "获取照片失败,请重新拍照", Toast.LENGTH_SHORT).show();
                    return;
                } catch (OutOfMemoryError e) {
                    Toast.makeText(this, "获取照片失败,请重新拍照", Toast.LENGTH_SHORT).show();
                    return;
                }
            } else if (requestCode == IMAGE) {
                Bundle bundle = data.getExtras();
                List<ImageState> imgList = (List<ImageState>) bundle.getSerializable("selectedPic");
                list.clear();
                list.addAll(imgList);
                showPic();
            }
        }
    }

    public void showPic() {
        if (list != null && list.size() > 0) {
            hsv_ll.removeAllViews();
            for (int i = 0; i < list.size(); i++) {
                View view = LayoutInflater.from(this).inflate(R.layout.item_albumandphoto, null);
                ImageView imageView = (ImageView) view.findViewById(R.id.item_albumandphoto_iv);
                imageView.setPadding(15, 15, 15, 15);
                ImageState imageState = list.get(i);
                imageView.setTag(imageState.getFilePath());
                Bitmap bitmap = lruCache.get(imageState.getFilePath());
                if (bitmap != null) {
                    imageView.setImageBitmap(bitmap);
                } else {
                    load.setmWidth(80);
                    load.setmHeight(80);
                    load.downloadImage(imageView, imageState.getFilePath());
                }
                hsv_ll.addView(view);
            }

            View view = LayoutInflater.from(this).inflate(R.layout.item_albumandphoto, null);
            ImageView imageView = (ImageView) view.findViewById(R.id.item_albumandphoto_iv);
            imageView.setPadding(20, 20, 20, 20);
            imageView.setOnClickListener(this);
            hsv_ll.addView(view);
        }
    }

    /**
     * 通过文件全路径压缩文件，得到bitmap对象
     * @param srcPath
     * @return
     */
    public Bitmap compressImageFromFile(String srcPath) {
        BitmapFactory.Options newOpts = new BitmapFactory.Options();
        newOpts.inJustDecodeBounds = false;
        Bitmap bitmap = BitmapFactory.decodeFile(srcPath, null);

        newOpts.inJustDecodeBounds = false;
        int w = newOpts.outWidth;
        int h = newOpts.outHeight;
        WindowManager wm = (WindowManager) this.getSystemService(Context.WINDOW_SERVICE);

        int width = wm.getDefaultDisplay().getWidth();
        int height = wm.getDefaultDisplay().getHeight();
        float hh = width;
        float ww = height;
        int be = 1;
        if (w > h && w > ww) {
            be = (int) (newOpts.outWidth / ww);
        } else if (w < h && h > hh) {
            be = (int) (newOpts.outHeight / hh);
        }
        if (be <= 0)
            be = 1;
        newOpts.inSampleSize = be;

        newOpts.inPurgeable = true;
        newOpts.inInputShareable = true;

        bitmap = BitmapFactory.decodeFile(srcPath, newOpts);
        return bitmap;
    }
}
