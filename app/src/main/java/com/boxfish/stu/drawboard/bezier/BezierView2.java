package com.boxfish.stu.drawboard.bezier;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.graphics.PointF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by lishaowei on 2017/7/4.
 */

public class BezierView2 extends View {
    private static final float C = 0.551915024494f;     // 一个常量，用来计算绘制圆形贝塞尔曲线控制点的位置
    private Paint paint;
    private int width;
    private int heigght;
    private int radius;
    private Point left;
    private Point top;
    private Point right;
    private Point bottom;
    private PointF leftTop;
    private PointF leftBottom;
    private PointF topLeft;
    private PointF topRight;
    private PointF bottomLeft;
    private PointF bottomRight;
    private PointF righttop;
    private PointF rightBottom;

    public BezierView2(Context context) {
        this(context, null);
    }

    public BezierView2(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public BezierView2(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initPaint();
    }

    private void initPaint() {
        paint = new Paint();
        paint.setColor(Color.BLACK);
        paint.setStrokeWidth(10);
        paint.setStyle(Paint.Style.STROKE);
        left = new Point();
        top = new Point();
        right = new Point();
        bottom = new Point();

        leftTop = new PointF();
        leftBottom = new PointF();
        topLeft = new PointF();
        topRight = new PointF();
        bottomLeft = new PointF();
        bottomRight = new PointF();
        righttop = new PointF();
        rightBottom = new PointF();

    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        width = w;
        heigght = h;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.translate(width / 2, heigght / 2);
        canvas.scale(1, -1);

        radius = (int) (Math.min(width, heigght) / 2 * 0.8);


        top.x = 0;
        top.y = radius;

        leftTop.x = -radius;
        leftTop.y = radius *C;
        topLeft.x = -radius *C;
        topLeft.y = radius;

        left.x = -radius;
        left.y = 0;

        leftBottom.x = -radius;
        leftBottom.y = -radius *C;
        bottomLeft.x = -radius *C;
        bottomLeft.y = -radius;


        bottom.x = 0;
        bottom.y = -radius;

        bottomRight.x = radius *C;
        bottomRight.y = -radius;
        rightBottom.x = radius;
        rightBottom.y = -radius *C;

        right.x = radius;
        right.y = 0;

        righttop.x = radius;
        righttop.y = radius *C;
        topRight.x = radius *C;
        topRight.y = radius ;


        Path path = new Path();
        path.moveTo(top.x, top.y);
        path.cubicTo(topLeft.x, topLeft.y, leftTop.x, leftTop.y, left.x, left.y);
        path.cubicTo(leftBottom.x, leftBottom.y, bottomLeft.x, bottomLeft.y, bottom.x, bottom.y);
        path.cubicTo(bottomRight.x, bottomRight.y, rightBottom.x, rightBottom.y, right.x, right.y);
        path.cubicTo(righttop.x, righttop.y, topRight.x, topRight.y, top.x, top.y);
//        path.quadTo(0, 0, left.x, left.y);
//        path.quadTo(0, 0, bottom.x, bottom.y);
//        path.quadTo(0, 0, right.x, right.y);
//        path.quadTo(0, 0, top.x, top.y);
        canvas.drawPath(path, paint);
    }
}
