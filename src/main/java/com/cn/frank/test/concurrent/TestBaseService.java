package com.cn.frank.test.concurrent;

/**
 * Author: frank_du
 * Time : 2018/3/28 下午6:46
 */
public class TestBaseService {
    public static void main(String[] args) throws Exception {
        BaseService baseService = new BaseService();
        ExtService extService = new ExtService();

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run(){
                try {
                    baseService.doSomething();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        thread.start();

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    extService.doSomething();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        thread1.start();
    }
}
