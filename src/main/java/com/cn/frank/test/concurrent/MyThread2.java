package com.cn.frank.test.concurrent;

/**
 * Author: frank_du
 * Time : 2018/3/22 下午7:42
 */
public class MyThread2 extends Thread {
    private Object lock;

    public MyThread2(Object lock) {
        this.lock = lock;
    }

    @Override
    public void run() {
        try {
            synchronized (lock) {
                System.out.println("开始， notify time = " + System.currentTimeMillis());
                lock.notify();
                System.out.println("结束， notify time = " + System.currentTimeMillis());
            }

            Thread.sleep(2000);
            System.out.println("退出notify syn");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
