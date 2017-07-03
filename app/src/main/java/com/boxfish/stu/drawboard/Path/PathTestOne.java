package com.boxfish.stu.drawboard.Path;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by lishaowei on 2017/7/3.
 */

public class PathTestOne extends View {

    private Paint paint;
    private Path path;
    private Canvas mCanvas;
    private Bitmap mBitmap;

    public PathTestOne(Context context) {
        this(context, null);
    }

    public PathTestOne(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public PathTestOne(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initPaint();
    }

    private void initPaint() {
        setLayerType(View.LAYER_TYPE_SOFTWARE, null);
        paint = new Paint();
        paint.setColor(Color.BLACK);
        paint.setTextSize(50);
        paint.setStyle(Paint.Style.STROKE);
        paint.setAntiAlias(true);
        paint.setDither(true);

        mCanvas = new Canvas();
        path = new Path();
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        mBitmap = Bitmap.createBitmap(w, h, Bitmap.Config.ARGB_8888);
        mCanvas.setBitmap(mBitmap);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawBitmap(mBitmap, new Matrix(), paint);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                float x = event.getX();
                float y = event.getY();
                path = new Path();
                path.moveTo(x, y);
                System.out.println("x:" + x + " y:" + y);
                break;
            case MotionEvent.ACTION_MOVE:
                float nowx = event.getX();
                float nowy = event.getY();
                path.lineTo(nowx, nowy);
                mCanvas.drawPath(path, paint);
                invalidate();
                System.out.println("nowx:" + nowx + " nowy:" + nowy);
                break;

        }
        return true;
    }
}
