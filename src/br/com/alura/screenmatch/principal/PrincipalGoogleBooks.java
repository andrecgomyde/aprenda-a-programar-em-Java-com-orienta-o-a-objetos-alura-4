package br.com.alura.screenmatch.principal;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class PrincipalGoogleBooks {

    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner buscaBooks = new Scanner(System.in);

        System.out.println("Digite o Vlume do livro que está buscando:");
        var idVolume = buscaBooks.nextLine();

        String endereco = "https://www.googleapis.com/books/v1/volumes/" + idVolume;

        System.out.println("Confira a sua busca: " + endereco);
        System.out.println("Confira o resultado da sua busca:");

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(endereco)).build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        System.out.println(response.body());
    }
}
