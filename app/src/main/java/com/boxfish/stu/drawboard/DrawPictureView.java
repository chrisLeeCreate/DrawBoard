package com.boxfish.stu.drawboard;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.CornerPathEffect;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import java.util.ArrayList;

/**
 * Created by lishaowei on 2017/6/29.
 */

public class DrawPictureView extends View {

    private float donwX;
    private float donwY;
    private Path linePath;

    private Canvas mCanvas;
    private Paint linePaint;
    private int viewWidth;
    private int viewHeight;
    private Bitmap mBitmap;

    private int drawStyle = 0;
    private final int DrawLine = 0;
    private final int DrawPaint = 1;
    private final int DrawEraser = 2;
    private Paint eraserPaint;
    private Paint paintPaint;
    private ArrayList<PathBean> pathlist = new ArrayList<>();
    private ArrayList<PathBean> deletePathList = new ArrayList<>();


    private int lineColor = Color.BLACK;
    private int paintColor = Color.BLUE;
    private float lineWidthProgress = 50;
    private float paintWidthProgress = 50;
    private float eraserWidthProgress = 50;

    private int paintWidth = 70;
    private int eraserWidth = 100;
    private int lineWidth = 20;


    public DrawPictureView(Context context) {
        super(context);
        initlinePaint();
    }

    public DrawPictureView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initlinePaint();
    }

    public DrawPictureView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initlinePaint();
    }

    private void initlinePaint() {
        linePaint = new Paint();
        linePaint.setColor(lineColor);
        linePaint.setStrokeWidth(lineWidth * lineWidthProgress / 100);
        linePaint.setStyle(Paint.Style.STROKE);
        linePaint.setStrokeCap(Paint.Cap.ROUND);
        linePaint.setStrokeJoin(Paint.Join.ROUND);
        linePaint.setPathEffect(new CornerPathEffect(100f));


        paintPaint = new Paint();
        paintPaint.setStyle(Paint.Style.STROKE);
        paintPaint.setColor(paintColor);
        paintPaint.setStrokeCap(Paint.Cap.ROUND);
        paintPaint.setStrokeWidth(paintWidth * paintWidthProgress / 100);
        paintPaint.setPathEffect(new CornerPathEffect(100f));
        paintPaint.setStrokeJoin(Paint.Join.ROUND);

        eraserPaint = new Paint();
        eraserPaint.setAlpha(0);
        eraserPaint.setStyle(Paint.Style.STROKE);
        eraserPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        eraserPaint.setColor(Color.TRANSPARENT);
        eraserPaint.setStrokeWidth(eraserWidth * eraserWidthProgress / 100);
        eraserPaint.setStrokeCap(Paint.Cap.ROUND);
        eraserPaint.setPathEffect(new CornerPathEffect(100f));
        eraserPaint.setStrokeJoin(Paint.Join.ROUND);

        linePath = new Path();
        mCanvas = new Canvas();
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        viewWidth = w;
        viewHeight = h;
        initBitmap();
    }

    private void initBitmap() {
        mBitmap = Bitmap.createBitmap(viewWidth, viewHeight, Bitmap.Config.ARGB_8888);
        mCanvas.setBitmap(mBitmap);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawBitmap(mBitmap, new Matrix(), null);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN: {
                donwX = event.getX();
                donwY = event.getY();
                linePath = new Path();
                linePath.moveTo(donwX, donwY);
                Log.e("donw", "按下了");
                break;
            }
            case MotionEvent.ACTION_MOVE: {
                donwX = event.getX();
                donwY = event.getY();
                linePath.lineTo(donwX, donwY);
                switch (drawStyle) {
                    case DrawLine:
                        mCanvas.drawPath(linePath, linePaint);
                        break;
                    case DrawPaint: {
                        mCanvas.drawPath(linePath, paintPaint);
                        break;
                    }
                    case DrawEraser: {
                        mCanvas.drawPath(linePath, eraserPaint);
                        break;
                    }
                }

                Log.e("move", donwX + "");
                invalidate();
                break;
            }
            case MotionEvent.ACTION_UP: {
                switch (drawStyle) {
                    case DrawLine: {
                        pathlist.add(new PathBean(linePath, linePaint, lineWidthProgress * lineWidth / 100, lineColor));
                        break;
                    }
                    case DrawPaint: {
                        pathlist.add(new PathBean(linePath, paintPaint, paintWidthProgress * paintWidth / 100, paintColor));
                        break;
                    }
                    case DrawEraser: {
                        pathlist.add(new PathBean(linePath, eraserPaint, eraserWidthProgress * eraserWidth / 100, Color.TRANSPARENT));

                        break;
                    }
                }
                deletePathList.clear();
                break;
            }
        }
        return true;
    }

    public void paintLine() {
        drawStyle = DrawLine;
    }

    public void paintPaint() {
        drawStyle = DrawPaint;
    }

    public void paintEraser() {
        drawStyle = DrawEraser;
    }

    public void clear() {
        pathlist.clear();
        deletePathList.clear();
        initBitmap();
        invalidate();
    }

    public void reset() {
        initBitmap();
        if (pathlist.size() > 0) {
            PathBean pathBean = pathlist.get(pathlist.size() - 1);
            pathlist.remove(pathBean);
            deletePathList.add(pathBean);
        }
        for (int i = 0; i < pathlist.size(); i++) {
            pathlist.get(i).paint.setStrokeWidth(pathlist.get(i).width);
            pathlist.get(i).paint.setColor(pathlist.get(i).color);
            mCanvas.drawPath(pathlist.get(i).path, pathlist.get(i).paint);
        }
        invalidate();
    }

    public void forward() {
        if (deletePathList.size() > 0) {
            PathBean pathBean = deletePathList.get(deletePathList.size() - 1);
            pathBean.paint.setStrokeWidth(pathBean.width);
            pathBean.paint.setColor(pathBean.color);
            mCanvas.drawPath(pathBean.path, pathBean.paint);
            deletePathList.remove(deletePathList.size() - 1);
            pathlist.add(pathBean);
        }
        invalidate();
    }

    public int getlineColor() {
        return lineColor;
    }

    public void setLineColor(int lineColor) {
        this.lineColor = lineColor;
        linePaint.setColor(lineColor);
    }

    public int getPaintColor() {
        return paintColor;
    }

    public void setPaintColor(int paintColor) {
        this.paintColor = paintColor;
        paintPaint.setColor(paintColor);
    }

    public float getLineWidthProgress() {
        return lineWidthProgress;
    }

    public void setLineWidthProgress(float lineWidthProgress) {
        this.lineWidthProgress = lineWidthProgress;
    }

    public int getLineWidth() {
        return lineWidth;
    }

    public void setLineWidth() {
        linePaint.setStrokeWidth(lineWidth * lineWidthProgress / 100);
    }

    public float getPaintWidthProgress() {
        return paintWidthProgress;
    }

    public void setPaintWidthProgress(float paintWidthProgress) {
        this.paintWidthProgress = paintWidthProgress;
    }

    public int getPaintWidth() {
        return paintWidth;
    }

    public void setPaintWidth() {
        paintPaint.setStrokeWidth(paintWidth * paintWidthProgress / 100);
    }
    public float getEraserWidthProgress() {
        return eraserWidthProgress;
    }

    public void setEraserWidthProgress(float eraserWidthProgress) {
        this.eraserWidthProgress = eraserWidthProgress;
    }

    public int getEraserWidth() {
        return eraserWidth;
    }

    public void setEraserWidth() {
        eraserPaint.setStrokeWidth(eraserWidth * eraserWidthProgress / 100);
    }

}
