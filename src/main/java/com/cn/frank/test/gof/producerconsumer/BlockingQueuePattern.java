package com.cn.frank.test.gof.producerconsumer;

import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Author: frank_du
 * Time : 2018/6/5 上午11:50
 */
public class BlockingQueuePattern {


    public static void main(String[] args) {

        BlockingQueue blockingQueue = new LinkedBlockingQueue<>();
        //创建生产者线程和消费者线程
        for(int i=0; i<2; i++) {
            Thread prodThread = new Thread(new Producer(blockingQueue));
            Thread consThread = new Thread(new Consumer(blockingQueue));
            //启动生产者线程和消费者线程
            prodThread.start();
            consThread.start();
        }
    }

    static class Producer implements Runnable {

        private final BlockingQueue queue;

        public Producer(BlockingQueue<String> queue) {
            this.queue = queue;
        }

        @Override
        public void run() {

            try {
                Random random = new Random(10);
                for(int i=0; i<10; i++) {
                    int randomInt = random.nextInt(100);
                    System.out.println("线程 " + Thread.currentThread().getName() + "生产了 " + randomInt);
                    queue.put(randomInt);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


    static class Consumer implements Runnable {

        private final BlockingQueue queue;

        public Consumer(BlockingQueue queue) {
            this.queue = queue;
        }

        @Override
        public void run() {
            while (true) {
                try {
                    System.out.println("线程 " + Thread.currentThread().getName() + "消费了 " + queue.take());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
