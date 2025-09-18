package br.com.pokemons.tipos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
@JsonIgnoreProperties(ignoreUnknown = true)
public class DamageRelations {

    @JsonProperty("double_damage_from")
    private List<TypeName> doubleDamageFrom;

    @JsonProperty("half_damage_from")
    private List<TypeName> halfDamageFrom;

    @JsonProperty("no_damage_from")
    private List<TypeName> noDamageFrom;


    public List<TypeName> getDoubleDamageFrom() {
        return doubleDamageFrom;
    }

    public List<TypeName> getHalfDamageFrom() {
        return halfDamageFrom;
    }

    public List<TypeName> getNoDamageFrom() {
        return noDamageFrom;
    }
}