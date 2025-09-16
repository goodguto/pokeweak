package br.com.pokemons.tipos;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

public class TipoWeak {

    @JsonProperty("damage_relations")
    private DamageRelations damageRelations;

    public DamageRelations getDamageRelations() {
        return damageRelations;
    }

    public void setDamageRelations(DamageRelations damageRelations) {
        this.damageRelations = damageRelations;
    }

    public static class DamageRelations {
        @JsonProperty("double_damage_from")
        private List<TypeName> doubleDamageFrom;

        @JsonProperty("half_damage_from")
        private List<TypeName> halfDamageFrom;

        public List<TypeName> getDoubleDamageFrom() {
            return doubleDamageFrom;
        }

        public List<TypeName> getHalfDamageFrom() {
            return halfDamageFrom;
        }
    }

    public static class TypeName {
        private String name;

        public String getName() {
            return name;
        }
    }
}