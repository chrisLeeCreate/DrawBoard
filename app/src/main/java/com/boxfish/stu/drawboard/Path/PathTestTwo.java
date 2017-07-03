package com.boxfish.stu.drawboard.Path;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by lishaowei on 2017/7/3.
 */

public class PathTestTwo extends View {

    private int width;
    private int height;
    private Paint paint;
    private Path path;

    public PathTestTwo(Context context) {
        this(context, null);
    }

    public PathTestTwo(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public PathTestTwo(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        paint = new Paint();
        paint.setColor(Color.BLACK);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(10);
        path = new Path();

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
//        pathTestone();
//        pathTestTwo();
//        pathTestThree();
        pathTestFour();
        canvas.drawPath(path, paint);
    }

    private void pathTestFour() {
        path.lineTo(100, 100);
        RectF rectF = new RectF(0, 0, 300, 300);
//        path.addArc(rectF, 0, 270); ／／仅仅是添加进去
        path.arcTo(rectF, 0, 270); //添加一个圆弧到path，如果圆弧的起点和上次最后一个坐标点不相同，就连接两个点
    }

    private void pathTestThree() {
        Path src = new Path();
        path.addRect(-200, -200, 200, 200, Path.Direction.CW);
        src.addCircle(0, 200, 100, Path.Direction.CW);
        path.addPath(src);
    }

    private void pathTestTwo() {
        path.addRect(-200, -200, 200, 200, Path.Direction.CCW);
        path.setLastPoint(-300, 300);
    }

    private void pathTestone() {
        path.lineTo(200, 200);
        path.moveTo(200, 100);
//        path.setLastPoint(200,100);
        path.lineTo(200, 0);
        //close的作用是封闭路径，与连接当前最后一个点和第一个点并不等价。
        // 如果连接了最后一个点和第一个点仍然无法形成封闭图形，则close什么 也不做。
        path.close();
    }
}
