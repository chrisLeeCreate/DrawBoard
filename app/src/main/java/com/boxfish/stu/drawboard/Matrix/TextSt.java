package com.boxfish.stu.drawboard.Matrix;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by lishaowei on 2017/7/6.
 */

public class TextSt {
    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        LinkedList<Integer> linkedList = new LinkedList<>();
        for (int i = 0; i < 10000; i++) {
            arrayList.add(i);
            linkedList.add(i);
        }

        long startTime = System.currentTimeMillis();
        loopList(arrayList);
        long endTime = System.currentTimeMillis();
        System.out.println("消耗时间" + (endTime - startTime));
        System.out.println("");
        long startTime2 = System.currentTimeMillis();
        loopList(linkedList);
        for (Integer l : linkedList) {
            System.out.println(l);
        }
        long endTime2 = System.currentTimeMillis();
        System.out.println("消耗时间" + (endTime2 - startTime2));

    }

    public static void loopList(List<Integer> lists) {
        for (int i = 0; i < lists.size(); i++) {
            Integer integer = lists.get(i);
        }
    }
}
