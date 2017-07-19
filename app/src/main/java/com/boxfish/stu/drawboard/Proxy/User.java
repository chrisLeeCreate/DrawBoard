package com.boxfish.stu.drawboard.Proxy;

/**
 * Created by lishaowei on 2017/7/19.
 */

public class User implements UserListener {
    @Override
    public String getName() {
        return "lishaowei";
    }

    @Override
    public int getAge() {
        return 25;
    }
}
