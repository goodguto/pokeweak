package br.com.pokemons.tipos;

import br.com.pokemons.tipos.DamageRelations;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
@JsonIgnoreProperties(ignoreUnknown = true)
public class TipoWeak {

    @JsonProperty("damage_relations")
    private DamageRelations damageRelations;

    public DamageRelations getDamageRelations() {
        return damageRelations;
    }

    public void setDamageRelations(DamageRelations damageRelations) {
        this.damageRelations = damageRelations;
    }
}