package com.simbirsoft.page;

import java.util.regex.Pattern;

public class ReqresApiMethods {
    public static boolean checkCreatedAt(String data) {
        String regexp = "(\\d{4}\\-\\d{2}\\-\\d{2}T\\d{2}\\:\\d{2}\\:\\d{2}\\.\\d{3}Z)";
        Pattern pattern = Pattern.compile(regexp);
        boolean timeTo = pattern.matcher(data).find();
        return timeTo;
    }
}
