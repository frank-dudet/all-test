package com.cn.frank.test.serviceloader;

import java.util.ServiceLoader;

/**
 * Author: frank_du
 * Time : 2017/9/12 下午5:07
 */
public class Test {

    public static void main(String[] args) {
        ServiceLoader<ITestService> services = ServiceLoader.load(ITestService.class);
        System.out.println(services.iterator().next());
    }
}
