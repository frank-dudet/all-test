package com.cn.frank.test.spring.controller;

import com.cn.frank.test.spring.service.HelloService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * Author: frank_du
 * Time : 2018/5/14 上午10:08
 */
@Controller
@RequestMapping("/")
public class WelcomeController {

    private static final Logger logger = LoggerFactory.getLogger(WelcomeController.class);

    @Autowired
    private HelloService helloService;

    @RequestMapping("hello")
    public String hello(HttpServletRequest request) {
        logger.info("收到hello请求");
        return "jsp/hello";
    }
}
