package br.com.pokemons.api;

import java.util.Map;

import static java.util.Map.entry;

public class TranslateTypes {
    private static final Map<String, String> translateTypes = Map.ofEntries(
            entry("fogo", "fire"),
            entry("agua", "water"),
            entry("grama", "grass"),
            entry("voador", "flying"),
            entry("lutador", "fighting"),
            entry("veneno", "poison"),
            entry("eletrico", "electric"),
            entry("terra", "ground"),
            entry("pedra", "rock"),
            entry("psiquico", "psychic"),
            entry("gelo", "ice"),
            entry("inseto", "bug"),
            entry("fantasma", "ghost"),
            entry("ferro", "steel"),
            entry("dragao", "dragon"),
            entry("sombrio", "dark"),
            entry("fada", "fairy")
    );

    public static String translate(String typePortugues){
        if(typePortugues == null || typePortugues.isBlank()){
            return"";
        }
        return translateTypes.getOrDefault(typePortugues.toLowerCase(),typePortugues.toLowerCase());
    }
}
