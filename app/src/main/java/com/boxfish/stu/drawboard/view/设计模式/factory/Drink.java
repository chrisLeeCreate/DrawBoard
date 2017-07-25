package com.boxfish.stu.drawboard.view.设计模式.factory;

/**
 * Created by lishaowei on 2017/7/25.
 */

public abstract class Drink {
    private String name;
    private String instantPackage;

    public Drink make() {
        this.instantPackage = getInstantPackge();
        this.name = getName();
        return this;
    }

    abstract String getInstantPackge();

    abstract String getName();

    @Override
    public String toString() {
        return "Drink{" +
                "name='" + name + '\'' +
                ", instantPackage='" + instantPackage + '\'' +
                '}';
    }
}
