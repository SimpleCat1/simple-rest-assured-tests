package com.simbirsoft.helperApi;

import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class HelperApi {
    public static Response getMethod(String url) {
        return given().when().get(url).then().extract().response();
    }

    public static Response postMethod(String url, String data) {
        return given().accept("application/json").body(data).when().post(url).then().extract().response();
    }

    public static Response putMethod(String url, String data) {
        return given().accept("application/json").body(data).when().post(url).then().extract().response();
    }

    public static Response patchMethod(String url, String data) {
        return given().accept("application/json").body(data).when().post(url).then().extract().response();
    }

    public static Response deleteMethod(String url) {
        return given().when().post(url).then().extract().response();
    }
}
