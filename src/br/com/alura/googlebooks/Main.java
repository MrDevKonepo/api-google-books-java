package br.com.alura.googlebooks;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Busque um livro pelo título: ");
        var titulo = scanner.nextLine();

        String endereco ="https://www.googleapis.com/books/v1/volumes?q="
                          + titulo
                          + "&key=AIzaSyB5I0fsg-WOHv4vsvicgw2FzA6-C_8fsFw";

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(endereco)).build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        System.out.println(response.body());
    }
}
