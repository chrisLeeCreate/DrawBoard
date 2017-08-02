package com.boxfish.stu.drawboard.view.Algorithm;

/**
 * Created by lishaowei on 2017/8/1.
 */

public class BubbleSort {
    public static void sort(int[] args) {
        for (int i = 0; i < args.length; i++) {
            for (int j = i + 1; j < args.length; j++) {
                if (args[i] > args[j]) {
                    int temp = args[i];
                    args[i] = args[j];
                    args[j] = temp;
                }
            }
        }

        for (int i = 0; i < args.length; i++) {
            System.out.println(args[i] + "");
        }
    }

    public static void main(String[] args) {
        int[] array = new int[]{5, 4, 6, 3, 7, 8, 9, 2, 1, 0};
        sort(array);
    }
}
