package com.helloacm.apis.utils;

import java.util.Properties;

public class ConfigLoader {
    private final Properties properties;
    private static ConfigLoader configLoader;

    private ConfigLoader(){
        properties = PropertyUtils.propertyLoader("src/test/resources/config.properties");
    }

    public static ConfigLoader getInstance(){
        if(configLoader == null){
            configLoader = new ConfigLoader();
        }
        return configLoader;
    }

    public  String getBaseUri(){
        String prop = properties.getProperty("BASE_URI");
        if(prop != null) return prop;
        else throw new RuntimeException("property BASE_URI is not specified in the config.properties file");
    }





}
