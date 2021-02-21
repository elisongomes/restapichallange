package com.elisongomes.restapichallenge.repositories;

import com.elisongomes.restapichallenge.models.Planet;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;

public interface PlanetRepository extends ReactiveCrudRepository<Planet, Integer> {
    Flux<Planet> findBySwId(Integer swId);
    Flux<Planet> findByNameContaining(String name);

}