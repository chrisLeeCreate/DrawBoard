package com.boxfish.stu.drawboard.xes;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by lishaowei on 2017/10/13.
 */

public class XesView extends View {

    private Paint paint;
    private int witdh;
    private int height;
    private Paint paint2;
    private Paint paint3;

    public XesView(Context context) {
        super(context);
        initPaint();
    }

    public XesView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initPaint();
    }

    public XesView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initPaint();
    }

    private void initPaint() {
        paint = new Paint();
        paint.setColor(Color.BLUE);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(2);


        paint2 = new Paint();
        paint2.setColor(Color.BLUE);
        paint2.setStyle(Paint.Style.FILL);

        paint3 = new Paint();
        paint3.setColor(Color.BLACK);
        paint3.setTextSize(34);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        witdh = w;
        height = h;
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.translate(witdh / 2, height / 2);
        canvas.scale(1, 1);

        canvas.drawCircle(0, 0, 100, paint);
        canvas.drawCircle(0, 0, 80, paint2);
        String s = "LSW";
        canvas.drawText("LSW", -10, 0, paint3);
        canvas.drawText("lishaowei", -60, 150, paint3);
        Path path = new Path();
        RectF rectF = new RectF(-100, -100, 100, 100);
        path.addArc(rectF, 0, 270);
        paint.setStrokeWidth(10);
        canvas.drawPath(path, paint);
    }
}
