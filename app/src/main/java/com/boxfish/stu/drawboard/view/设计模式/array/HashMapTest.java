package com.boxfish.stu.drawboard.view.设计模式.array;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Random;
import java.util.TreeMap;

/**
 * Created by lishaowei on 2017/7/27.
 */

public class HashMapTest {
    public static void main(String[] args) {
        threeMapDemo();
        testHashMap();

    }

    static class Ctime {
        public  int count = 0;

        @Override
        public String toString() {
            return Integer.toString(count);
        }
    }

    private static void testHashMap() {
        HashMap hashMap = new HashMap();
        Random random = new Random();
        for (int i = 0; i < 1000; i++) {
            Integer integer = new Integer(random.nextInt(20));
            if (hashMap.containsKey(integer)) {
                ((Ctime)hashMap.get(integer)).count++;
            } else {
                hashMap.put(integer, new Ctime());
            }
        }
        System.out.println(hashMap.toString());
    }

    private static void threeMapDemo() {
        System.out.println("hashMap使用-------------");

        HashMap<String, String> hashMap = new HashMap();
        hashMap.put("a", "aaa");
        hashMap.put("B", "bbb");
//        hashMap.put(1, 3);
        System.out.println("  value:" + hashMap.get("a"));

        Iterator iterator = hashMap.keySet().iterator();
        while (iterator.hasNext()) {
            Object next = iterator.next();
            System.out.println("key:" + next + "  value:" + hashMap.get(next));
        }


        System.out.println("hashTable使用-------------");
        Hashtable hashtable = new Hashtable<>();
        hashtable.put("a", "aaa");
        hashtable.put("n", "nnn");
        hashtable.put("d", "ddd");

        Iterator iterator1 = hashtable.keySet().iterator();
        while (iterator1.hasNext()) {
            Object next = iterator1.next();
            System.out.println("key:" + next + "  value:" + hashtable.get(next));
        }
        System.out.println("treeMap使用-------------");

        TreeMap<Object, Object> treeMap = new TreeMap<>();
        treeMap.put("a", "aaa");
        treeMap.put("B", "bbb");
        treeMap.put("d", "ddd");
        treeMap.put("c", "ccc");
        treeMap.put("f", "fff");
        treeMap.put("e", "eee");
//        treeMap.put(1, 111);

        Iterator<Object> iterator2 = treeMap.keySet().iterator();
        while (iterator2.hasNext()) {
            Object next = iterator2.next();
            System.out.println("key:" + next + "  value:" + treeMap.get(next));

        }
    }
}
