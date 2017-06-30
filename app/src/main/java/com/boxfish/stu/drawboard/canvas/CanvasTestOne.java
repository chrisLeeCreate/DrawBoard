package com.boxfish.stu.drawboard.canvas;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by lishaowei on 2017/6/30.
 */

public class CanvasTestOne extends View {

    private Paint paint;

    public CanvasTestOne(Context context) {
        super(context);
        initPaint();
    }

    public CanvasTestOne(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initPaint();
    }

    public CanvasTestOne(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initPaint();
    }

    private void initPaint() {
        setLayerType(LAYER_TYPE_HARDWARE, null);
        paint = new Paint();
        paint.setColor(Color.BLACK);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawColor(Color.GRAY);
        canvas.translate(200, 200);
        canvas.drawCircle(0, 0, 100, paint);

        paint.setColor(Color.BLUE);
        canvas.translate(200, 200);
        canvas.scale(-0.5f, -0.5f);
        canvas.drawCircle(0, 0, 100, paint);
    }
}
