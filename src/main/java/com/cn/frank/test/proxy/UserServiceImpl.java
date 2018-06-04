package com.cn.frank.test.proxy;

/**
 * Author: frank_du
 * Time : 2017/10/12 下午5:24
 */
public class UserServiceImpl implements UserService {

    public void add() {
        System.out.println("This is add service");
    }
    public void delete(int id) {
        System.out.println("This is delete service：delete " + id );
    }
}
