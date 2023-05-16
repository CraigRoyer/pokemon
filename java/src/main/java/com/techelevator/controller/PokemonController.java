package com.techelevator.controller;

import com.techelevator.dao.PokemonDAO;
import com.techelevator.model.Pokemon;
import com.techelevator.model.PokemonPair;
import com.techelevator.services.PokemonService;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/pokemon")
public class PokemonController {

    private PokemonDAO pokemonDao;

    public PokemonController(){
        this.pokemonDao = new PokemonDAO();
    }
    @RequestMapping(path = "/{name1}/{name2}", method = RequestMethod.GET)
    public PokemonPair getPokemonPair(@PathVariable String name1, @PathVariable String name2) {
       return pokemonDao.comparePokemon(name1,name2);
    }

}
