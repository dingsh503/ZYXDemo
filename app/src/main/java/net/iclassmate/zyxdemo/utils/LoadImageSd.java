package net.iclassmate.zyxdemo.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import android.os.Handler;
import android.os.Message;
import android.support.v4.util.LruCache;
import android.widget.ImageView;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class LoadImageSd {
	private LruCache<String, Bitmap> lruCache;
	private ExecutorService mImageThreadPool = null;
	private int mHeight, mWidth;
	private Context context;

	public int getmHeight() {
		return mHeight;
	}

	public void setmHeight(int mHeight) {
		this.mHeight = mHeight;
	}

	public int getmWidth() {
		return mWidth;
	}

	public void setmWidth(int mWidth) {
		this.mWidth = mWidth;
	}

	public LoadImageSd() {
		int maxMemory = (int) Runtime.getRuntime().maxMemory();
		int mCacheSize = maxMemory / 4;
		lruCache = new LruCache<String, Bitmap>(mCacheSize) {
			@Override
			protected int sizeOf(String key, Bitmap value) {
				return value.getRowBytes() * value.getHeight();
			}
		};
	}

	public ExecutorService getThreadPool() {
		if (mImageThreadPool == null) {
			synchronized (ExecutorService.class) {
				if (mImageThreadPool == null) {
					mImageThreadPool = Executors.newFixedThreadPool(5);
				}
			}
		}
		return mImageThreadPool;
	}

	/**
	 * 添加Bitmap到内存缓存
	 * 
	 * @param key
	 * @param bitmap
	 */
	public void addBitmapToMemoryCache(String key, Bitmap bitmap) {
		if (getBitmapFromMemCache(key) == null && bitmap != null) {
			lruCache.put(key, bitmap);
		}
	}

	/**
	 * 从内存缓存中获取一个Bitmap
	 * 
	 * @param key
	 * @return
	 */
	public Bitmap getBitmapFromMemCache(String key) {
		return lruCache.get(key);
	}

	/**
	 * 先从内存缓存中获取Bitmap,如果没有就从SD卡或者手机缓存中获取，SD卡或者手机缓存 没有就去下载
	 * 
	 * @param url
	 * @return
	 */
	public void downloadImage(final ImageView imageView, final String url) {
		final Handler handler = new Handler() {
			@Override
			public void handleMessage(Message msg) {
				super.handleMessage(msg);
				// listener.onImageLoader((Bitmap) msg.obj, url);
				String path = (String) imageView.getTag();
				if (path.equals(url)) {
					Bitmap bitmap = (Bitmap) msg.obj;
					imageView.setImageBitmap(bitmap);
				}
			}
		};

		getThreadPool().execute(new Runnable() {
			@Override
			public void run() {
				Bitmap bitmap = getBitmapFormUrl(url);
				Message msg = handler.obtainMessage();
				msg.obj = bitmap;
				handler.sendMessage(msg);
				// 将Bitmap 加入内存缓存
				addBitmapToMemoryCache(url, bitmap);
			}
		});
	}

	/**
	 * 从Url中获取Bitmap
	 * 
	 * @param url
	 * @return
	 */
	private Bitmap getBitmapFormUrl(String url) {
		Bitmap bitmap = null;
		if (getBitmapFromMemCache(url) != null) {
			bitmap = getBitmapFromMemCache(url);
		} else {
			bitmap = getSmallBitmap(url, getmWidth(), getmHeight());
		}
		return bitmap;
	}

	/**
	 * 取消正在下载的任务
	 */
	public synchronized void cancelTask() {
		if (mImageThreadPool != null) {
			mImageThreadPool.shutdownNow();
			mImageThreadPool = null;
		}
	}

	// 计算图片缩放的值
	public float calSampleSize(BitmapFactory.Options options, float requestW,
			float requestH) {
		int height = options.outHeight;
		int width = options.outWidth;
		float sample = 1.0f;
		if (height > requestH || width > requestW) {
			float hRatio = height * 1.0f / requestH;
			float wRatio = width * 1.0f / requestW;
			sample = Math.min(hRatio, wRatio);
		}
		return sample;
	}

	// 根据路径达到图片压缩，返回图片
	public Bitmap getSmallBitmap(String path, float requestW, float requestH) {
		BitmapFactory.Options options = new BitmapFactory.Options();
		options.inJustDecodeBounds = true;
		BitmapFactory.decodeFile(path, options);
		options.inSampleSize = (int) calSampleSize(options, requestW, requestH);
		options.inJustDecodeBounds = false;

		// Bitmap bitmap = BitmapFactory.decodeFile(path, options);
		Bitmap bitmap = null;
		if (context != null) {
			// bitmap = BitmapFactory.decodeResource(context.getResources(),
			// R.mipmap.img_morentupian);
		}
		File file = new File(path);
		if (file.exists()) {
			InputStream is = null;
			try {
				is = new FileInputStream(file);
				bitmap = BitmapFactory.decodeStream(is, new Rect(), options);
				ByteArrayOutputStream bos = new ByteArrayOutputStream();
				if (bitmap != null) {
					bitmap.compress(Bitmap.CompressFormat.JPEG, 20, bos);
				}// BitmapFactory.decodeFile(path, options)
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (Exception e) {

			} catch (OutOfMemoryError error) {

			}
		}
		return bitmap;
	}

	/**
	 * 异步下载图片的回调接口
	 * 
	 * @author len
	 */
	public interface onImageLoaderListener {
		void onImageLoader(Bitmap bitmap, String url);
	}

	public void setContext(Context context) {
		this.context = context;
	}

	public LruCache<String, Bitmap> getLruCache() {
		return lruCache;
	}

	public void setLruCache(LruCache<String, Bitmap> lruCache) {
		this.lruCache = lruCache;
	}
}
