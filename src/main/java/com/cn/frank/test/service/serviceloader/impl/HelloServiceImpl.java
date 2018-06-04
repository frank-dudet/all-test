package com.cn.frank.test.service.serviceloader.impl;

import com.cn.frank.test.service.serviceloader.IHelloService;

/**
 * Author: frank_du
 * Time : 2017/2/23 下午3:54
 */
public class HelloServiceImpl implements IHelloService {

    @Override
    public void sayHello() {
        System.out.println("Hello ServiceImpl");
    }
}
