package com.simbirsoft.data;

import com.github.javafaker.Faker;

public class ReqresCreateApiData {
    Faker faker = new Faker();
    public String urlCreate = "/api/users";
    public int statusCode = 201;
    public String name = String.valueOf(faker.name());
    public String job = String.valueOf(faker.job());
    public String data = String.format("{\"name\":%s,\"job\":%s}", name, job);
    public int id = 0;
    public String timeTo = HelperData.creatureAtAfter(0);
}
