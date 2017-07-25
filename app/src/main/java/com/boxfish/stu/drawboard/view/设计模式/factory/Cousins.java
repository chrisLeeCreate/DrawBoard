package com.boxfish.stu.drawboard.view.设计模式.factory;

/**
 * Created by lishaowei on 2017/7/25.
 */

public class Cousins {
    private IBeverageMachine iBeverageMachine;

    public void setiBeverageMachine(IBeverageMachine iBeverageMachine) {
        this.iBeverageMachine = iBeverageMachine;
    }

    private Drink takeDrink() {
        if (iBeverageMachine == null) {
            throw new NullPointerException("null");
        }
        return iBeverageMachine.makeDrink();
    }

    public static void main(String[] args) {
        Cousins cousins = new Cousins();

        cousins.setiBeverageMachine(new OrangeJuiceMachine());
        Drink drink = cousins.takeDrink();
        System.out.println(drink.toString());

        cousins.setiBeverageMachine(new CofferMachine());
        Drink drink1 = cousins.takeDrink();
        System.out.println(drink1.toString());

        cousins.setiBeverageMachine(new MengPoMachine());
        Drink drink2 = cousins.takeDrink();
        System.out.println(drink2.toString());
    }
}
