package com.helloacm.apis.utils;

import java.util.Properties;

public class DataLoader {
    private final Properties properties;
    private static DataLoader dataLoader;

    private DataLoader(){
        properties = PropertyUtils.propertyLoader("src/test/resources/data.properties");
    }

    public static DataLoader getInstance(){
        if(dataLoader == null){
            dataLoader = new DataLoader();
        }
        return dataLoader;
    }

    public String getTestData(int testcaseId){
        String prop = properties.getProperty("expResultTestCase"+testcaseId);
        if(prop != null) return prop;
        else throw new RuntimeException("property expResultTestCase"+testcaseId+" is not specified in the data.properties file");
    }


}
