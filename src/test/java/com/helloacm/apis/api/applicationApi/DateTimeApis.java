package com.helloacm.apis.api.applicationApi;

import com.helloacm.apis.api.RestResource;
import com.helloacm.apis.utils.ConfigLoader;
import io.qameta.allure.Step;
import io.restassured.response.Response;


public class DateTimeApis {

    public static Response get_withoutCached(String endpoint ,String qp_str){
        return RestResource.get_WithoutCached(endpoint, qp_str);
    }

    public static Response get(String endpoint ,String qp_str){
        return RestResource.get(endpoint, qp_str);
    }
    public static Response post(String endpoint ,String body){
        return RestResource.post(endpoint, body);
    }

}
