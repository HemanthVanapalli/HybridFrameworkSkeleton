package com.utilities;

import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {

    public static Properties readConfig(String path) {
        Properties properties;
        try (FileInputStream fileInputStream = new FileInputStream(System.getProperty("user.dir") + "\\" + path)) {
            properties = new Properties();
            properties.load(fileInputStream);
        } catch (Exception e) {
            throw new RuntimeException("Error while reading the config file", e);
        }
        return properties;
    }

}
