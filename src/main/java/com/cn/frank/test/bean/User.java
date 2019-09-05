package com.cn.frank.test.bean;

import com.cn.frank.test.common.ToString;

import java.io.Serializable;

/**
 * Author: frank_du
 * Time : 2017/4/19 下午9:29
 */
public class User  extends ToString implements Cloneable, Serializable {

    private static final long serialVersionUID = -2461845748472195645L;

    public User() {
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    private int id;

    private String username;

    private String password;

    private String school;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }
}
