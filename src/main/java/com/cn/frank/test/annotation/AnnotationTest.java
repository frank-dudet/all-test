package com.cn.frank.test.annotation;

/**
 * Author: frank_du
 * Time : 2017/4/5 下午7:41
 */
public class AnnotationTest {

    public static void main(String args[]) {
        System.out.println(ResponseCode.displayValue(ResponseCode.class, ResponseCode.FAILURE));

        String s = "com.dudet.test.sss.ssssss";

        String t = s.replaceAll("\\.","/");
        System.out.println(t);
    }
}
