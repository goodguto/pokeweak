package br.com.pokemons.api;

import br.com.pokemons.tipos.TipoWeak;

import java.io.IOException;

public class TypeWeak {
    public void analisarFraquezas(String tipo1, String tipo2) {
        try {
            PokeApiClient client = new PokeApiClient();
            // Busca os dados do primeiro tipo (obrigatório)
            System.out.println("Buscando dados para o tipo: " + tipo1);
            TipoWeak dataType1 = client.searchTypePokemon(tipo1);
            TipoWeak dataType2 = null;

            // Se o segundo tipo foi informado, busca os dados dele também
            if (tipo2 != null && !tipo2.isBlank()) {
                System.out.println("Buscando dados para o tipo: " + tipo2);
                dataType2 = client.searchTypePokemon(tipo2);
            }

            if (dataType1 != null) {
                System.out.println("Dados do tipo 1 recebidos com sucesso!");
            }
            if (dataType2 != null) {
                System.out.println("Dados do tipo 2 recebidos com sucesso!");
            }

        } catch (IOException | InterruptedException e) {
            System.err.println("Erro de conexão com a PokeAPI.");
            e.printStackTrace();
        }
    }
}
