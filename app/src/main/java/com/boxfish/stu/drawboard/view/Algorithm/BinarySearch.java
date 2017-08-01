package com.boxfish.stu.drawboard.view.Algorithm;

/**
 * Created by lishaowei on 2017/8/1.
 */

public class BinarySearch {
    public static int search(int[] args, int key) {
        int low = 0;
        int high = args.length - 1;

        while (low <= high) {
            int middle = (low + high) / 2;
            if (key == args[middle]) {
                return middle;
            } else if (key > args[middle]) {
                low = middle + 1;
            } else {
                high = middle - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] array = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
        int search = search(array,10);
        System.out.println(search);
    }
}
