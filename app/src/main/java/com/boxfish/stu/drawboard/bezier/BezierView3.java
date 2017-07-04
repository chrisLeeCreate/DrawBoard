package com.boxfish.stu.drawboard.bezier;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by lishaowei on 2017/7/4.
 */

public class BezierView3 extends View {

    private int width;
    private int height;
    private Paint paint;

    public BezierView3(Context context) {
        this(context, null);
    }

    public BezierView3(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public BezierView3(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initPaint();
    }

    private void initPaint() {
        paint = new Paint();
        paint.setColor(Color.BLACK);

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

        canvas.scale(1, -1);
        Path path1 = new Path();
        Path path2 = new Path();
        Path path3 = new Path();
        Path path4 = new Path();
        path1.addCircle(0, 0, 200, Path.Direction.CW);
        path2.addRect(0, -200, 200, 200, Path.Direction.CW);
        path3.addCircle(0, 100, 100, Path.Direction.CW);
        path4.addCircle(0, -100, 100, Path.Direction.CW);
        path1.op(path2, Path.Op.DIFFERENCE);
        path1.op(path3, Path.Op.UNION);
        path1.op(path4, Path.Op.DIFFERENCE);
        canvas.drawPath(path1, paint);


    }
}
