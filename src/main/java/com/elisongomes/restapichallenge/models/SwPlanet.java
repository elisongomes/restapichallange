package com.elisongomes.restapichallenge.models;

import java.util.Collection;

public class SwPlanet {

    private String url;
    private String name;
    private String climate;
    private String terrain;
    private Collection<String> films;

    public Integer getId() {
        Integer id = null;
        if (this.url != null && !this.url.equals("")) {
            String swid = this.url.replaceAll(".*/(\\d+)/.*", "$1");
            if (!swid.equals("")) {
                id = Integer.parseInt(swid);
            }
        }
        return id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClimate() {
        return climate;
    }

    public void setClimate(String climate) {
        this.climate = climate;
    }

    public String getTerrain() {
        return terrain;
    }

    public void setTerrain(String terrain) {
        this.terrain = terrain;
    }

    public Collection<String> getFilms() {
        return films;
    }

    public void setFilms(Collection<String> films) {
        this.films = films;
    }
}
