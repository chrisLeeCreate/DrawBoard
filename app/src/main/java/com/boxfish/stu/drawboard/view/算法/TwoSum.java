package com.boxfish.stu.drawboard.view.算法;

import java.util.Arrays;
import java.util.HashMap;

/**
 * Created by lishaowei on 2017/7/27.
 */

public class TwoSum {

    public static void main(String[] args) {
        int[] nums = new int[]{2, 7, 11, 13};
        int target = 9;
        int[] ints = towSum(nums, target);
        System.out.println(Arrays.toString(ints));
    }

    private static int[] towSum(int[] nums, int target) {
        HashMap hashMap = new HashMap();
        for (int i = 0; i < nums.length; i++) {

            if (hashMap.containsKey(nums[i])) {
                int[] result = {(int) hashMap.get(nums[i]), i};
                return result;
            } else {
                hashMap.put((target - nums[i]), i);
            }
        }
        int[] result = {};
        return result;
    }
}
