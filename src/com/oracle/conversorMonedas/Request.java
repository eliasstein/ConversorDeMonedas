package com.oracle.conversorMonedas;

import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Request {
    HttpClient client = HttpClient.newHttpClient();
    HttpRequest request = HttpRequest.newBuilder()
            .uri(URI.create("https://v6.exchangerate-api.com/v6/746b859df050e8736759e221/latest/USD"))
            .build();

    public double getCurrencyRequest(String curren) {
        HttpResponse<String> response = null;
        try {
            response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException | InterruptedException e) {
            System.out.println(e.getMessage());;
        }
        if (response!=null) {
            Gson gson = new Gson();
            Currency currency = gson.fromJson(response.body(), Currency.class);
            return (double) currency.getConversionRate(curren);
        }
        return 0;

    }

}
