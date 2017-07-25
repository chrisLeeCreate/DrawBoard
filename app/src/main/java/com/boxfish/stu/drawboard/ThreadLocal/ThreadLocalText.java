package com.boxfish.stu.drawboard.ThreadLocal;

/**
 * Created by lishaowei on 2017/7/22.
 */

public class ThreadLocalText {
    ThreadLocal<Long> longLocal = new ThreadLocal();
    ThreadLocal<String> stringLocal = new ThreadLocal();


    public void setLongLocal() {
        longLocal.set(Thread.currentThread().getId());
        stringLocal.set(Thread.currentThread().getName());
    }

    public Long getLongLocal() {
        return longLocal.get();
    }
    public String getStringLocal() {
        return stringLocal.get();
    }

    public static void main(String[] args) throws InterruptedException {
        final ThreadLocalText test = new ThreadLocalText();


        test.setLongLocal();
        System.out.println(test.getLongLocal());
        System.out.println(test.getStringLocal());


        Thread thread1 = new Thread(){
            public void run() {
                test.setLongLocal();
                System.out.println(test.getLongLocal());
                System.out.println(test.getStringLocal());
            };
        };
        thread1.start();
        thread1.join();
        System.out.println(test.getLongLocal());
        System.out.println(test.getStringLocal());
    }
}
