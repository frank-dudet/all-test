package com.cn.frank.test.concurrent;

import java.util.concurrent.CountDownLatch;

/**
 * Author: frank_du
 * Time : 2018/4/4 上午11:34
 */
public class TestCountDownLatch {

    public long timeTasks(int nThreads, final Runnable task) throws InterruptedException {
        final CountDownLatch startGate = new CountDownLatch(1);
        final CountDownLatch endGate = new CountDownLatch(nThreads);

        for(int i=0; i<nThreads; i++) {
            Thread t = new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        startGate.await();
                        System.out.println(Thread.currentThread().getName() + "---after startGate await");
                        try {
                            task.run();
                        } finally {
                            endGate.countDown();
                        }
                    } catch (InterruptedException e) {

                    }

                }
            });
            System.out.println(Thread.currentThread().getName() + "---before t start");
            t.start();
        }

        long start = System.currentTimeMillis();
        startGate.countDown();
        endGate.await();
        System.out.println(Thread.currentThread().getName() + "---after endGate await");
        long end = System.currentTimeMillis();

        return end - start;
    }

    public static void main(String[] args) throws InterruptedException {
        int nThreads = 5;
        Runnable task = new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + "---run");
            }
        };

        System.out.println(new TestCountDownLatch().timeTasks(nThreads, task));
    }
}
