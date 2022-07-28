package com.simbirsoft.data;

import com.github.javafaker.Faker;

public class ReqresPatchPutApiData {
    Faker faker = new Faker();
    public String urlCreate;
    public int statusCode = 201;
    public String name = String.valueOf(faker.name());
    public String job = String.valueOf(faker.job());
    public String data = String.format("{\"name\":%s,\"job\":%s}", name, job);
    public String timeTo = HelperData.creatureAtAfter(0);

    public ReqresPatchPutApiData(String id) {
        this.urlCreate = String.format("/api/users/%s", id);
    }
}
