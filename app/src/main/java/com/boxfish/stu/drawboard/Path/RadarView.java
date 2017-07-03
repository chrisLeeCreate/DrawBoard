package com.boxfish.stu.drawboard.Path;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;


/**
 * Created by lishaowei on 2017/7/3.
 */

public class RadarView extends View {

    private Paint linePaint;
    private Paint valuePaint;
    private Paint textPaint;

    private int centerX;
    private int centerY;
    private float radius;
    private int count = 6;
    private float angle = (float) (Math.PI * 2 / count);
    private double[] data = {100, 60, 60, 60, 100, 50}; //各维度分值
    private String[] titles = {"a", "b", "c", "d", "e", "f"};
    private float maxValue = 100;

    private int color = Color.BLUE;

    public RadarView(Context context) {
        this(context, null);
    }

    public RadarView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public RadarView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initlinePaint();
    }

    private void initlinePaint() {
        setLayerType(LAYER_TYPE_SOFTWARE, null);
        linePaint = new Paint();
        linePaint.setColor(Color.BLACK);
        linePaint.setStyle(Paint.Style.STROKE);
        linePaint.setStrokeWidth(9);

        valuePaint = new Paint();
        valuePaint.setStyle(Paint.Style.FILL_AND_STROKE);

        textPaint = new Paint();
        textPaint.setColor(Color.BLACK);
        textPaint.setStyle(Paint.Style.FILL);
        textPaint.setTextSize(50);

    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        centerX = w;
        centerY = h;
        super.onSizeChanged(w, h, oldw, oldh);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        angle = (float) (Math.PI * 2 / count);
        canvas.translate(centerX / 2, centerY / 2);
        canvas.scale(1, -1);
        radius = (float) (Math.min(centerX, centerY) / 2 * 0.9);
        drawLine(canvas);
        drawRegion(canvas);
        drawText(canvas);
    }

    /**
     * 绘制文字
     *
     * @param canvas
     */
    private void drawText(Canvas canvas) {
        Paint.FontMetrics fontMetrics = textPaint.getFontMetrics();
        float fontHeight = fontMetrics.descent - fontMetrics.ascent;
        for (int i = 0; i < count; i++) {
            float x = (float) ((radius + fontHeight / 2) * Math.cos(angle * i));
            float y = (float) ((radius + fontHeight / 2) * Math.sin(angle * i));
            if (angle * i >= 0 && angle * i <= Math.PI / 2) {//第4象限
                canvas.drawText(titles[i], x, y, textPaint);
            } else if (angle * i >= 3 * Math.PI / 2 && angle * i <= Math.PI * 2) {//第3象限
                canvas.drawText(titles[i], x, y, textPaint);
            } else if (angle * i > Math.PI / 2 && angle * i <= Math.PI) {//第2象限
                float dis = textPaint.measureText(titles[i]);//文本长度
                canvas.drawText(titles[i], x - dis, y, textPaint);
            } else if (angle * i >= Math.PI && angle * i < 3 * Math.PI / 2) {//第1象限
                float dis = textPaint.measureText(titles[i]);//文本长度
                canvas.drawText(titles[i], x - dis, y, textPaint);
            }
        }
    }

    private void drawRegion(Canvas canvas) {
        Path path = new Path();
        valuePaint.setAlpha(255);
        valuePaint.setColor(color);
        for (int i = 0; i < count; i++) {
            double percent = data[i] / maxValue;
            float x = (float) (radius * Math.cos(angle * i) * percent);
            float y = (float) (radius * Math.sin(angle * i) * percent);
            if (i == 0) {
                path.moveTo(x, 0);
            } else {
                path.lineTo(x, y);
            }
            canvas.drawCircle(x, y, 10, valuePaint);
        }
        valuePaint.setStyle(Paint.Style.STROKE);
        canvas.drawPath(path, valuePaint);
        valuePaint.setAlpha(127);
        //绘制填充区域
        valuePaint.setStyle(Paint.Style.FILL_AND_STROKE);
        canvas.drawPath(path, valuePaint);
    }

    private void drawLine(Canvas canvas) {
        float nowradius = radius / count;
        Path path = new Path();
        for (int i = 1; i <= count; i++) {
            for (int j = 0; j <= count; j++) {
                if (j == 0) {
                    path.moveTo((float) (nowradius * i * Math.cos(angle * j)), (float) (nowradius * i * Math.sin(angle * j)));
                } else {
                    path.lineTo((float) (nowradius * i * Math.cos(angle * j)), (float) (nowradius * i * Math.sin(angle * j)));
                }

                if (i == count) {
                    path.moveTo(0, 0);
                    path.lineTo((float) (nowradius * i * Math.cos(angle * j)), (float) (nowradius * i * Math.sin(angle * j)));
                }
            }

        }
        canvas.drawPath(path, linePaint);
    }

    public RadarView setData(double[] data) {
        this.data = data;
        invalidate();
        return this;
    }

    public RadarView setCount(int count) {
        this.count = count;
        invalidate();
        return this;
    }

    public RadarView setColor(int color) {
        this.color = color;
        invalidate();
        return this;
    }
}
