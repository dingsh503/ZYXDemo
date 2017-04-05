package net.iclassmate.zyxdemo.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.v4.util.LruCache;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.squareup.picasso.Transformation;

import net.iclassmate.zyxdemo.R;
import net.iclassmate.zyxdemo.bean.ImageState;
import net.iclassmate.zyxdemo.utils.LoadImageSd;

import java.util.List;

/**
 * Created by xydbj on 2017.2.17.
 */
public class AlbumAdapter extends BaseAdapter {
    private Context context;
    private List<ImageState> list;
    private LoadImageSd load;
    private LruCache<String,Bitmap> lruCache;
    private View.OnClickListener imgClickListener;

    public View.OnClickListener getImgClickListener() {
        return imgClickListener;
    }

    public void setImgClickListener(View.OnClickListener imgClickListener) {
        this.imgClickListener = imgClickListener;
    }

    public AlbumAdapter(Context context, List<ImageState> list) {
        this.context = context;
        this.list = list;
        load = new LoadImageSd();
        load.setContext(context);
        lruCache = load.getLruCache();
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item_photo2, null);
            holder = new ViewHolder();
            holder.img = (ImageView) convertView.findViewById(R.id.item_photo2_iv);
            holder.img_click = (ImageView) convertView.findViewById(R.id.item_photo2_click);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        ImageState imageState = list.get(position);
        boolean isClick = imageState.isCheck();
        holder.img.setTag(imageState.getFilePath());

        Bitmap bitmap = lruCache.get(imageState.getFilePath());
        if(bitmap != null){
            holder.img.setImageBitmap(bitmap);
        }else {
            load.setmWidth(80);
            load.setmHeight(80);
            holder.img.setImageResource(R.mipmap.ic_launcher);
            load.downloadImage(holder.img,imageState.getFilePath());
        }
        if(isClick){
            holder.img_click.setImageResource(R.mipmap.ic_selected);
        } else {
            holder.img_click.setImageResource(R.mipmap.ic_unselected);
        }
        holder.img_click.setTag(imageState);
        holder.img_click.setOnClickListener(imgClickListener);
        return convertView;
    }

    class ViewHolder {
        ImageView img;
        ImageView img_click;
    }

    public class CircleTransform implements Transformation {
        @Override
        public Bitmap transform(Bitmap source) {
            int size = Math.min(source.getWidth(), source.getHeight());

            int x = (source.getWidth() - size) / 2;
            int y = (source.getHeight() - size) / 2;

            Bitmap squaredBitmap = Bitmap
                    .createBitmap(source, x, y, size, size);
            if (squaredBitmap != source) {
                source.recycle();
            }

            Bitmap bitmap = Bitmap.createBitmap(size, size, source.getConfig());

            Canvas canvas = new Canvas(bitmap);
            Paint paint = new Paint();
            BitmapShader shader = new BitmapShader(squaredBitmap,
                    BitmapShader.TileMode.CLAMP, BitmapShader.TileMode.CLAMP);
            paint.setShader(shader);
            paint.setAntiAlias(true);

            float r = size / 2f;
            canvas.drawCircle(r, r, r, paint);

            squaredBitmap.recycle();
            return bitmap;
        }

        @Override
        public String key() {
            return "circle";
        }
    }
}
