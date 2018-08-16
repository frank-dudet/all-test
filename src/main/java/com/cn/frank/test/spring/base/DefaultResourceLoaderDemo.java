/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package com.cn.frank.test.spring.base;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.util.StreamUtils;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;

/**
 * @author detao.ddt
 * @version $Id: DefaultResourceLoaderDemo, v0.1 2018年08月16日 上午10:37 detao.ddt Exp $
 */
public class DefaultResourceLoaderDemo {

    public static void main(String[] args) throws IOException {
        DefaultResourceLoader resourceLoader = new DefaultResourceLoader();
        resourceLoader.addProtocolResolver((location, loader) -> {
            return new ClassPathResource(location);
        });

        Resource resource = resourceLoader.getResource("tests.properties");
        InputStream inputStream = resource.getInputStream();
        System.out.println(StreamUtils.copyToString(inputStream, Charset.forName("UTF-8")));
    }
}
