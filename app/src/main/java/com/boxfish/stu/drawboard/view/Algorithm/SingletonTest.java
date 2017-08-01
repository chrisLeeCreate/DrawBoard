package com.boxfish.stu.drawboard.view.Algorithm;

/**
 * Created by lishaowei on 2017/8/1.
 */

public class SingletonTest {
    /**
     * 单例模式 饿汉式 线程安全
     * <p>
     * 饿汉式在类创建的同时就已经创建好一个静态的对象供系统使用，以后不再改变，所以天生是线程安全的。
     */

    public static class Singleton {
        private final static Singleton instance = new Singleton();

        private Singleton() {

        }

        public static Singleton getInstance() {
            return instance;
        }
    }

    /**
     * 单例模式 懒汉 线程不安全
     * 并发环境下很可能出现多个Singleton实例
     */
    public static class Singleton2 {
        private static Singleton2 instance = null;

        private Singleton2() {
        }

        public static Singleton2 getInstance() {
            if (instance == null) {
                instance = new Singleton2();
            }
            return instance;
        }

    }


    /**
     * 单例模式 懒汉 线程安全
     */

    public static class Singleton3 {
        private static volatile Singleton3 instance = null;
        private String name;

        private Singleton3() {
        }

        public static Singleton3 getInstance() {
            if (instance == null) {
                synchronized (Singleton3.class) {
                    if (instance == null) {
                        instance = new Singleton3();
                    }
                }
            }
            return instance;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void print() {
            System.out.println("the name is " + name);
        }
    }

    public static void main(String[] args) {
        Singleton3 instance = Singleton3.getInstance();
        instance.setName("li");
        Singleton3 instance1 = Singleton3.getInstance();
        instance1.setName("shao");

        instance.print();
        instance1.print();


        if (instance == instance1) {
            System.out.println("same one");
        } else {
            System.out.println("not same one");
        }


    }


}
