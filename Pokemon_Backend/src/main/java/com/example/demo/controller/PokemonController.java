package com.example.demo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.example.demo.service.PokemonService;

@RestController
@RequestMapping("/api/pokemon")
@CrossOrigin("*")
public class PokemonController {

    private final PokemonService pokemonService;

    public PokemonController(
            PokemonService pokemonService
    ) {
        this.pokemonService = pokemonService;
    }

    @GetMapping("/{name}")
    public ResponseEntity<Object> getPokemon( @PathVariable String name) {
    	Object obj = pokemonService.getPokemon(name);
    return ResponseEntity.ok(obj);

    }
}