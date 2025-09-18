package br.com.pokemons.tipos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PokemonEntry {

    private Pokemon pokemon;

    public Pokemon getPokemon() {
        return pokemon;
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Pokemon {
        private String name;

        public String getName() {
            return name;
        }
    }
}