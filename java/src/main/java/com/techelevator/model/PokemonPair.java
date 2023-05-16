package com.techelevator.model;

import java.util.List;

public class PokemonPair {

    private Pokemon pokemon1;

    private Pokemon pokemon2;

    private boolean isCompatible;

    private List<EggGroup> commonEggGroups;

    public PokemonPair() {
    }

    public PokemonPair(Pokemon pokemon1, Pokemon pokemon2, boolean isCompatible) {
        this.pokemon1 = pokemon1;
        this.pokemon2 = pokemon2;
        this.isCompatible = isCompatible;
    }

    public Pokemon getPokemon1() {
        return pokemon1;
    }

    public void setPokemon1(Pokemon pokemon1) {
        this.pokemon1 = pokemon1;
    }

    public Pokemon getPokemon2() {
        return pokemon2;
    }

    public void setPokemon2(Pokemon pokemon2) {
        this.pokemon2 = pokemon2;
    }

    public boolean isCompatible() {
        return isCompatible;
    }

    public void setCompatible(boolean compatible) {
        isCompatible = compatible;
    }

    public List<EggGroup> getCommonEggGroups() {
        return commonEggGroups;
    }

    public void setCommonEggGroups(List<EggGroup> commonEggGroups) {
        this.commonEggGroups = commonEggGroups;
    }

    public boolean checkCompatibility(){
        return false;
    }
}
