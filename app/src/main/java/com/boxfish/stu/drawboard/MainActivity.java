package com.boxfish.stu.drawboard;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    private DrawPictureView drawPictureView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        drawPictureView = (DrawPictureView) findViewById(R.id.drawPicture);
    }

    public void clearSelect() {
        findViewById(R.id.tvEraser).setSelected(false);
        findViewById(R.id.tvLine).setSelected(false);
        findViewById(R.id.tvPaint).setSelected(false);

    }

    public void clear(View view) {
        drawPictureView.clear();
    }

    public void drawLine(View view) {
        clearSelect();
        findViewById(R.id.tvLine).setSelected(true);
        drawPictureView.paintLine();
    }

    public void drawPaint(View view) {
        clearSelect();
        findViewById(R.id.tvPaint).setSelected(true);
        drawPictureView.paintPaint();

    }

    public void eraser(View view) {
        clearSelect();
        findViewById(R.id.tvEraser).setSelected(true);
        drawPictureView.paintEraser();

    }
}
