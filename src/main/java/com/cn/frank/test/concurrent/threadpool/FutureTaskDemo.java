package com.cn.frank.test.concurrent.threadpool;

import java.util.concurrent.*;

/**
 * Author: frank_du
 * Time : 2018/2/7 下午3:49
 */
public class FutureTaskDemo<T> implements Callable<T> {

    public static void main(String[] args) {
        ExecutorService service = Executors.newSingleThreadExecutor();
        Future<String> task = service.submit(new FutureTaskDemo<String>());

        try {
            System.out.println(task.get(4, TimeUnit.SECONDS));
        } catch (InterruptedException e) {
            System.out.println("InterruptedException!");
            e.printStackTrace();
        } catch (ExecutionException e) {
            System.out.println("ExecutionException!");
            e.printStackTrace();
        } catch (TimeoutException e) {
            System.out.println("TimeoutException!");
            e.printStackTrace();
        } finally {
            task.cancel(true);
            service.shutdown();
        }


    }

    @Override
    public T call() throws Exception {
        System.out.println("invoke call method!");
        Thread.currentThread().sleep(3000);
        return (T) "Hello Call!";
    }
}
