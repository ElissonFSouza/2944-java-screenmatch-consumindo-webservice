package br.com.alura.screenmatch.principal;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.Scanner;

public class PrincipalComBusca {
    public static void main(String[] args) throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("http://www.omdbapi.com/?apikey=54f8ce56&t=avengers-age-of-ultron"))
                .build();
        HttpResponse<String> response = client
                .send(request, BodyHandlers.ofString());

        System.out.println(response.body());
        

        try (Scanner leitura = new Scanner(System.in)) {
            System.out.println("Digite o nome da criptomoeda para a cotação (por exemplo, bitcoin): ");
            var criptoNome = leitura.nextLine();

            String endereco = "https://api.coingecko.com/api/v3/simple/price?ids=" + criptoNome + "&vs_currencies=usd";

            HttpClient client2 = HttpClient.newHttpClient();
            HttpRequest request2 = HttpRequest.newBuilder().uri(URI.create(endereco)).build();
            HttpResponse<String> response2 = client2.send(request2, HttpResponse.BodyHandlers.ofString());

            System.out.println(response2.body());
        }
    }
    
}
