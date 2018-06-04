package com.cn.frank.test.singleton;

/**
 * Author: frank_du
 * Time : 2017/9/12 下午3:50
 */
public class FetchDataBaseService {


    static {
        System.out.println("static method invoked!");
    }
    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    private String version;

    public FetchDataBaseService() {
        init();
    }

    private static final class InstanceHolder {
        private static final FetchDataBaseService instance = new FetchDataBaseService();
    }

    public static final FetchDataBaseService getInstance() {
        return InstanceHolder.instance;
    }

    private void init() {
        version = "V5";
        System.out.println("init() method invoked, version = " + version);
    }

    public boolean fetchData() {
        return false;
    }
}
