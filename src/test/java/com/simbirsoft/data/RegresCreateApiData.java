package com.simbirsoft.data;

import com.github.javafaker.Faker;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Pattern;

public class RegresCreateApiData {
    Faker faker = new Faker();
    public String urlCreate = "/api/users";
    public int statusCode = 201;
    public String name = String.valueOf(faker.name());
    public String job = String.valueOf(faker.job());
    public String data = String.format("{\"name\":%s,\"job\":%s}", name, job);
    public int id = 0;
    public String matcherrr = createdAtAfter(0);

    public String createdAtAfter(int minute) {
        SimpleDateFormat createdAtBefore = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ");
        String text = createdAtBefore.format(new Date());
        String regexp = "(\\+)";
        Pattern pattern = Pattern.compile(regexp);
        String[] matcherrr = pattern.split(text);
        System.out.println(matcherrr[0]);
        String regexp1 = "(T)";
        Pattern pattern1 = Pattern.compile(regexp1);
        String[] matcherrr1 = pattern1.split(matcherrr[0]);
        String regexp2 = "(\\:)";
        Pattern pattern2 = Pattern.compile(regexp2);
        String[] matcherrr2 = pattern2.split(matcherrr1[1]);
        matcherrr[0] = matcherrr[0].replaceFirst("T" + matcherrr2[0], "T"
                + optimiz(Integer.valueOf(matcherrr2[0]) - 4));
        matcherrr[0] = matcherrr[0].replaceFirst(":" + matcherrr2[1], ":"
                + optimiz(Integer.valueOf(matcherrr2[1]) + minute));
        return matcherrr[0];
    }

    public String optimiz(int number) {
        if (number < 10) {
            return "0" + number;
        } else {
            return String.valueOf(number);
        }
    }
}
