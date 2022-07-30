package com.simbirsoft.data;

public class ReqresDeleteApiData {
    public String url;
    public int statusCode = 415;
    public String text = "<!DOCTYPE html>\n" +
            "<html lang=\"en\">\n" +
            "<head>\n" +
            "<meta charset=\"utf-8\">\n" +
            "<title>Error</title>\n" +
            "</head>\n" +
            "<body>\n" +
            "<pre>Unsupported Media Type</pre>\n" +
            "</body>\n" +
            "</html>\n";

    public ReqresDeleteApiData(String id) {
        this.url = String.format("/api/users/%s", id);
    }
}
