package br.com.pokemons.tipos;

import br.com.pokemons.tipos.DamageRelations;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TipoWeak {

    @JsonProperty("damage_relations")
    private DamageRelations damageRelations;
    @JsonProperty("pokemon")
    private List<PokemonEntry> pokemon;

    @JsonProperty("moves")
    private List<MoveEntry> moves;

    public List<PokemonEntry> getPokemon() { return pokemon; }
    public List<MoveEntry> getMoves() { return moves; }

    public DamageRelations getDamageRelations() {
        return damageRelations;
    }

    public void setDamageRelations(DamageRelations damageRelations) {
        this.damageRelations = damageRelations;
    }
}