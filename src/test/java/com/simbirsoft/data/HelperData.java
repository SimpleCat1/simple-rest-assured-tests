package com.simbirsoft.data;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;
import java.util.regex.Pattern;

public class HelperData {
    public static String creatureAtAfter(int minute) {
        SimpleDateFormat createdAtBefore = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ");
        createdAtBefore.setTimeZone(TimeZone.getTimeZone("GMT+0:00"));
        String text = createdAtBefore.format(new Date());
        String regexp = "(\\+)";
        Pattern pattern = Pattern.compile(regexp);
        String[] timeTo = pattern.split(text);
        System.out.println(timeTo[0]);
        String regexp1 = "(T)";
        Pattern pattern1 = Pattern.compile(regexp1);
        String[] timeTo1 = pattern1.split(timeTo[0]);
        String regexp2 = "(\\:)";
        Pattern pattern2 = Pattern.compile(regexp2);
        String[] timeTo2 = pattern2.split(timeTo1[1]);
        timeTo[0] = timeTo[0].replaceFirst(":" + timeTo2[1], ":"
                + changingMinutesInADate(Integer.valueOf(timeTo2[1]) + minute));
        return timeTo[0];
    }

    public static String changingMinutesInADate(int number) {
        if (number < 10) {
            return "0" + number;
        } else {
            return String.valueOf(number);
        }
    }
}
