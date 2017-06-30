package com.boxfish.stu.drawboard.PieView;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import java.util.ArrayList;

/**
 * Created by lishaowei on 2017/6/30.
 */

public class PieView extends View {
    private int[] mColors = {0xFFCCFF00, 0xFF6495ED, 0xFFE32636, 0xFF800000, 0xFF808000, 0xFFFF8C69, 0xFF808080,
            0xFFE6B800, 0xFF7CFC00};
    private Paint paint;
    private int width;
    private int height;

    private ArrayList<PieData> arrayList = new ArrayList<>();
    private int startAngle = 0;

    public PieView(Context context) {
        this(context, null);
    }

    public PieView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public PieView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initPaint();
    }

    private void initPaint() {
        paint = new Paint();
        paint.setStyle(Paint.Style.FILL);
        paint.setAntiAlias(true);
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
        if (arrayList == null)
            return;
        float currentAngle = startAngle;
        canvas.translate(width / 2, height / 2);
        float r = (float) Math.min(width, height);
        RectF rectF = new RectF(-r, -r, r, r);
        for (int i = 0; i < arrayList.size(); i++) {
            PieData pieData = arrayList.get(i);
            paint.setColor(pieData.color);
            canvas.drawArc(rectF, currentAngle, pieData.angle, true, paint);
            currentAngle += pieData.angle;
        }

    }

    public void setData(ArrayList<PieData> arrayList) {
        this.arrayList = arrayList;
        initData(arrayList);
        invalidate();
    }

    private void initData(ArrayList<PieData> arrayList) {
        if (null == arrayList || arrayList.size() == 0)   // 数据有问题 直接返回
            return;

        float sumValue = 0;
        for (int i = 0; i < arrayList.size(); i++) {
            PieData pie = arrayList.get(i);
            sumValue += pie.value;       //计算数值和
            int j = i % mColors.length;       //设置颜色
            pie.color = mColors[j];
        }

        float sumAngle = 0;
        for (int i = 0; i < arrayList.size(); i++) {
            PieData pie = arrayList.get(i);

            float percentage = pie.value / sumValue;   // 百分比
            float angle = percentage * 360;                 // 对应的角度

            pie.percentage = percentage;                  // 记录百分比
            pie.angle = angle;                            // 记录角度大小
            sumAngle += angle;

            Log.i("angle", "" + pie.angle);
        }
    }
}
