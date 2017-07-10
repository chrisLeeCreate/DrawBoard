package com.boxfish.stu.drawboard.Matrix;

import android.content.Context;
import android.graphics.Matrix;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import java.util.Arrays;

/**
 * Created by lishaowei on 2017/7/6.
 */

public class MatrixView extends View {
    public MatrixView(Context context) {
        this(context, null);
    }

    public MatrixView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public MatrixView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initPaint();
    }

    private void initPaint() {
        float[] floats = {0, 0, 80, 100, 400, 300};
        Matrix matrix = new Matrix();
        matrix.setScale(0.5f, 1f);

        Log.e("lsw", Arrays.toString(floats));
        matrix.mapPoints(floats);
        Log.d("lsw", Arrays.toString(floats));
    }

}

