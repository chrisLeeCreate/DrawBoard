package com.boxfish.stu.drawboard.view;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Build;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by lishaowei on 2017/6/30.
 */

public class LocationView extends View {
    private int color = Color.GRAY;
    private int color2 = Color.argb(127, 255, 0, 0);
    private int color3 = 0xaaff0000;
    private Paint paint;


    public LocationView(Context context) {
        this(context, null);
    }

    public LocationView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public LocationView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initPaint();

    }

    private void initPaint() {
        paint = new Paint();
        paint.setColor(Color.RED);
        paint.setAntiAlias(true);
        paint.setStrokeWidth(20);
        paint.setStyle(Paint.Style.STROKE);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
//        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int size = MeasureSpec.getSize(widthMeasureSpec);
        int mode = MeasureSpec.getMode(widthMeasureSpec);
        int mode1 = MeasureSpec.getMode(heightMeasureSpec);
        int size1 = MeasureSpec.getSize(heightMeasureSpec);
        setMeasuredDimension(widthMeasureSpec, heightMeasureSpec);
        Log.e("size: ", size + "");
        Log.e("mode: ", mode + "");
        Log.e("size1: ", size1 + "");
        Log.e("mode1: ", mode1 + "");
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);

    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
    }

    float[] array = {500, 500, 600, 600, 600, 700, 800, 800};

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawColor(Color.GRAY);
        canvas.drawPoint(200, 200, paint);
        canvas.drawPoints(array, paint);
//        drawLine(canvas);
//        drawRect(canvas);
//        drawOral(canvas);
//        drawCicle(canvas);
        drawARC(canvas);
    }

    private void drawARC(Canvas canvas) {
        RectF rectF = new RectF(100, 100, 600, 600);
        canvas.drawRect(rectF, paint);

        paint.setColor(Color.BLUE);
        canvas.drawArc(rectF, 0, 90, true, paint);
    }

    private void drawCicle(Canvas canvas) {
        canvas.drawCircle(500, 500, 300, paint);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    private void drawOral(Canvas canvas) {
        canvas.drawOval(500, 500, 1000, 800, paint);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    private void drawRect(Canvas canvas) {
        canvas.drawRect(500, 500, 800, 800, paint);
        paint.setColor(Color.BLUE);
        canvas.drawRoundRect(500, 500, 800, 800, 100, 70, paint);
    }

    private void drawLine(Canvas canvas) {
        canvas.drawLine(300, 300, 500, 500, paint);
        canvas.drawLines(array, paint);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        float x = event.getX();
        float y = event.getY();
        System.out.println("x:" + x + " y:" + y);
        float rawX = event.getRawX();
        float rawY = event.getRawY();
        System.out.println("rawX:" + rawX + " rawY:" + rawY);

        return true;
    }
}
