package com.boxfish.stu.drawboard;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.boxfish.stu.drawboard.PieView.PieData;
import com.boxfish.stu.drawboard.bezier.BezierView;

import java.util.ArrayList;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        PieView view = new PieView(this);
        BezierView view = new BezierView(this);
//        setContentView(R.layout.activity_main2);
        double data[] = {100, 80, 90, 80, 30, 40};
//        view.setColor(Color.RED).setData(data).setCount(6);
        setContentView(view);
        ArrayList<PieData> datas = new ArrayList<>();
        PieData pieData = new PieData("sloop", 60);
        PieData pieData2 = new PieData("sloop", 30);
        PieData pieData3 = new PieData("sloop", 40);
        PieData pieData4 = new PieData("sloop", 20);
        PieData pieData5 = new PieData("sloop", 20);
        datas.add(pieData);
        datas.add(pieData2);
        datas.add(pieData3);
        datas.add(pieData4);
        datas.add(pieData5);
//        view.setData(datas);
    }
}
