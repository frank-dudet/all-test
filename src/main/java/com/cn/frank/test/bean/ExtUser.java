package com.cn.frank.test.bean;

import java.math.BigDecimal;

/**
 * Author: frank_du
 * Time : 2018/5/8 上午11:41
 */
public class ExtUser extends User {

    private String homeAddr;

    private BigDecimal money;

    public String getHomeAddr() {
        return homeAddr;
    }

    public void setHomeAddr(String homeAddr) {
        this.homeAddr = homeAddr;
    }

    public BigDecimal getMoney() {
        return money;
    }

    public void setMoney(BigDecimal money) {
        this.money = money;
    }
}
