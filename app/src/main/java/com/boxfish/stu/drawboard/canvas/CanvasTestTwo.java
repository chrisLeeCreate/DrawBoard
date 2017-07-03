package com.boxfish.stu.drawboard.canvas;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.boxfish.stu.drawboard.R;

/**
 * Created by lishaowei on 2017/7/3.
 */

public class CanvasTestTwo extends View {

    private Bitmap bitmap;
    private Paint paint;
    private int width;
    private int height;

    public CanvasTestTwo(Context context) {
        this(context, null);
    }

    public CanvasTestTwo(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CanvasTestTwo(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initBitMap();
    }

    private void initBitMap() {
        paint = new Paint();
        paint.setAntiAlias(true);
        paint.setColor(Color.BLACK);
        paint.setStyle(Paint.Style.FILL);
        paint.setTextSize(30);
        paint.setTypeface(Typeface.DEFAULT);
        bitmap = BitmapFactory.decodeResource(getContext().getResources(), R.drawable.a6);
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
        canvas.translate(width / 2, height / 2);
        Rect rect = new Rect(0, 0, bitmap.getWidth() / 2, bitmap.getHeight() / 2);
        Rect dst = new Rect(0, 0, 200, 300);
        canvas.drawBitmap(bitmap, rect, dst, null);
//        canvas.drawText("lishaowei", 1, 3, 200, 200, paint);
        canvas.drawPosText(new char[]{'l', 's', 'w', 'n', 'b'}, 0, 3, new float[]{100, 100, 200, 200, 300, 300, 400, 400}, paint);
    }
}
