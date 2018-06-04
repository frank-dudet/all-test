package com.cn.frank.test.concurrent;

/**
 * Author: frank_du
 * Time : 2018/3/22 下午7:39
 */
public class MyThread1 extends Thread {


    private Object lock;

    public MyThread1(Object lock) {
        this.lock = lock;
    }

    @Override
    public void run() {
        synchronized (lock) {
            try {
                System.out.println("开始， wait time = " + System.currentTimeMillis() + "ThreadName = " + Thread.currentThread().getName());
                lock.wait(1000);
                System.out.println("结束， wait time = " + System.currentTimeMillis() + "ThreadName = " + Thread.currentThread().getName());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
