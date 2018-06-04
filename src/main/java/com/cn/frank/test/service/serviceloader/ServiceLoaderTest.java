package com.cn.frank.test.service.serviceloader;

import java.util.Iterator;
import java.util.ServiceLoader;

/**
 * Author: frank_du
 * Time : 2017/2/23 下午3:17
 */
public class ServiceLoaderTest {

    public static void main(String args[]) {

        ServiceLoader<IHelloService> services = ServiceLoader.load(IHelloService.class);

        Iterator<IHelloService> dictionaries = services.iterator();

        while (dictionaries.hasNext()) {
            IHelloService service = dictionaries.next();
            service.sayHello();
        }
    }
}
