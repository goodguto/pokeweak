package br.com.pokemons.api;

import br.com.pokemons.tipos.TipoWeak; // Importe sua classe POJO principal
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
public class PokeApiClient {
    private static ObjectMapper objectMapper;
    private static HttpClient httpClient = null;

    public PokeApiClient(){
        this.objectMapper = new ObjectMapper();
        this.httpClient = HttpClient.newHttpClient();

    }
    protected static TipoWeak searchTypePokemon(String nomeDoTipo) throws IOException, InterruptedException {
        String tipoEmIngles = TranslateTypes.translate(nomeDoTipo); //  traduzindo para não dar erro na hora de buscar na url
        String url = "https://pokeapi.co/api/v2/type/" + tipoEmIngles;

        // Cria e envia a requisição
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(url)).GET().build();
        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

        // 4. Se a resposta for OK, converte o JSON para objeto e retorna
        if (response.statusCode() == 200) {
            return objectMapper.readValue(response.body(), TipoWeak.class);
        } else {
            System.err.println("Tipo não encontrado ou erro na API: " + tipoEmIngles + " (Status: " + response.statusCode() + ")");
            return null;
        }
    }

}

