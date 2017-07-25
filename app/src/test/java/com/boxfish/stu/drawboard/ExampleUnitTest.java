package com.boxfish.stu.drawboard;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() throws Exception {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void test() {
        TestThread testThread = new TestThread();
        testThread.run();
    }

    public class TestThread implements Runnable {

        @Override
        public void run() {
            System.out.print("a");
        }
    }

    @Test
    public void test2() {
        int array[] = {1, 4, 3, 2, 4, 65, 7, 8};
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                int temp;
                if (array[j] < array[j + 1]) {
                    temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }

        for (int i = 0; i < array.length; i++) {
            System.out.println("num:" + array[i]);
        }
    }


    @Test
    public void test3() {
        String lsw = "lishaowei";
        char[] chars = lsw.toCharArray();
        for (int i = chars.length - 1; i >= 0; i--) {
            System.out.print(chars[i]);
        }
    }

    @Test
    public void test4() {
        System.out.println("请输入一个数字");

        int sum = 0;
        for (int i = 1; i <= 20; i++) {
            String s = String.valueOf(i);
            char[] chars = s.toCharArray();
            for (int j = 0; j < chars.length; j++) {
                char aChar = chars[j];
                String s1 = String.valueOf(aChar);
                int i1 = Integer.parseInt(s1);
                if (i1 == 1) {
                    sum++;
                }
            }
        }

        System.out.println("含有1的个数为：" + sum);
    }

    @Test
    public void test5() {

        for (int i = 0; i < 1000000; i++) {
            if (isMopNumber(i)) {
                System.out.println(i);
            }
        }
    }

    private boolean isMopNumber(int i) {
        if (i < 10) {
            return i == 2;
        } else {
            return (i % 10 == 3) && isMopNumber(i / 10);
        }
    }

    //{1,3}{3,6}{3,4}{6,8}区间去重，最少去掉几个集 合，可以让这个集合没有交集。
    @Test
    public void test6() {

    }

    @Test
    public void test7() {
        int a = 0;
        for (int i = 0; i < 10; i++) {
            a++;
            final int finalA = a;
            new Thread() {
                public void run() {
                    synchronized (this) {

                        try {
                            Thread.sleep(1);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.println("plus:" + Thread.currentThread().getName() + ": " + finalA);
                    }

                }
            }.start();
        }
    }
}