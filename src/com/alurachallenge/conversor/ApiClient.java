package com.alurachallenge.conversor;
import com.google.gson.Gson;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ApiClient {
    Currency search(String base, String target, double amount) {
        URI link = URI.create( "https://v6.exchangerate-api.com/v6/fbe4bed06469b3baaa7bdecd/pair/" + base + "/" + target + "/" + amount );

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri( link ).build();

        try {
            HttpResponse<String> response = client.send( request, HttpResponse.BodyHandlers.ofString() );
            return new Gson().fromJson( response.body(), Currency.class );
        } catch (Exception e) {

            throw new RuntimeException( "Moneda no encontrada" + e.getMessage() );
        }

    }

}
