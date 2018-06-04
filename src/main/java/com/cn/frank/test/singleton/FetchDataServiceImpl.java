package com.cn.frank.test.singleton;

/**
 * Author: frank_du
 * Time : 2017/9/12 下午3:54
 */
public class FetchDataServiceImpl {

    public boolean fetchData() {
        return FetchDataBaseService.getInstance().fetchData();
//        return new FetchDataBaseService().fetchData();
    }
}
