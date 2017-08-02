package com.boxfish.stu.drawboard.view.Algorithm;


import java.util.Arrays;

/**
 * Created by lishaowei on 2017/8/2.
 */

public class MergeSort {
    static int number = 0;

    public static void main(String[] args) {
        int[] array = new int[]{2, 7, 3, 5, 2, 1, 0, 9};
        System.out.println("排序前" + Arrays.toString(array));
        sort(array, 0, array.length - 1);
        System.out.println("排序后" + Arrays.toString(array));
    }

    public static void sort(int[] array, int start, int end) {
        if (start >= end) {
            return;
        }
        int mid = (start + end) / 2;
        sort(array, start, mid);
        sort(array, mid + 1, end);
        merge(array, start, mid, end);
    }

    private static void merge(int[] array, int start, int mid, int end) {

        int[] tempArray = new int[array.length];
        int Tmid = mid + 1;
        int Tstart = start;
        int cstart = start;

        while (start <= mid && Tmid <= end) {
            if (array[start] <= array[Tmid]) {
                tempArray[Tstart++] = array[start++];
            } else {
                tempArray[Tstart++] = array[Tmid++];
            }
        }

        while (start <= mid) {
            tempArray[Tstart++] = array[start++];
        }
        while (Tmid <= end) {
            tempArray[Tstart++] = array[Tmid++];
        }
        System.out.println("第" + number + "排序");
        //从临时数组拷贝到原数组
        while (cstart <= end) {
            array[cstart] = tempArray[cstart];
            //输出中间归并排序结果
            System.out.print(array[cstart] + "\t");
            cstart++;
        }
        System.out.println();
    }
}
