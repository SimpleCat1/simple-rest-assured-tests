package com.simbirsoft.page;

import java.util.regex.Pattern;

public class ReqresApiMethods {
    public static String createdAt(String createdAt) {
        String regexp = "(Z)";
        Pattern pattern = Pattern.compile(regexp);
        String[] matcherrr = pattern.split(createdAt);
        return matcherrr[0];
    }

    public static boolean checkCreatedAt(String data) {
        String regexp = "(\\d{4}\\-\\d{2}\\-\\d{2}T\\d{2}\\:\\d{2}\\:\\d{2}\\.\\d{3}Z)";
        Pattern pattern = Pattern.compile(regexp);
        boolean matcherrr = pattern.matcher(data).find();
        return matcherrr;
    }
}
