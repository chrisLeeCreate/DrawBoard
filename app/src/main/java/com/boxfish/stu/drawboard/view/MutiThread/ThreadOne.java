package com.boxfish.stu.drawboard.view.MutiThread;

/**
 * Created by lishaowei on 2017/7/31.
 */

public class ThreadOne {
    public static void main(String[] args) {
//        MyThread thread = new MyThread("A");
//        MyThread thread2 = new MyThread("B");
        System.out.println("主线程开启");
        MyThread2 a = new MyThread2("A");
        MyThread2 b = new MyThread2("B");
        Thread thread = new Thread(a);
        Thread thread2 = new Thread(b);
//        a.run();
//        B.run();
        thread.start();
        thread2.start();
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("主线程关闭");

    }

    public static class MyThread extends Thread {
        private String name;

        public MyThread(String name) {
            this.name = name;
        }

        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                System.out.println(name + " run " + i);
            }
            try {
                sleep((int) Math.random() * 10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static class MyThread2 implements Runnable{
        private String name;

        public MyThread2(String name) {
            this.name = name;
        }
        @Override
        public void run() {
            System.out.println(name+" 子线程开启");
            for (int i = 0; i < 10; i++) {
                System.out.println(name + " run " + i);
            }
            try {
                Thread.sleep((int) Math.random() * 10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(name+" 子线程关闭");
        }
    }
}
