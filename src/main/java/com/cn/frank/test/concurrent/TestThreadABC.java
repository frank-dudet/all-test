package com.cn.frank.test.concurrent;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Author: frank_du
 * Time : 2018/5/21 下午6:34
 */
public class TestThreadABC implements Runnable {

    private static Queue<Thread> taskQueue = new LinkedBlockingQueue<>();


    private static AtomicInteger atomicInteger = new AtomicInteger(0);

    @Override
    public void run() {
        for(;atomicInteger.get() < 1000;) {
            int k = atomicInteger.getAndIncrement();
            System.out.println(Thread.currentThread().getName() + " ---> " + k);
        }
        try {
            Thread.currentThread().sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws Exception {
        Thread threadA = new Thread(new TestThreadABC());
        threadA.setName("A");

        Thread threadB = new Thread(new TestThreadABC());
        threadB.setName("B");

        Thread threadC = new Thread(new TestThreadABC());
        threadC.setName("C");

        taskQueue.add(threadA);
        taskQueue.add(threadB);
        taskQueue.add(threadC);

        for(int i=0; i<2; i++) {
            Thread thread = taskQueue.poll();
            thread.start();
            Thread.sleep(1000);
        }
    }
}
