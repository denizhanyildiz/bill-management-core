package org.billManagement.requestExample;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class PostRequestExample {
    public static void main(String[] args) {
        /**
         * İstek yapılacak API url.
         */
        String url = "https://dummy.restapiexample.com/api/v1/create";

        /**
         * istekte gönderilecek olan json body.
         */
        JsonObject data = buildJsonObject();

        /**
         * isteğin hazırlanması.
         */
        HttpClient httpClient = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(data.toString()))
                .build();

        /**
         * isteğin ilgili uygulamaya gönderilmesi ve response'u
         */
        try {
            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
            System.out.println("Response Kod: " + response.statusCode());
            System.out.println("Response Body: " + response.body());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static JsonObject buildJsonObject() {
        JsonObjectBuilder builder = Json.createObjectBuilder();
        builder.add("name", "deneme");
        builder.add("salary", "1000");
        builder.add("age", "22");
        return builder.build();
    }
}
