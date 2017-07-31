package com.boxfish.stu.drawboard.view.MutiThread;

/**
 * Created by lishaowei on 2017/7/31.
 */

public class ThreadTWO {
    public static void main(String[] args) {
        System.out.println("主线程开启");

        MyThread thread = new MyThread("张三");
        MyThread thread2 = new MyThread("李四");
        thread.start();
        thread2.start();
        System.out.println("主线程关闭");

    }

    private static class MyThread extends Thread {
        private String name;

        public MyThread(String name) {
            this.name = name;
        }

        @Override
        public void run() {
            System.out.println(name + " 子线程开启");
            for (int i = 0; i < 100; i++) {
                System.out.println(name + " run " + i);
                if (i == 20) {
                    yield();
                }
            }
            try {
                Thread.sleep((int) Math.random() * 10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(name + " 子线程关闭");
        }
    }
}
