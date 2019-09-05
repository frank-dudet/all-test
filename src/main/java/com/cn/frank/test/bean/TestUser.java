/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2019 All Rights Reserved.
 */
package com.cn.frank.test.bean;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.function.IntBinaryOperator;
import java.util.stream.Collectors;

/**
 * @author detao.ddt
 * @version $Id: TestUser, v0.1 2019年08月01日 17:25 detao.ddt Exp $
 */
public class TestUser {

    public static void main(String[] args) {

        testToString();
    }

    private static void testToString() {
        List<User> users = new ArrayList<>();
        User user = new User();
        user.setId(1);
        user.setPassword("111");
        user.setUsername("fangkun");
        user.setSchool("lanxiang");

        User user2 = new User();
        user2.setId(2);
        user2.setPassword("222");
        user2.setUsername("fangkun2");
        user2.setSchool("lanxiang2");
        users.add(user);
        users.add(user2);

        System.out.println(users);

        users.stream().peek(userTmp -> userTmp.setUsername("kkkkk")).collect(Collectors.toList());
        users.stream().forEach(userTmp -> userTmp.setUsername("jjjjj"));

        System.out.println(users);


        List<String> list = new ArrayList<>();
        list.add("111");
        list.add("2222");
        list.add("333");

        System.out.println(list);


    }

    public static void changeJobSetPriority(IntBinaryOperator priorityFunc) {
            int result = priorityFunc.applyAsInt(111, 1);

        System.out.println(result);
    }
}
