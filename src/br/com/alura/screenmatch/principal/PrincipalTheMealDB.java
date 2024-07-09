package br.com.alura.screenmatch.principal;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class PrincipalTheMealDB {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner buscaMeal = new Scanner(System.in);

        System.out.println("Digite o nome da receita que deseja buscar (exemplo: Arrabiata):");
        var idReceita = buscaMeal.nextLine();

        String endereco = "http://www.themealdb.com/api/json/v1/1/search.php?s=" + idReceita;

        System.out.println("Confira a sua busca: " + endereco);
        System.out.println("Confira o resultado da sua busca:");

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(endereco)).build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        System.out.println(response.body());
    }
}
