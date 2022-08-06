package com.simbirsoft.data;

import com.github.javafaker.Faker;

public class ReqresPatchPutApiData {
    Faker faker = new Faker();
    public String url;
    public String name = String.valueOf(faker.name());
    public String job = String.valueOf(faker.job());
    public String data = String.format("{\"name\":%s,\"job\":%s}", name, job);

    public ReqresPatchPutApiData(String id) {
        this.url = String.format("/api/users/%s", id);
    }
}
