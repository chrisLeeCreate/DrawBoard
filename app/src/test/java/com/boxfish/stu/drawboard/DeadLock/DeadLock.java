package com.boxfish.stu.drawboard.DeadLock;

/**
 * Created by lishaowei on 2017/7/20.
 */

public class DeadLock implements Runnable {

    public boolean flag;
    public Object o1 = new Object();
    public Object o2 = new Object();

    private DeadLock(boolean flag) {
        this.flag = flag;//在构造方法里输入一个状态
    }

    @Override
    public void run() {
        if (this.flag) {
            synchronized (o1) {
                try {
                    Thread.sleep(1000);//在第一个线程锁住o1对象时睡眠1秒，那么这一秒内是线程占着o1
                } catch (Exception e) {
                    e.printStackTrace();
                }
                synchronized (o2) {
                    System.out.println("01 is ok");
                }
            }
        } else {
            synchronized (o2) {
                try {
                    Thread.sleep(100);//线程o2锁住o2，那么前0.1秒内是o2占着o2，在0.1秒后，线程2请求o1而此时o1被线程1占着
                    //所以o2等待o1的结果。1秒后，线程请求o2，而o2被线程2占着，那么线程1又要等待线程2的结果，于是他们互相等待就产生
                    //死锁了
                } catch (Exception e) {
                    e.printStackTrace();
                }
                synchronized (o1) {
                    System.out.println("02 is ok");
                }
            }
        }
    }

}
