package com.cn.frank.test.oauth2.domain;

import com.cn.frank.test.oauth2.utils.GuidGenerator;
import com.cn.frank.test.oauth2.utils.PasswordHandler;

/**
 * Author: frank_du
 * Time : 2018/5/24 下午3:09
 */
public class UserFormDto extends UserDto {
    private static final long serialVersionUID = 7959857016962260738L;


    private String password;

    public UserFormDto() {
    }


    public Privilege[] getAllPrivileges() {
        return new Privilege[]{Privilege.MOBILE, Privilege.UNITY};
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public User newUser() {
        final User user = new User();
        user.setGuid(GuidGenerator.generate());
        user.setUsername(getUsername());
        user.setPhone(getPhone());
        user.setEmail(getEmail());
        user.setPrivileges(getPrivileges());
        user.setPassword(PasswordHandler.md5(getPassword()));
        return user;
    }

}
