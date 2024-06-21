package com.oracle.conversorMonedas;

import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.logging.Logger;

public class Request {
    private String TOKEN="";

    HttpClient client = HttpClient.newHttpClient();
    HttpRequest request = HttpRequest.newBuilder()
            .uri(URI.create("https://v6.exchangerate-api.com/v6/"+TOKEN+"/latest/USD"))
            .build();

    public double getCurrencyRequest(String curren) {
        HttpResponse<String> response = null;
        try {
            response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException | InterruptedException e) {
            System.out.println(e.getMessage());;
        }
        if (response.statusCode()==200) {
            Gson gson = new Gson();
            Currency currency = gson.fromJson(response.body(), Currency.class);
            return (double) currency.getConversionRate(curren);
        }
        else{
            System.out.println("******************************************\n\n\nERROR la api no funciona");
            System.out.println("El error puede ser que la pagina este caida");
            System.out.println("O el token introducido sea invalido.\n\n\n******************************************");
        }
        return 0;

    }

}
