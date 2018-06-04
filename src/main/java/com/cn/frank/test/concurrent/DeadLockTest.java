package com.cn.frank.test.concurrent;

/**
 * Author: frank_du
 * Time : 2018/3/22 上午11:21
 */
public class DeadLockTest {
    public static void main(String[] args) {
        try {
            DeadThread t1 = new DeadThread();
            t1.setUsername("a");
            Thread thread1 = new Thread(t1);
            thread1.start();
            Thread.sleep(1000);

            t1.setUsername("b");
            Thread thread2 = new Thread(t1);
            thread2.start();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
