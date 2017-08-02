package com.boxfish.stu.drawboard.view.Algorithm;

/**
 * Created by lishaowei on 2017/8/2.
 */

public class InsertSort {
    public static void sort(int[] args) {
        for (int i = 1; i < args.length; i++) {
            for (int j = 0; j < i; j++) {

                if (args[i] < args[j]) {
                    insertArray(args, j, i);
                    break;
                }
            }
        }


    }

    private static void insertArray(int[] args, int start, int end) {
        int temp = args[end];
        for (int i = end; i > start; i--) {
            args[i] = args[i - 1];
        }
        args[start] = temp;


        System.out.print("这一次的变化：");
        for (Integer i : args) {
            System.out.print(i + " ");
        }
        System.out.println();
    }


    public static void main(String[] args) {
        int[] array = new int[]{5, 3, 8, 6, 4};
        sort(array);
    }
}
