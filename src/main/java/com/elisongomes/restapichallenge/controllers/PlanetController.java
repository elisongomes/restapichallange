package com.elisongomes.restapichallenge.controllers;

import com.elisongomes.restapichallenge.models.Planet;
import com.elisongomes.restapichallenge.services.PlanetService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@RestController
@RequestMapping("/planets")
public class PlanetController {

    @Autowired
    private PlanetService planetService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<Planet> create(@RequestBody Planet planet){
        return planetService.createPlanet(planet);
    }

    @GetMapping
    public Flux<Planet> getAllPlanets(){
        return planetService.getAllPlanets();
    }

    @GetMapping("/sw")
    public Flux<Planet> getSwPlanets(){
        return planetService.getSwPlanets();
    }

    @GetMapping("/{id}")
    public Mono<ResponseEntity<Planet>> getPlanetById(@PathVariable Integer id){
        Mono<Planet> user = planetService.findById(id);
        return user.map( u -> ResponseEntity.ok(u))
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    @GetMapping("/search")
    public Flux<Planet> getPlanetByName(@RequestParam("name") String name){
        return planetService.findByName(name);
    }

    @DeleteMapping("/{id}")
    public Mono<ResponseEntity<Void>> deletePlanetById(@PathVariable Integer id){
        return planetService.deletePlanet(id)
                .map( r -> ResponseEntity.ok().<Void>build())
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }
}
