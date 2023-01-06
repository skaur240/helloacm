package com.helloacm.apis.api;

import io.restassured.filter.cookie.CookieFilter;
import io.restassured.response.Response;

import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class RestResource {
    static CookieFilter filter = new CookieFilter();

    public static Response post(String path,  Object body){
        return given(SpecBuilder.getRequestSpec()).
                body(body).queryParam("cached").

        when().post(path).
        then().spec(SpecBuilder.getResponseSpec()).
                extract().
                response();
    }



    public static Response get(String path){
        return given(SpecBuilder.getRequestSpec()).
        when().get(path).
        then().spec(SpecBuilder.getResponseSpec()).
                extract().
                response();
    }
    public static Response get(String path, String s){

        return given(SpecBuilder.getRequestSpec()).queryParam("cached").queryParam("s",s).
                when().get(path).
                then().spec(SpecBuilder.getResponseSpec()).
                extract().
                response();
    }
    public static Response get_WithoutCached(String path, String s){
        return given(SpecBuilder.getRequestSpec()).queryParam("s",s.toString()).
                when().get(path).
                then().spec(SpecBuilder.getResponseSpec()).
                extract().
                response();
    }
    public static Response update(String path, String token, Object body){
        return given(SpecBuilder.getRequestSpec()).
                auth().oauth2(token).
                body(body).
        when().put(path).
        then().spec(SpecBuilder.getResponseSpec()).
                extract().
                response();
    }
}
