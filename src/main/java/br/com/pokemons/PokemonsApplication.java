package br.com.pokemons;

import br.com.pokemons.api.TypeWeak;
import java.util.Map;
import java.util.Scanner;

public class PokemonsApplication {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		TypeWeak analysisService = new TypeWeak();

		System.out.println( "======================================"+
							"I   Calculadora de Fraquezas Pokémon  I "+
							"======================================");
		System.out.print("Digite o tipo primário do Pokémon: ");
		String tipo1 = scanner.nextLine();

		System.out.print("Digite o tipo secundário (ou deixe em branco e pressione Enter): ");
		String tipo2 = scanner.nextLine();

		Map<String, Double> finalMultipliers = analysisService.analisarFraquezas(tipo1, tipo2);

		if (!finalMultipliers.isEmpty()) {
			String pokemonTypes = tipo2.isBlank() ? tipo1 : tipo1 + "/" + tipo2;
			System.out.println("\n--- Análise para o tipo: " + pokemonTypes.toUpperCase() + " ---");

			finalMultipliers.entrySet().stream()
					.filter(entry -> entry.getValue() != 1.0)
					.sorted(Map.Entry.comparingByValue())
					.forEach(entry -> {
						String attackingType = entry.getKey();
						Double multiplier = entry.getValue();

						if (multiplier == 0.0) {
							System.out.println(">> Imunidade a " + attackingType + " (x" + multiplier + ")");
						} else if (multiplier < 1.0) {
							System.out.println(">> Resistência a " + attackingType + " (x" + multiplier + ")");
						} else {
							System.out.println(">> Fraqueza a " + attackingType + " (x" + multiplier + ")");
						}
					});
		}

		System.out.println("\n--- Análise concluída. ---");
		scanner.close();
	}
}