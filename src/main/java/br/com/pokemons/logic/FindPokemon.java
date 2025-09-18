package br.com.pokemons.logic;

import br.com.pokemons.tipos.TipoWeak;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static org.springframework.util.StringUtils.capitalize;

public class FindPokemon {

    private static String encontrarPokemonExemplo(TipoWeak dadosTipo1, TipoWeak dadosTipo2) {
        List<String> listaPokemon1 = dadosTipo1.getPokemon().stream()
                .map(p -> p.getPokemon().getName())
                .collect(Collectors.toList());

        if (dadosTipo2 == null) {
            return listaPokemon1.isEmpty() ? "Nenhum encontrado" : capitalize(listaPokemon1.get(0));
        }

        List<String> listaPokemon2 = dadosTipo2.getPokemon().stream()
                .map(p -> p.getPokemon().getName())
                .collect(Collectors.toList());

        // Encontra um Pokémon que está em ambas as listas (interseção)
        Set<String> setPokemon1 = new HashSet<>(listaPokemon1);
        for (String nomePokemon : listaPokemon2) {
            if (setPokemon1.contains(nomePokemon)) {
                return capitalize(nomePokemon);
            }
        }

        return "Nenhum Pokémon com essa combinação de tipos foi encontrado.";
    }
}
