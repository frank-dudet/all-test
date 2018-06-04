package com.cn.frank.test.service.ThreadLocal;

/**
 * Author: frank_du
 * Time : 2017/3/15 下午7:00
 */
public class TestThreadLocal {

    private ThreadLocal<Integer> count = new ThreadLocal<Integer>() {
        @Override
        protected Integer initialValue() {
            System.out.println(Thread.currentThread().getName());
            return 0;
        }
    };


    public int getNextNum() {
        count.set(count.get() + 1);
        return count.get();
    }


    public static void main(String args[]) {

        TestThreadLocal num =  new TestThreadLocal();
        Client t1 = new Client(num);

        Client t2 = new Client(num);

        Client t3 = new Client(num);

        new Thread(t1).start();
        new Thread(t2).start();
        new Thread(t3).start();
    }
    private static class Client implements Runnable {

        private TestThreadLocal num;

        public Client(TestThreadLocal num) {
            this.num = num;
        }

        public void run() {
            for(int i=0; i<3;i++) {
                System.out.println(Thread.currentThread().getName() + "----->" + "num-" + num.getNextNum());
            }
        }
    }

}
