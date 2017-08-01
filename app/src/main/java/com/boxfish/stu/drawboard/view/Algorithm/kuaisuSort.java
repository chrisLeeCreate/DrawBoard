package com.boxfish.stu.drawboard.view.Algorithm;

/**
 * Created by lishaowei on 2017/8/1.
 */

public class kuaisuSort {

    public void kuaisuSort(int[] args, int start, int end) {
        if (end - start > 1) {
            int mid = 0;
            mid = dividerAndChange(args, start, end);
            kuaisuSort(args, start, mid);
            kuaisuSort(args, mid + 1, end);
        }
    }

    private int dividerAndChange(int[] args, int start, int end) {
        int pivot = args[start];
        while (start < end) {

        }
        return 0;
    }

    private void swap(int[] args, int fromIndex, int toIndex) {
        args[fromIndex] = args[toIndex];
    }
}
