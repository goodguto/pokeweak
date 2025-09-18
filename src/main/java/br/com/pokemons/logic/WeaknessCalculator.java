package br.com.pokemons.logic;
import br.com.pokemons.api.TypeWeak;
import br.com.pokemons.tipos.TipoWeak;
import br.com.pokemons.tipos.TypeName;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WeaknessCalculator {
    //temos que inicializar os tipos do mapa de dano *em inglês
    private static final List<String> ALL_TYPES = Arrays.asList(
            "normal", "fire", "water", "grass", "electric", "ice", "fighting", "poison",
            "ground", "flying", "psychic", "bug", "rock", "ghost", "dragon", "dark",
            "steel", "fairy"
    );

    public Map<String, Double> calcular(TipoWeak tipo1, TipoWeak tipo2) {
        // inicia o mapa com todos os tipos de ataque causando dano normal (1.0)
        Map<String, Double> damageMultipliers = new HashMap<>();
        for (String type : ALL_TYPES) {
            damageMultipliers.put(type, 1.0);
        }
        processarTipo(damageMultipliers, tipo1);

        if (tipo2 != null) {
            processarTipo(damageMultipliers, tipo2);
        }

        return damageMultipliers;
    }

    private void processarTipo(Map<String, Double> multipliers, TipoWeak tipo) {
        if (tipo == null) return;

        // Fraquezas (dano dobrado)
        for (TypeName weakness : tipo.getDamageRelations().getDoubleDamageFrom()) {
            String typeName = weakness.getName();
            multipliers.put(typeName, multipliers.get(typeName) * 2.0);
        }

        // Resistências (meio dano)
        for (TypeName resistance : tipo.getDamageRelations().getHalfDamageFrom()) {
            String typeName = resistance.getName();
            multipliers.put(typeName, multipliers.get(typeName) * 0.5);
        }

        // Imunidades (dano zero)
        for (TypeName immunity : tipo.getDamageRelations().getNoDamageFrom()) {
            String typeName = immunity.getName();
            multipliers.put(typeName, multipliers.get(typeName) * 0.0);
        }
    }
}
