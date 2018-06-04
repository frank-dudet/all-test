package com.cn.frank.test.redis;

import org.junit.Test;
import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisCluster;
import redis.clients.jedis.JedisPool;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

/**
 * Author: frank_du
 * Time : 2018/5/3 下午3:12
 */
public class JedisTest {

    private final String ipAddr = "172.22.38.54";

    private final int port = 7001;

    @Test
    public void testJedis() {
        Jedis jedis = new Jedis(ipAddr, 7001);
        String result = jedis.get("jedisCluster");
        System.out.println(result);
        jedis.close();
    }

    @Test
    public void testJedisPool() {
        JedisPool jedisPool = new JedisPool(ipAddr, port);
        Jedis jedis = jedisPool.getResource();
        jedis.set("jedis", "pool");
        String result = jedis.get("jedis");
        System.out.println(result);

        jedis.close();
        jedisPool.close();
    }

    @Test
    public void testJedisCluster() throws IOException {
        Set<HostAndPort> nodes = new HashSet<HostAndPort>();
        nodes.add(new HostAndPort(ipAddr, 7001));
        nodes.add(new HostAndPort(ipAddr, 7002));
        nodes.add(new HostAndPort(ipAddr, 7003));
        nodes.add(new HostAndPort(ipAddr, 7004));
        nodes.add(new HostAndPort(ipAddr, 7005));
        nodes.add(new HostAndPort(ipAddr, 7006));
        JedisCluster jedisCluster = new JedisCluster(nodes);

        jedisCluster.zadd("hello", 1, "java");
        jedisCluster.zadd("hello", 2, "php");
        jedisCluster.zadd("hello", 3, "c++");

        Set<String> result = jedisCluster.zrangeByScore("hello",2, 4);
        System.out.println(result);

        jedisCluster.close();
    }

    @Test
    public void test() {
        System.out.println(System.currentTimeMillis());
    }

}
