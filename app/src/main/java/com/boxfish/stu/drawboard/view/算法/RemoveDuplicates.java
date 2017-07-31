package com.boxfish.stu.drawboard.view.算法;

import java.util.HashSet;

/**
 * Created by lishaowei on 2017/7/27.
 */

public class RemoveDuplicates {
    public static void main(String[] args) {
        int[] a = {2, 3, 3, 2, 2, 3, 4};
//        int[] a={1,1,2};
        int x = remove(a);
        System.out.println(x);
    }

    private static int remove(int[] a) {
        HashSet hashSet = new HashSet();
        for (int x : a) {
            hashSet.add(x);
        }
        System.out.println(hashSet.toString());
        int[] ints = new int[hashSet.size()];
        return hashSet.size();
    }
}
