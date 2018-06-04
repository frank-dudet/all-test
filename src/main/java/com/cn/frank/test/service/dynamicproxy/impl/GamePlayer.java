package com.cn.frank.test.service.dynamicproxy.impl;

import com.cn.frank.test.service.dynamicproxy.IGamePlayer;

/**
 * Author: frank_du
 * Time : 2017/3/15 下午5:39
 */
public class GamePlayer implements IGamePlayer {
    public void login(String userName, String password) {
        System.out.println("用户" + userName + "登陆了游戏！");
    }

    public void killBoss() {
        System.out.println("玩家击杀了Boss");
    }

    public void upGrade() {
        System.out.println("玩家升级了！");
    }
}
