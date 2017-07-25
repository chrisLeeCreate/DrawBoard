package com.boxfish.stu.drawboard.view.设计模式.factory;

/**
 * Created by lishaowei on 2017/7/25.
 */

public class CofferMachine implements IBeverageMachine {
    @Override
    public Drink makeDrink() {
        return new Coke().make();
    }
}
