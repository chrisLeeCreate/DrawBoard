package com.boxfish.stu.drawboard.view.设计模式.factory;

/**
 * Created by lishaowei on 2017/7/25.
 */

public class OrangeJuice extends Drink {
    @Override
    String getInstantPackge() {
        return "速溶橙汁粉";
    }

    @Override
    String getName() {
        return "橙汁";
    }
}
