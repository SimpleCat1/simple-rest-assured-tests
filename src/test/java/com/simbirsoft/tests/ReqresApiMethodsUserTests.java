package com.simbirsoft.tests;

import com.simbirsoft.data.ReqresCreateApiData;
import com.simbirsoft.data.ReqresDeleteApiData;
import com.simbirsoft.data.ReqresPatchPutApiData;
import com.simbirsoft.data.ReqresSingleUserApiData;
import com.simbirsoft.page.ReqresApiMethods;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;

public class ReqresApiMethodsUserTests extends TestBase {

    @Test
    void checkCreate() {
        ReqresCreateApiData data = new ReqresCreateApiData();
        Response response = given()
                .accept("application/json")
                .body(data.data)
                .when()
                .post(data.url)
                .then()
                .extract()
                .response();

        assertThat(response.getStatusCode()).isEqualTo(data.statusCode);
        assertThat(Integer.valueOf(response.path("id").toString())).isGreaterThanOrEqualTo(data.id);
        assertThat(ReqresApiMethods.checkCreatedAt(response.path("createdAt").toString())).isTrue();
    }

    @Test
    void checkPut() {
        ReqresCreateApiData data1 = new ReqresCreateApiData();

        Response response1 = given()
                .accept("application/json")
                .body(data1.data)
                .when()
                .post(data1.url)
                .then()
                .extract()
                .response();

        ReqresPatchPutApiData data = new ReqresPatchPutApiData(response1.path("id").toString());

        Response response = given()
                .accept("application/json")
                .body(data.data)
                .when()
                .post(data.url)
                .then()
                .extract()
                .response();

        assertThat(response.getStatusCode()).isEqualTo(data.statusCode);
        assertThat(ReqresApiMethods.checkCreatedAt(response.path("createdAt").toString())).isTrue();
    }

    @Test
    void checkPatch() {
        ReqresCreateApiData data1 = new ReqresCreateApiData();

        Response response1 = given()
                .accept("application/json")
                .body(data1.data)
                .when()
                .post(data1.url)
                .then()
                .extract()
                .response();

        ReqresPatchPutApiData data = new ReqresPatchPutApiData(response1.path("id").toString());

        Response response = given()
                .accept("application/json")
                .body(data.data)
                .when()
                .post(data.url)
                .then()
                .extract()
                .response();

        assertThat(response.getStatusCode()).isEqualTo(data.statusCode);
        assertThat(ReqresApiMethods.checkCreatedAt(response.path("createdAt").toString())).isTrue();
    }

    @Test
    void checkDelete() {
        ReqresCreateApiData data1 = new ReqresCreateApiData();

        Response response1 = given()
                .accept("application/json")
                .body(data1.data)
                .when()
                .post(data1.url)
                .then()
                .extract()
                .response();

        ReqresDeleteApiData data = new ReqresDeleteApiData(response1.path("id").toString());

        Response response = given()
                .when()
                .post(data.url)
                .then()
                .extract()
                .response();

        assertThat(response.getStatusCode()).isEqualTo(data.statusCode);
        assertThat(response.body().print()).isEqualTo(data.text);
    }

    @Test
    void checkSingleUser() {
        ReqresSingleUserApiData data = new ReqresSingleUserApiData();
        Response response = given()
                .when()
                .get(data.url)
                .then()
                .extract()
                .response();

        assertThat(response.getStatusCode()).isEqualTo(data.statusCode);
        assertThat(response.path("data.id").toString()).isEqualTo(data.dataId);
        assertThat(response.path("data.email").toString()).isEqualTo(data.dataEmail);
        assertThat(response.path("data.first_name").toString()).isEqualTo(data.dataFirst_name);
        assertThat(response.path("data.last_name").toString()).isEqualTo(data.dataLast_name);
        assertThat(response.path("data.avatar").toString()).isEqualTo(data.dataAvatar);
        assertThat(response.path("support.url").toString()).isEqualTo(data.supportUrl);
        assertThat(response.path("support.text").toString()).isEqualTo(data.supportText);
    }
}
