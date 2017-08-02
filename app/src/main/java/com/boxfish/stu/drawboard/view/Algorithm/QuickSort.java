package com.boxfish.stu.drawboard.view.Algorithm;


import java.util.Arrays;

/**
 * Created by lishaowei on 2017/8/1.
 */

public class QuickSort {


    public static void main(String[] args) {
        int[] array = {48, 15, 24, 59, 64, 79, 97, 40};
        sorts(array, 0, array.length - 1);
    }

    private static void sorts(int[] array, int low, int hight) {
        if (low>=hight){
            return;
        }
        int index = partition(array, low, hight);
        sorts(array, low, index - 1);
        sorts(array, index + 1, hight);
        System.out.println(Arrays.toString(array));
    }

    private static int partition(int[] array, int low, int hight) {
        int key = array[low];
        while (low < hight) {
            while (array[hight] >= key && low < hight) {
                hight--;
            }
            array[low] = array[hight];

            while (array[low] <= key && low < hight) {
                low++;
            }
            array[hight] = array[low];
        }
        array[hight] = key;
        return hight;
    }
}
