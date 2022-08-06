package com.simbirsoft.data;

import com.github.javafaker.Faker;

public class ReqresCreateApiData {
    Faker faker = new Faker();
    public String name = String.valueOf(faker.name());
    public String job = String.valueOf(faker.job());
    public String data = String.format("{\"name\":%s,\"job\":%s}", name, job);
    public int id = 0;
}
