package com.cn.frank.test.proxy;

/**
 * Author: frank_du
 * Time : 2018/4/10 上午11:18
 */
public class ProxyTest {

    public static void main(String[] args) {
        UserServiceImpl userService = new UserServiceImpl();

        UserServiceJdkProxy jdkUserService = new UserServiceJdkProxy();
        UserService jdkProxy = (UserService)jdkUserService.bind(userService);
        jdkProxy.add();

        UserServiceImpl userService2 = new UserServiceImpl();
        UserServiceCgligProxy cglibUserService = new UserServiceCgligProxy();
        UserServiceImpl cglibService = (UserServiceImpl)cglibUserService.getInstance(userService2);
        cglibService.add();
    }
}
