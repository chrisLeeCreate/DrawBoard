package com.boxfish.stu.drawboard.view.设计模式.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

/**
 * Created by lishaowei on 2017/7/27.
 */

public class ArrayTest {


    int arrat[] = {1, 2, 3, 4};
    String str2[] = new String[5];

    public static void main(String[] args) {
        int score[] = new int[3];
        String str[] = {"li", "shao", "wei"};

        for (int i = 0; i < score.length; i++) {
            score[i] = i;
        }
        for (int i = 0; i < score.length; i++) {
            System.out.println(score[i]);
        }
        String s = Arrays.toString(score);

        System.out.println(s);
        ArrayList<String> arrayList = new ArrayList<String>(Arrays.asList(str));


        System.out.println("heheheheheh");

        String li = "li";

        for (int i = 0; i < score.length; i++) {
            if (arrayList.contains(li)) {
                System.out.println(arrayList.get(i));
            }
            System.out.println(arrayList.get(i));
        }

        System.out.println("--------------");

        int num[] = {5, 3, 1, 4, 6, 3, 4, 5, 7, 4, 2};
        Arrays.sort(num);
        System.out.println(Arrays.toString(num));

        for (int i : num) {
            System.out.println(i);
        }

        System.out.println("--------------");

        int num2[] = {5, 4, 3, 2, 1};
        int[] ints = Arrays.copyOf(num2, 10);
        System.out.println(Arrays.toString(ints));

        System.out.println("--------------");

        int num4[] = {5, 4, 3, 2, 1};
        int num5[] = {5, 4, 3, 1};
        System.out.println(Arrays.equals(num4, num5));

        System.out.println("--------------");

        int arrar11[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 0, 3, 2, 4, 5, 6, 7, 4, 32, 2, 1, 1, 4, 6, 3};
        HashSet<Integer> integers = new HashSet<>();
        for (int i = 0; i < arrar11.length; i++) {
            integers.add(arrar11[i]);
        }

        System.out.println(integers);

        int[] arr12 = new int[integers.size()];
        int j = 0;
        for (Integer i : integers) {
            arr12[j++] = i;
        }
        System.out.println(Arrays.toString(arr12));


        System.out.println("------------");
        int[] arr11 = {10, 2, 3, 4, 5, 6, 7, 8, 9, 0, 3, 2, 4, 5, 6, 7, 4, 32, 2, 1, 1, 4, 6, 3};
        int max = arr11[0];
        int temp;
        int min = arr11[0];
        for (int i = 0; i < arr11.length; i++) {
            if (max < arr11[i]) {
                max = arr11[i];
            }
            if (min>arr11[i]){
                min=arr11[i];
            }
        }
        System.out.println("max:" + max);
        System.out.println("min:" + min);

    }
}
