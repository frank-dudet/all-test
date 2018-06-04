package com.cn.frank.test.classload;

/**
 * Author: frank_du
 * Time : 2017/9/3 下午3:10
 */
public class SuperClass {

    static {
        System.out.println("superClass init!");
    }

//    public static String value = "test";
    public static final String value = "test";
}
