package com.boxfish.stu.drawboard.view.算法;

/**
 * Created by lishaowei on 2017/7/27.
 */

public class Palindrome {
    public static void main(String[] args) {
        int x = 1235321;
        boolean s = isPalindrome(x);
        System.out.println(s);
    }

    private static boolean isPalindrome(int x) {
        boolean flag = true;
        char[] chars = String.valueOf(x).toCharArray();
        for (int i = 0; i < chars.length / 2; i++) {
            if (chars[i] != chars[chars.length - 1 - i]) {
                flag = false;
            }
        }
        return flag;
    }
}
