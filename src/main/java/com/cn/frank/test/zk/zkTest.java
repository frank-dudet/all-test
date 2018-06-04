package com.cn.frank.test.zk;

import com.alibaba.fastjson.JSON;
import org.apache.commons.collections.CollectionUtils;
import org.apache.zookeeper.*;
import org.apache.zookeeper.data.Stat;

import java.util.List;

/**
 * Author: frank_du
 * Time : 2017/11/24 下午4:16
 */
public class zkTest {

    private static final int CLIENT_PORT = 2881;

    public static void main(String[] args) throws Exception {
        // 创建一个与服务器的连接
        ZooKeeper zk = new ZooKeeper("172.22.38.204:2181", 2000, new Watcher() {
            @Override
            public void process(WatchedEvent watchedEvent) {
                if(watchedEvent.getState() == Event.KeeperState.SyncConnected) {
                    System.out.println("已经触发了" + watchedEvent.getType() + "事件！");
                }
            }
        });
        testDubboZk(zk);
//        testOperZk(zk);

        //  关闭连接
        zk.close();
    }


    /**
     * dubbo demo测试消费者/生产者是否是临时节点
     *
     * @param zk
     * @throws Exception
     */
    public static void testDubboZk(ZooKeeper zk) throws Exception {
        String path = "/dubbo/com.alibaba.dubbo.demo.DemoService/providers";
        String result = new String((zk.getData(path,true, null)));


        List<String> tmp = zk.getChildren(path, true, null);

        if (CollectionUtils.isNotEmpty(tmp)) {
            String s = tmp.get(1);
            path = path + "/" + s;

            Stat stat = zk.exists(path, true);

            System.out.println(JSON.toJSONString(stat));

            System.out.println(path);

            System.out.println(new String(zk.getData(path,true,null)));
        }

        System.out.println(result);
    }

    /**
     * 测试zk api基本操作
     *
     * @param zk
     * @throws Exception
     */
    public static void testOperZk(ZooKeeper zk) throws Exception {
        // 创建一个目录节点
        if(zk.exists("/testRootPath", false) == null) {
            zk.create("/testRootPath","testRootData".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
        }
        // 创建一个子目录节点
        zk.create("/testRootPath/testChildPathOne","testChildDataOne".getBytes(),
                ZooDefs.Ids.OPEN_ACL_UNSAFE,CreateMode.PERSISTENT);
        System.out.println(new String(zk.getData("/testRootPath",false,null)));
        // 取出子目录节点列表
        System.out.println(zk.getChildren("/testRootPath",true));
        // 修改子目录节点数据
        zk.setData("/testRootPath/testChildPathOne","modifyChildDataOne".getBytes(),-1);
        System.out.println("目录节点状态：["+zk.exists("/testRootPath",true)+"]");
        // 创建另外一个子目录节点
        zk.create("/testRootPath/testChildPathTwo","testChildDataTwo".getBytes(),
                ZooDefs.Ids.OPEN_ACL_UNSAFE,CreateMode.PERSISTENT);
        System.out.println(new String(zk.getData("/testRootPath/testChildPathTwo",true,null)));
        // 删除子目录节点
        zk.delete("/testRootPath/testChildPathTwo",-1);
        zk.delete("/testRootPath/testChildPathOne",-1);
        // 删除父目录节点
        zk.delete("/testRootPath",-1);
    }
}
