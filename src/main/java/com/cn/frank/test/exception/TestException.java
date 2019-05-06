/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2019 All Rights Reserved.
 */
package com.cn.frank.test.exception;

/**
 * @author detao.ddt
 * @version $Id: TestException, v0.1 2019年03月15日 下午12:48 detao.ddt Exp $
 */
public class TestException {

    public static void main(String[] args) {
        try {
            testThrow();
        } catch (MyException e) {
            System.out.println("catched MyException");
        } catch (Exception e) {
            System.out.println("catched Exception");
        }
    }

    public static void testThrow() throws Exception {
        try {
            testSubThrow();
        } catch (Exception e) {
            System.out.println("testThrow");
            throw e;
        }
    }


    public static void testSubThrow() throws Exception {
        System.out.println("testSubThrow");
        throw new MyException("testSubThrow");
    }
}
