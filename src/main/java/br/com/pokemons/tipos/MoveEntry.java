package br.com.pokemons.tipos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class MoveEntry {
    private String name;

    public String getName() {
        return name;
    }
}