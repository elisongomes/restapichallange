package com.elisongomes.restapichallenge.services;

import com.elisongomes.restapichallenge.models.Planet;
import com.elisongomes.restapichallenge.repositories.PlanetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class PlanetService {

    @Autowired
    private PlanetRepository planetRepository;

    public Mono<Planet> createPlanet(Planet planet){
        return planetRepository.save(planet);
    }

    public Flux<Planet> getAllPlanets(){
        return planetRepository.findAll();
    }

    public Flux<Planet> getSwPlanets(){
        return planetRepository.findBySwId(null);
    }

    public Mono<Planet> findById(Integer id){
        return planetRepository.findById(id);
    }

    public Flux<Planet> findByName(String name){
        return planetRepository.findByNameContaining(name);
    }

    public Mono<Planet> deletePlanet(Integer id){
        return planetRepository.findById(id)
                .flatMap(existingPlanet -> planetRepository.delete(existingPlanet)
                        .then(Mono.just(existingPlanet)));
    }
}
