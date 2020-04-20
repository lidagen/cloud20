package com.ws.springcloud.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * USER: wang_s
 * DATE：2020/4/17
 * DESC：
 **/
public class PropertiesUtil {
    private static Properties properties = new Properties();

    static {
        try {
            InputStream path = Thread.currentThread().getContextClassLoader().getResourceAsStream("min.properties");
            if (null != path) {

                properties.load(path);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getProperites(String key) {

        return properties.getProperty(key);
    }

    public static void main(String[] args) {
        String properites = PropertiesUtil.getProperites("api.code");
        System.out.println(properites);

    }
}
