package com.example.loremipsumapi.service;

import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Service
public class LoremReader {

    private static final String LOREM_URL_SHORT = "https://loripsum.net/api/1/short/plaintext";
    private static final String LOREM_URL_LONG = "https://loripsum.net/api/1/long/plaintext";

    public String getLongLoremFromApi() {
        return getLoremFromApi(LOREM_URL_LONG);
    }

    public String getShortLoremFromApi() {
        return getLoremFromApi(LOREM_URL_SHORT);
    }

    private String getLoremFromApi(String loremURI) {
        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = null;
        try {
            request = HttpRequest.newBuilder()
                    .uri(new URI(loremURI))
                    .GET()
                    .build();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }

        HttpResponse<String> response = null;

        try {
            response = client.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
        return response.body();
    }
}
