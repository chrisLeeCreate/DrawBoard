package com.boxfish.stu.drawboard.view.dataStructure;

/**
 * Created by lishaowei on 2017/8/1.
 */

public class Test {
    public static void main(String[] args) {
        ArrayStack arrayStack = new ArrayStack(10);
        boolean empty = arrayStack.isEmpty();
        System.out.println(empty);
        arrayStack.push(1);
        arrayStack.push(3);
        arrayStack.push(2);
        arrayStack.push(5);
        arrayStack.push(4);
        System.out.println(arrayStack.isEmpty() + "  " + arrayStack.isFull());
        arrayStack.display();

        System.out.println(arrayStack.pop());
        System.out.println(arrayStack.pop());
        System.out.println(arrayStack.pop());
        System.out.println(arrayStack.pop());
        System.out.println(arrayStack.pop());
        System.out.println(arrayStack.pop());
        arrayStack.display();
    }
}
