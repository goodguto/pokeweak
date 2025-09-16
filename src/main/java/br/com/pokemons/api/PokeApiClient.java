package br.com.pokemons.api;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class PokeApiClient {
    private static final String BASE_URL = "https://pokeapi.co/api/v2/";

    private final RestTemplate restTemplate = new RestTemplate();

    public String getTipo(String tipo) {
        String url = BASE_URL + "type/" + tipo.toLowerCase();
        return restTemplate.getForObject(url, String.class); // retorna JSON puro
    }
}

