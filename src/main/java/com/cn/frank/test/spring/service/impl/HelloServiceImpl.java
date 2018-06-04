package com.cn.frank.test.spring.service.impl;

import com.cn.frank.test.spring.service.HelloService;
import org.springframework.stereotype.Service;

/**
 * Author: frank_du
 * Time : 2018/5/14 上午10:33
 */
@Service("helloService")
public class HelloServiceImpl implements HelloService {

    @Override
    public String sayHello(String msg) {
        return "Hello Service";
    }
}
