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
        findViewById(R.id.tvLine).setSelected(true);
        initListener();
    }

    private void initListener() {
        findViewById(R.id.tvLine).setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                SheetUtil sheetUtil = SheetUtil.getInstance();
                int color = drawPictureView.getlineColor();
                float progress = drawPictureView.getLineWidthProgress();
                sheetUtil.addSheet(MainActivity.this, color, progress);
                sheetUtil.showSheet();
                sheetUtil.setSeekBarChangeListener(new SheetUtil.SeekBarChangeListener() {
                    @Override
                    public void onProgress(float progress) {
                        drawPictureView.setLineWidthProgress(progress);
                        drawPictureView.setLineWidth();
                    }

                    @Override
                    public void onColorChange(int color) {
                        drawPictureView.setLineColor(color);
                    }
                });
                return false;
            }
        });

        findViewById(R.id.tvPaint).setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                SheetUtil sheetUtil = SheetUtil.getInstance();
                int color = drawPictureView.getPaintColor();
                float progress = drawPictureView.getPaintWidthProgress();
                sheetUtil.addSheet(MainActivity.this, color, progress);
                sheetUtil.showSheet();
                sheetUtil.setSeekBarChangeListener(new SheetUtil.SeekBarChangeListener() {
                    @Override
                    public void onProgress(float progress) {
                        drawPictureView.setPaintWidthProgress(progress);
                        drawPictureView.setPaintWidth();
                    }

                    @Override
                    public void onColorChange(int color) {
                        drawPictureView.setPaintColor(color);
                    }
                });
                return false;
            }
        });
        findViewById(R.id.tvEraser).setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                float progress = drawPictureView.getEraserWidthProgress();
                SheetUtil sheetUtil = SheetUtil.getInstance();
                sheetUtil.addSheet(MainActivity.this, -1, progress);
                sheetUtil.showSheet();
                sheetUtil.setSeekBarChangeListener(new SheetUtil.SeekBarChangeListener() {
                    @Override
                    public void onProgress(float progress) {
                        drawPictureView.setEraserWidthProgress(progress);
                        drawPictureView.setEraserWidth();
                    }

                    @Override
                    public void onColorChange(int color) {
                    }
                });
                return false;
            }
        });
    }

    public void clearSelect() {
        findViewById(R.id.tvEraser).setSelected(false);
        findViewById(R.id.tvLine).setSelected(false);
        findViewById(R.id.tvPaint).setSelected(false);

    }

    public void clear(View view) {
        drawPictureView.clear();
    }

    public void reset(View view) {
        drawPictureView.reset();
    }

    public void forward(View view) {
        drawPictureView.forward();
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
