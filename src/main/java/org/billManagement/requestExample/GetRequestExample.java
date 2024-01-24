package org.billManagement.requestExample;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class GetRequestExample {
    public static void main(String[] args) {
        /**
         * istek yapılacak API url.
         * DİKKAT SERVİSE SADECE 1 KERE İSTEK ATILABİLİR.
         */
        String url = "http://universities.hipolabs.com/search?country=United+States";

        /**
         * gönderilecek isteğin hazırlanması.
         */
        HttpClient httpClient = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .GET()
                .build();

        /**
         * isteğin gönderilmesi ve alınan response.
         */
        try {
            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
            System.out.println("Response Kod: " + response.statusCode());
            System.out.println("Response Body: " + response.body());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
