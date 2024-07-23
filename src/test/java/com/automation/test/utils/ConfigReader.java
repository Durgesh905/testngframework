package com.automation.test.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    static Properties prop;
    public static void initConfig() throws IOException {
        prop=new Properties();
        prop.load(new FileInputStream("src/test/resources/config/config.properties"));

    }
    public static String getConfigValue(String key){
        return  prop.getProperty(key);
    }
}
