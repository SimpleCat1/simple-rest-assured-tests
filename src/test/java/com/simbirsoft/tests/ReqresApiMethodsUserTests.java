package com.simbirsoft.tests;

import com.simbirsoft.data.HelperData;
import com.simbirsoft.data.ReqresCreateApiData;
import com.simbirsoft.data.ReqresDeleteApiData;
import com.simbirsoft.data.ReqresPatchPutApiData;
import com.simbirsoft.data.ReqresSingleUserApiData;
import com.simbirsoft.page.ReqresApiMethods;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import static com.simbirsoft.helperApi.HelperApi.deleteMethod;
import static com.simbirsoft.helperApi.HelperApi.getMethod;
import static com.simbirsoft.helperApi.HelperApi.patchMethod;
import static com.simbirsoft.helperApi.HelperApi.postMethod;
import static com.simbirsoft.helperApi.HelperApi.putMethod;
import static org.assertj.core.api.Assertions.assertThat;

public class ReqresApiMethodsUserTests extends TestBase {

    @Test
    void checkCreate() {
        ReqresCreateApiData data = new ReqresCreateApiData();
        Response response = postMethod(data.urlCreate, data.data);

        assertThat(response.getStatusCode()).isEqualTo(data.statusCode);
        assertThat(Integer.valueOf(response.path("id").toString())).isGreaterThanOrEqualTo(data.id);
        assertThat(ReqresApiMethods.checkCreatedAt(response.path("createdAt").toString())).isTrue();
        assertThat(ReqresApiMethods.createdAt(response.path("createdAt")))
                .isBetween(data.timeTo, HelperData.creatureAtAfter(1));
    }

    @Test
    void checkPut() {
        ReqresCreateApiData data1 = new ReqresCreateApiData();

        Response response1 = postMethod(data1.urlCreate, data1.data);
        ReqresPatchPutApiData data = new ReqresPatchPutApiData(response1.path("id").toString());
        Response response = putMethod(data.urlCreate, data.data);
        assertThat(response.getStatusCode()).isEqualTo(data.statusCode);
//        assertThat(Integer.valueOf(response.path("name").toString())).isEqualTo(data.name);
//        assertThat(Integer.valueOf(response.path("job").toString())).isEqualTo(data.job);
        assertThat(ReqresApiMethods.checkCreatedAt(response.path("createdAt").toString())).isTrue();
//        assertThat(ReqresApiMethods.createdAt(response.path("createdAt")))
//                .isBetween(data.timeTo,data.creatureAtAfter(1));
    }

    @Test
    void checkPatch() {

        ReqresCreateApiData data1 = new ReqresCreateApiData();
        Response response1 = postMethod(data1.urlCreate, data1.data);
        ReqresPatchPutApiData data = new ReqresPatchPutApiData(response1.path("id").toString());
        Response response = patchMethod(data.urlCreate, data.data);
        assertThat(response.getStatusCode()).isEqualTo(data.statusCode);
//        assertThat(Integer.valueOf(response.path("name").toString())).isEqualTo(data.name);
//        assertThat(Integer.valueOf(response.path("job").toString())).isEqualTo(data.job);
        assertThat(ReqresApiMethods.checkCreatedAt(response.path("createdAt").toString())).isTrue();
//        assertThat(ReqresApiMethods.createdAt(response.path("createdAt")))
//                .isBetween(data.timeTo,data.creatureAtAfter(1));
    }

    @Test
    void checkDelete() {
        ReqresCreateApiData data1 = new ReqresCreateApiData();
        Response response1 = postMethod(data1.urlCreate, data1.data);
        ReqresDeleteApiData data = new ReqresDeleteApiData(response1.path("id").toString());
        Response response = deleteMethod(data.urlCreate);
        assertThat(response.getStatusCode()).isEqualTo(data.statusCode);
//        assertThat(Integer.valueOf(response.path("name").toString())).isEqualTo(data.name);
//        assertThat(Integer.valueOf(response.path("job").toString())).isEqualTo(data.job);
        assertThat(response.body().print()).isEqualTo(data.text);
//        assertThat(ReqresApiMethods.createdAt(response.path("createdAt")))
//                .isBetween(data.timeTo,data.creatureAtAfter(1));
    }

    @Test
    void checkSingleUser() {
        ReqresSingleUserApiData data = new ReqresSingleUserApiData();

        Response response = getMethod(data.urlSingleUser);
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
