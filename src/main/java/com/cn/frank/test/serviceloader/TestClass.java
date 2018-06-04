package com.cn.frank.test.serviceloader;

import java.util.ServiceLoader;
import java.util.concurrent.*;

/**
 * Author: frank_du
 * Time : 2017/9/12 下午4:31
 */
public class TestClass {

    public static void main(String[] args) throws Exception {

        ExecutorService executorService = Executors.newFixedThreadPool(2);
        Future<ITestService> future1 = executorService.submit(new myCallable());
        Future<ITestService> future2 = executorService.submit(new myCallable());
        ITestService service1 = future1.get();
        ITestService service2 = future2.get();

        System.out.println(service1.equals(service2));

        executorService.shutdown();

    }

    static class myCallable implements Callable<ITestService> {

        @Override
        public ITestService call() throws Exception {
            ServiceLoader<ITestService> services = ServiceLoader.load(ITestService.class);
            return services.iterator().next();
        }
    }
}
