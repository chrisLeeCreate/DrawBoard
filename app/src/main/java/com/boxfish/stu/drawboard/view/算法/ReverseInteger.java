package com.boxfish.stu.drawboard.view.算法;

/**
 * Created by lishaowei on 2017/7/27.
 */

public class ReverseInteger {

    public static void main(String[] args) {
//        int x = 1534236469;
        int x = -153429;
        int reverse = reverse(x);
        System.out.println(reverse);
    }

    private static int reverse(int x) {
        String s = String.valueOf(x);
        boolean flag = false;
        char[] chars = s.toCharArray();
        if (chars[0] == '-') {
            flag = true;
        }

        StringBuffer stringBuffer = new StringBuffer();
        for (int i = chars.length - 1; i >= 0; i--) {
            if (i == 0 && flag) {
                break;
            }
            stringBuffer.append(chars[i]);
        }
        int anInt;
        try {
            anInt = Integer.parseInt(new String(stringBuffer));
        } catch (NumberFormatException e) {
//            e.printStackTrace();
            anInt=0;
        }

        if (flag) {
            anInt -= 2 * anInt;
        }
        return anInt;
    }
}
