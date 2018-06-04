package com.cn.frank.test.util;

import org.apache.log4j.Logger;

import java.io.*;
import java.util.Properties;

/**
 * Author: frank_du
 * Time : 2017/5/25 下午4:30
 */
public class ConfigLoaderUtils {

    private static Logger LOGGER = Logger.getLogger(ConfigLoaderUtils.class);

    private static final String KEY ="quick_default_table";


    /**
     * 读取配置信息
     */
    private static void readConfig(String filePath) {
        LOGGER.info("-----开始读取收银本地配置信息， file = " + filePath);
        File file = new File(filePath);
        if (!file.exists()) {
            LOGGER.error("文件不存在, file = " + file);
            return;
        }
        try {
            Properties properties = new Properties();
            try (BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath))) {
                properties.load(bufferedReader);
            }
            if (properties.isEmpty()) {
                LOGGER.error("配置文件中不包含任何配置信息");
                return;
            }
            System.getProperties().putAll(properties);
        } catch (Exception e) {
            LOGGER.error("loadProperties error", e);
            return;
        }
    }

    public static void main(String[] args) {
        String path = "/Users/frank_du/Downloads/issrestv5.ini";
        readConfig(path);
        Properties properties = System.getProperties();
        System.out.println(properties.getProperty("quick_default_table"));
        System.out.println("end");
    }

}
