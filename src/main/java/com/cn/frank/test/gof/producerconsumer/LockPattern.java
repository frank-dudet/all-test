package com.cn.frank.test.gof.producerconsumer;

import java.util.LinkedList;
import java.util.Random;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Author: frank_du
 * Time : 2018/6/5 下午12:09
 */
public class LockPattern {

    public static void main(String[] args) {

        MyQueue myQueue = new MyQueue();
        for(int i=0; i<3; i++) {
            Thread prodThread = new Thread(new Producer(myQueue));

            //启动生产者线程和消费者线程
            prodThread.start();
        }

        for(int i=0; i<1; i++) {
            Thread consThread = new Thread(new Consumer(myQueue));
            consThread.start();
        }
    }
}

class MyQueue {

    private final int size = 10;

    LinkedList<Object> prods = new LinkedList<Object>();

    final Lock lock = new ReentrantLock();

    final Condition notFull = lock.newCondition();

    final Condition notEmpty = lock.newCondition();

    public void put(Object object) {

        try {
            lock.lock();
            while (size == prods.size()) {

                System.out.println("---生产队列已满，请稍等！");
                notFull.await();
            }

            prods.add(object);
            notEmpty.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public Object get() {
        Object object = null;
        try {
            lock.lock();

            while (prods.size() == 0) {
                System.out.println("***消费队列为空，请等待！");
                notEmpty.await();
            }
            object = prods.removeFirst();
            Thread.sleep(1000);
            notFull.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
         return object;
    }

}

class Producer implements Runnable {

    private final MyQueue queue;

    public Producer(MyQueue queue) {
        this.queue = queue;
    }

    @Override
    public void run() {

        try {
            Random random = new Random(10);
            for(int i=0; i<5; i++) {
                int randomInt = random.nextInt(100);
                System.out.println("线程 " + Thread.currentThread().getName() + "---生产了 " + randomInt);
                queue.put(randomInt);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


class Consumer implements Runnable {

    private final MyQueue queue;

    public Consumer(MyQueue queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        while (true) {
            try {
                System.out.println("线程 " + Thread.currentThread().getName() + "***消费了 " + queue.get());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}

