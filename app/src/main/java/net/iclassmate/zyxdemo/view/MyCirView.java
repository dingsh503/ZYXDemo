package net.iclassmate.zyxdemo.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import net.iclassmate.zyxdemo.utils.WidthHeightUtils;

/**
 * Created by xydbj on 2017.3.9.
 */

public class MyCirView extends View {

    public Paint mPaint;
    public Context context;
    public Bitmap bitmap;


    public MyCirView(Context context,Bitmap bitmap) {
        super(context);
        this.bitmap = bitmap;
    }

    public MyCirView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        mPaint = new Paint();
        mPaint.setAntiAlias(true);
        mPaint.setColor(Color.BLUE);
        mPaint.setStyle(Paint.Style.STROKE);
    }

    public MyCirView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int width = WidthHeightUtils.getWidth(context);
        int height = WidthHeightUtils.getHeight(context);
        Log.i("info", "自己写的计算屏幕宽高：width=" + width + ";;;height=" + height);

        int x_circle = width / 2;
        int y_circle = height / 2;
        int radius = x_circle - 100;
        this.mPaint.setStrokeWidth(4);
        canvas.drawCircle(x_circle, y_circle, radius, mPaint);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        Log.i("info", "onMeasure中：width=" + getMeasuredWidth() + ";;;height=" + getMeasuredHeight());

    }

}
