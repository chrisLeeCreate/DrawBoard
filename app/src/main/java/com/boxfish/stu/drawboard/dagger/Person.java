package com.boxfish.stu.drawboard.dagger;

import android.util.Log;

/**
 * Created by lishaowei on 2017/7/10.
 */

public class Person {
    public Person() {
        Log.e("dagger", "person");
        new Clothes();
    }

    public void setClothes() {
        new Clothes();
    }
}
