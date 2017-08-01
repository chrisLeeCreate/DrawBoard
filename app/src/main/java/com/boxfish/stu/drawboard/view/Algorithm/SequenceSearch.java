package com.boxfish.stu.drawboard.view.Algorithm;

/**
 * Created by lishaowei on 2017/8/1.
 */

public class SequenceSearch {
    //顺序查找
    public static int search(int[] args, int key) {
        for (int i = 0; i < args.length; i++) {
            if (args[i] == key) {
                return i;
            }
        }
        return -1;
    }
}
