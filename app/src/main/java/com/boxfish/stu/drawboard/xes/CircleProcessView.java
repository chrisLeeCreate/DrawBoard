package com.boxfish.stu.drawboard.xes;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.Gravity;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.boxfish.stu.drawboard.R;

/**
 * Created by lishaowei on 2017/10/13.
 */

public class CircleProcessView extends LinearLayout {

    private Context mContext;
    private int color;
    private String text = "";
    private String bottomText = "";
    private float process;

    public CircleProcessView(Context context) {
        this(context, null);
    }

    public CircleProcessView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CircleProcessView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mContext = context;
        TypedArray typedArray = context.getTheme().obtainStyledAttributes(attrs, R.styleable.CircleProcessView, defStyleAttr, 0);
        text = typedArray.getString(R.styleable.CircleProcessView_circle_text);
        bottomText = typedArray.getString(R.styleable.CircleProcessView_circle_bottom_text);
        color = typedArray.getColor(R.styleable.CircleProcessView_circle_view_color, Color.rgb(66, 145, 241));
        process = typedArray.getFloat(R.styleable.CircleProcessView_circle_progress, 0);

    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

    }

    public void setCircleText(String text) {
        this.text = text;
    }

    public void setCircleBottomText(String text) {
        this.bottomText = text;
    }

    public void setCircleViewColor(int color) {
        this.color = color;
    }

    public void setCircleProcess(float process) {
        this.process = process;
    }

    public void build() {
        DonutProgress donutProgress = new DonutProgress(mContext);
        donutProgress.setText(text);
        donutProgress.setProgress(process);
        LinearLayout.LayoutParams p = new LinearLayout.LayoutParams(
                (int) (Utils.sp2px(getResources(), 80)),
                (int) (Utils.sp2px(getResources(), 80)));
        donutProgress.setViewColor(color);
        donutProgress.setFinishedStrokeWidth(5);
        donutProgress.setUnfinishedStrokeWidth(1);
        addView(donutProgress, p);

        TextView textView = new TextView(mContext);
        textView.setPadding(0, 10, 0, 0);
        textView.setText(bottomText);
        textView.setTextSize(12);
        textView.setTextColor(color);
        textView.setGravity(Gravity.CENTER_HORIZONTAL);
        addView(textView);
    }
}
