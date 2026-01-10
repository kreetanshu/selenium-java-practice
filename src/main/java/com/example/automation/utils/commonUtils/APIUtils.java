package com.example.automation.utils.commonUtils;

import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class APIUtils {

    public Response sendGetRequest(String url) {
        return given()
                .when()
                .get(url)
                .then()
                .extract()
                .response();
    }

    public Response sendPostRequest(String url, Object body, String contentType) {
        return given()
                .contentType(contentType)
                .body(body)
                .when()
                .post(url)
                .then()
                .extract()
                .response();
    }

    public Response sendPutRequest(String url, Object body, String contentType) {
        return given()
                .contentType(contentType)
                .body(body)
                .when()
                .put(url)
                .then()
                .extract()
                .response();
    }

    public Response sendDeleteRequest(String url) {
        return given()
                .when()
                .delete(url)
                .then()
                .extract()
                .response();
    }


}
