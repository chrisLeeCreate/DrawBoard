package com.boxfish.stu.drawboard;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by lishaowei on 2017/6/30.
 */

public class Heartbeat extends View {

    private Canvas mCanvas;
    private Paint mPaint;
    private Bitmap bottomBitmap;
    private Bitmap topBitmap;
    private float x;
    private float y;
    private Path path;
    private Bitmap blankBitmap;

    public Heartbeat(Context context) {
        this(context, null);
    }

    public Heartbeat(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public Heartbeat(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initPaint();
    }

    private void initPaint() {
//        setLayerType(LAYER_TYPE_SOFTWARE, null);
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inSampleSize = 1;
        topBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.a6);
        topBitmap = Bitmap.createScaledBitmap(topBitmap, getResources().getDisplayMetrics().widthPixels, getResources().getDisplayMetrics().heightPixels, true);

        bottomBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.b6);
        bottomBitmap = Bitmap.createScaledBitmap(bottomBitmap, getResources().getDisplayMetrics().widthPixels, getResources().getDisplayMetrics().heightPixels, true);
        mCanvas = new Canvas();
        blankBitmap = Bitmap.createBitmap(getResources().getDisplayMetrics().widthPixels, getResources().getDisplayMetrics().heightPixels, Bitmap.Config.ARGB_8888);
        mCanvas.setBitmap(blankBitmap);

        path = new Path();

        mPaint = new Paint();
        mPaint.setAntiAlias(true);
        mPaint.setDither(true);
        mPaint.setColor(Color.BLACK);
        mPaint.setStrokeJoin(Paint.Join.ROUND);
        mPaint.setStrokeCap(Paint.Cap.ROUND);
        mPaint.setStyle(Paint.Style.STROKE);

        mCanvas.drawBitmap(topBitmap, 0, 0, mPaint);

        mPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        mPaint.setStrokeWidth(50);

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawBitmap(bottomBitmap, 0, 0, null);
        canvas.drawBitmap(blankBitmap, 0, 0, null);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN: {
                x = event.getX();
                y = event.getY();
                path.moveTo(x, y);
                break;
            }
            case MotionEvent.ACTION_MOVE: {
                float nowX = event.getX();
                float nowY = event.getY();
                path.lineTo(nowX, nowY);
                mCanvas.drawPath(path, mPaint);
                invalidate();
                break;
            }
        }
        return true;
    }
}
