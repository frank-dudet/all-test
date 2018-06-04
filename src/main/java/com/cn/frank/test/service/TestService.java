package com.cn.frank.test.service;

import java.io.Serializable;

/**
 * Author: frank_du
 * Time : 2017/4/13 下午3:25
 */
public class TestService implements Serializable{

    private static final long serialVersionUID = -7059152561682510765L;
    private static int sdsds = 1;

    private TestService() {
    }

    private static final class InstanceHoder {
        private static final TestService instance = new TestService();
    }

    public static TestService getInstance() {
        return InstanceHoder.instance;
    }


    private Object readResolve() {
        return InstanceHoder.instance;
    }


    public int getData() {
        sdsds = sdsds + 1;
        return sdsds;
    }
}
