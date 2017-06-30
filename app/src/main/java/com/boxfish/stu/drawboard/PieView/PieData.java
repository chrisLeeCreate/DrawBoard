package com.boxfish.stu.drawboard.PieView;

/**
 * Created by lishaowei on 2017/6/30.
 */

public class PieData {
    public String name;
    public float value;
    public float percentage;
    public int color = 0;
    public float angle = 0;

    public PieData(String name, float value) {
        this.name = name;
        this.value = value;
    }
}
