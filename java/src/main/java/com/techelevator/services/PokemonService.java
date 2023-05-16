package com.techelevator.services;
import org.springframework.web.client.RestTemplate;

import com.techelevator.model.Pokemon;
public class PokemonService {
    public static String API_BASE_URL = "https://pokeapi.co/api/v2/pokemon-species/";
    private RestTemplate restTemplate = new RestTemplate();

    public Pokemon getPokemon(String name) {
        return restTemplate.getForObject(API_BASE_URL + name, Pokemon.class);
    }

    public Pokemon getPokemonFromAPI(String name) {
        return restTemplate.getForObject(API_BASE_URL + name, Pokemon.class);
    }




}
