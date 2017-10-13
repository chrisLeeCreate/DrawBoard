package com.boxfish.stu.drawboard.view;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.boxfish.stu.drawboard.R;
import com.boxfish.stu.drawboard.xes.DonutProgress;

public class Main3Activity extends AppCompatActivity {

    private Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        mContext = this;
        DonutProgress donutProgress = (DonutProgress) findViewById(R.id.donut_progress);
        donutProgress.setText("798");
        donutProgress.setTextSize(mContext.getResources().getDimension(R.dimen.activity_vertical_margin22));
        donutProgress.setProgress(0);

        DonutProgress donutProgress2 = (DonutProgress) findViewById(R.id.donut_progress2);
        donutProgress2.setText("123");
        donutProgress2.setTextSize(mContext.getResources().getDimension(R.dimen.activity_vertical_margin22));
        donutProgress2.setProgress(60);

        DonutProgress donutProgress23 = (DonutProgress) findViewById(R.id.donut_progress3);
        donutProgress23.setText("369");
        donutProgress23.setTextSize(mContext.getResources().getDimension(R.dimen.activity_vertical_margin22));
        donutProgress23.setProgress(90);


    }

}
