package com.cn.frank.test.oauth2.utils;

import org.springframework.security.crypto.password.NoOpPasswordEncoder;

/**
 * Author: frank_du
 * Time : 2018/5/24 下午4:13
 */
public abstract class PasswordHandler {

    private PasswordHandler() {
    }


//    public static String md5(String password) {
//        Md5PasswordEncoder encoder = new Md5PasswordEncoder();
//        return encoder.encodePassword(password, null);
//    }

    public static String md5(String password) {
        return NoOpPasswordEncoder.getInstance().encode(password);
    }

}
