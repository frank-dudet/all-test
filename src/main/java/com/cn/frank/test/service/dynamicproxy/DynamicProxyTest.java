package com.cn.frank.test.service.dynamicproxy;

import com.cn.frank.test.service.dynamicproxy.impl.GamePlayer;

import java.lang.reflect.Proxy;

/**
 * Author: frank_du
 * Time : 2017/3/15 下午5:46
 */
public class DynamicProxyTest {

    public static void main(String args[]) {
        IGamePlayer gamePlayer = new GamePlayer();

        GamePlayerInvocationHandler handler = new GamePlayerInvocationHandler(gamePlayer);
        IGamePlayer player = (IGamePlayer) Proxy.newProxyInstance(handler.getClass().getClassLoader(),
                gamePlayer.getClass().getInterfaces(),handler);
        System.out.println(player.getClass().getName());
        if("login".equals("login")) {
            player.login("张三","123");
        }
        player.killBoss();
        player.upGrade();
    }
}
