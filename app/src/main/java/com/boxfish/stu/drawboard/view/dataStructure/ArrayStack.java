package com.boxfish.stu.drawboard.view.dataStructure;

/**
 * Created by lishaowei on 2017/8/1.
 */

public class ArrayStack {
    private long[] stack;
    private int size;
    private int top;


    public ArrayStack(int maxSize) {
        this.size = maxSize;
        this.top = -1;
        this.stack = new long[size];
    }

    public void push(long value) {//入栈
        if (isFull()) {
            System.out.println("栈已满");
            return;
        }
        stack[++top] = value;
    }

    public long pop() {
        if (isEmpty()) {
            System.out.println("栈已空");
            return 0;
        }
        return stack[top--];
    }

    public boolean isFull() {
        return (top == size - 1);
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public void display() {
        for (int i = top; i >= 0; i--) {
            System.out.println("栈的第" + stack[i] + "个");
        }
        System.out.println("");
    }
}
