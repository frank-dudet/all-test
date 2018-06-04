package com.cn.frank.test.concurrent;

import org.apache.commons.lang3.StringUtils;

import java.util.Random;

/**
 * Author: frank_du
 * Time : 2018/4/2 上午11:08
 */
public class TestThreadLocal {

    private static  int i = 0;

    private static ThreadLocal<String> threadLocal = new ThreadLocal<String>() {
        @Override
        protected String initialValue() {
            return "";
        }
    };


    public static String getString() {
        String temp = threadLocal.get();
        if(StringUtils.isBlank(temp)) {
            temp = ++i + "";
            threadLocal.set(temp);
        }

        return temp;
    }

    public static void main(String[] args) {

        for(int i=0; i<10; i++) {
            System.out.println(Thread.currentThread().getName() + " " + getString());
//            threadLocal.remove();
        }

    }
}
