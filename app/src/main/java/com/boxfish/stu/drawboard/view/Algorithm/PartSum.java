package com.boxfish.stu.drawboard.view.Algorithm;

/**
 * Created by lishaowei on 2017/8/3.
 */

/**
 * 给出一个数字，比如38。然后3+8==11。 然后让1+1=2； 下余10，则返回
 */
public class PartSum {
    public static int partSum(int num) {
        int sum = 0;
        while (num >= 10) {
            sum += num % 10;
            num /= 10;
        }
        sum += num;
        if (sum >= 10) {
            return partSum(sum);
        } else {
            return sum;
        }
    }

    public static void main(String[] args) {
        int i = partSum(66);
        System.out.println(i);
    }
}
