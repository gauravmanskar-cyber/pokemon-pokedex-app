package com.example.demo.service;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


import com.example.demo.exception.PokemonNotFoundException;

@Service
public class PokemonService {

    private final RestTemplate restTemplate;

    public PokemonService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Cacheable(value = "pokemonCache",key = "#name")
    public Object getPokemon(String name) {
    	System.out.println("API HIT");

        String url = "https://pokeapi.co/api/v2/pokemon/" + name;

        try {

            return restTemplate.getForObject(
                    url,
                    Object.class
            );

        } catch (Exception e) {

            throw new PokemonNotFoundException(
                    "Pokemon not found"
            );
        }
    }
}
