package com.cn.frank.test.classload;

/**
 * Author: frank_du
 * Time : 2017/9/3 下午3:11
 */
public class SubClass extends SuperClass {
    static {
        System.out.println("subClass init!");
    }

//    public static String subValue = "sdsd";
    public static final String subValue = "sdsd";
}
