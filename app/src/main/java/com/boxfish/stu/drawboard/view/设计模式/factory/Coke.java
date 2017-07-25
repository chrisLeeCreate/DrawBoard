package com.boxfish.stu.drawboard.view.设计模式.factory;

/**
 * Created by lishaowei on 2017/7/25.
 */

public class Coke extends Drink {
    @Override
    String getInstantPackge() {
        return "速溶可乐粉";
    }

    @Override
    String getName() {
        return "可乐";
    }
}
