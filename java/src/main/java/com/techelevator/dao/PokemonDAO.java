package com.techelevator.dao;

import com.techelevator.model.EggGroup;
import com.techelevator.model.Pokemon;
import com.techelevator.model.PokemonPair;
import com.techelevator.services.PokemonService;

import java.util.ArrayList;
import java.util.List;

public class PokemonDAO {

   PokemonService pokemonService = new PokemonService();
   List<EggGroup> commonEggGroupsToSet = new ArrayList<>();
   public PokemonDAO(){};

   public PokemonPair comparePokemon(String pokemonString1, String pokemonString2){
      Pokemon pokemon1 = pokemonService.getPokemonFromAPI(pokemonString1);
      Pokemon pokemon2 = pokemonService.getPokemonFromAPI(pokemonString2);
      PokemonPair pokemonPair = new PokemonPair(pokemon1,pokemon2,false);

      List<EggGroup> pokemon1EggGroups = pokemon1.getEggGroups();
      List<EggGroup> pokemon2EggGroups = pokemon2.getEggGroups();


      if (pokemon1EggGroups.size() < pokemon2EggGroups.size()) {
         unequalGroupCheck(pokemon2EggGroups,pokemon1EggGroups, pokemonPair);

      } else if (pokemon1EggGroups.size() > pokemon2EggGroups.size()) {
         unequalGroupCheck(pokemon1EggGroups,pokemon2EggGroups, pokemonPair);

      } else if (pokemon1EggGroups.size() == pokemon2EggGroups.size() && pokemon2EggGroups.size() == 2) {
         if ((pokemon1EggGroups.get(0).getName().equals(pokemon2EggGroups.get(0).getName()) && pokemon1EggGroups.get(1).getName().equals(pokemon2EggGroups.get(1).getName()))
                 || (pokemon1EggGroups.get(1).getName().equals(pokemon2EggGroups.get(0).getName()) && pokemon1EggGroups.get(0).getName().equals(pokemon2EggGroups.get(1).getName()))) {
            pokemonPair.setCompatible(true);
            commonEggGroupsToSet.add(pokemon1EggGroups.get(0));
            commonEggGroupsToSet.add(pokemon1EggGroups.get(1));
            pokemonPair.setCommonEggGroups(commonEggGroupsToSet);

         } else if (pokemon1EggGroups.get(0).getName().equals(pokemon2EggGroups.get(0).getName()) || pokemon1EggGroups.get(0).getName().equals(pokemon2EggGroups.get(1).getName())) {
            pokemonPair.setCompatible(true);
            commonEggGroupsToSet.add(pokemon1EggGroups.get(0));
            pokemonPair.setCommonEggGroups(commonEggGroupsToSet);
         } else if (pokemon1EggGroups.get(1).getName().equals(pokemon2EggGroups.get(0).getName()) || pokemon1EggGroups.get(1).getName().equals(pokemon2EggGroups.get(1).getName())) {
            pokemonPair.setCompatible(true);
            commonEggGroupsToSet.add(pokemon1EggGroups.get(1));
            pokemonPair.setCommonEggGroups(commonEggGroupsToSet);
         }

      }
      else if (pokemon1EggGroups.size() == pokemon2EggGroups.size()){
         if(pokemon1EggGroups.get(0).getName().equals(pokemon2EggGroups.get(0).getName())){
            pokemonPair.setCompatible(true);
            commonEggGroupsToSet.add(pokemon1EggGroups.get(0));
            pokemonPair.setCommonEggGroups(commonEggGroupsToSet);
         }

      }
         return pokemonPair;
   }

   public void unequalGroupCheck(List<EggGroup> biggerGroup, List<EggGroup> smallerGroup, PokemonPair pair){
      if (smallerGroup.get(0).getName().equals(biggerGroup.get(0).getName()) || smallerGroup.get(0).getName().equals(biggerGroup.get(1).getName())) {
         pair.setCompatible(true);
         commonEggGroupsToSet.add(smallerGroup.get(0));
         pair.setCommonEggGroups(commonEggGroupsToSet);

      }
   }
}


