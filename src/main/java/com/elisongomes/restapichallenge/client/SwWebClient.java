package com.elisongomes.restapichallenge.client;

import com.elisongomes.restapichallenge.models.Planet;
import com.elisongomes.restapichallenge.models.SwPlanet;
import com.elisongomes.restapichallenge.models.SwPlanetList;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.ClientResponse;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Component
public class SwWebClient {

    private static final String swendpoint = "https://swapi.dev/api/planets/";
    private static final String appendpoint = "http://localhost:8080/";

    WebClient webClientSW = WebClient.create();
    WebClient webClientAPP = WebClient.create(appendpoint);

    public void fetchPlanets() {
        boolean hasNext = false;
        int page = 0;
        Mono<ClientResponse> result;

        do {
            ++page;
            result = webClientSW.get().uri(swendpoint + "?page={page}", page).accept(MediaType.APPLICATION_JSON).exchange();
            SwPlanetList swPlanetList = result.flatMap(res -> res.bodyToMono(SwPlanetList.class)).block();
            if (swPlanetList != null) {
                for (SwPlanet swPlanet : swPlanetList.getResults()) {
                    this.importPlanet(swPlanet);
                }
                hasNext = (swPlanetList.getNext() != null);
            }
        } while (hasNext);

    }

    public String importPlanet(SwPlanet swPlanet) {
        Planet planet = new Planet(swPlanet.getName(), swPlanet.getClimate(), swPlanet.getTerrain(), swPlanet.getFilms().size(), swPlanet.getId());
        Mono<ClientResponse> result = webClientAPP.post().uri("planets").body(Mono.just(planet), Planet.class)
                .accept(MediaType.APPLICATION_JSON).exchange();
        return result.flatMap(res -> res.bodyToMono(String.class)).block();
    }
}
