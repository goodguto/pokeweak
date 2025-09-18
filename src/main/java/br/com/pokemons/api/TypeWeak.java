package br.com.pokemons.api;

import br.com.pokemons.logic.WeaknessCalculator;
import br.com.pokemons.tipos.TipoWeak;
import java.io.IOException;
import java.util.Map;
import java.util.Collections;

public class TypeWeak {

    private final PokeApiClient apiClient;
    private final WeaknessCalculator calculator;

    public TypeWeak() {
        this.apiClient = new PokeApiClient();
        this.calculator = new WeaknessCalculator();
    }

    public Map<String, Double> analisarFraquezas(String tipo1, String tipo2) {
        try {
            System.out.println("Buscando os resultados do primeiro tipo: [" + tipo1 + "]...");
            TipoWeak dataType1 = apiClient.searchTypePokemon(tipo1);

            if (dataType1 == null) {
                System.err.println("Erro: Tipo primário '[" + tipo1 + "]' não encontrado.");
                return Collections.emptyMap(); // retorna um mapa vazio em caso de erro
            }

            TipoWeak dataType2 = null;
            if (tipo2 != null && !tipo2.isBlank()) {
                System.out.println("Buscando os resultados do segundo tipo: [" + tipo2 + "]...");
                dataType2 = apiClient.searchTypePokemon(tipo2);
                if (dataType2 == null) {
                    System.err.println("Aviso: Tipo secundário '[" + tipo2 + "]' não encontrado. Analisando apenas o tipo primário.");
                }
            }
            // calculamos e retornamos o resultado
            return calculator.calcular(dataType1, dataType2);

        } catch (IOException | InterruptedException e) {
            System.err.println("Erro de conexão com a PokeAPI. Tenta de novo;(.");
            e.printStackTrace();
            return Collections.emptyMap();
        }
    }
}