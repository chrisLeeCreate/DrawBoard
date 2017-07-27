package com.boxfish.stu.drawboard.view.设计模式.array.node;

/**
 * Created by lishaowei on 2017/7/27.
 */

public class Node {
    private String data;
    private Node nextNode;

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public Node getNextNode() {
        return nextNode;
    }

    public void setNextNode(Node nextNode) {
        this.nextNode = nextNode;
    }
}
