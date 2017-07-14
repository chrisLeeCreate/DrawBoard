package com.boxfish.stu.drawboard.bezier;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by lishaowei on 2017/7/12.
 */

public class TaijiView extends View {

    private int width;
    private int height;
    private Paint paint;
    private Paint witepaint;

    public TaijiView(Context context) {
        this(context, null);
    }

    public TaijiView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public TaijiView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initPaint();
    }

    private void initPaint() {
        paint = new Paint();
        paint.setColor(Color.BLACK);
        paint.setStyle(Paint.Style.FILL);

        witepaint = new Paint();
        witepaint.setColor(Color.WHITE);
        witepaint.setStyle(Paint.Style.FILL);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        width = w;
        height = h;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawColor(Color.GRAY);
        canvas.translate(width / 2, height / 2);
        canvas.scale(1, -1);
        float r = (float) (Math.min(width, height) / 2 * 0.8);
        canvas.drawCircle(0, 0, r, paint);
    }
}
