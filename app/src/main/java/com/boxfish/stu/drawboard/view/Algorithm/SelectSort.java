package com.boxfish.stu.drawboard.view.Algorithm;

/**
 * Created by lishaowei on 2017/8/1.
 */

public class SelectSort {

    public static void sort(int[] args) {
        for (int i = 0; i < args.length; i++) {
            int max = args[i];
            for (int j = i + 1; j < args.length; j++) {
                if (max < args[j]) {
                    max = args[j];

                    int temp = args[i];
                    args[i] = args[j];
                    args[j] = temp;
                }
            }
        }

        for (int i = 0; i < args.length; i++) {
            System.out.print(args[i] + " ");
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{4, 3, 5, 2, 6, 7, 1, 8, 9, 0};
        sort(arr);
    }
}
