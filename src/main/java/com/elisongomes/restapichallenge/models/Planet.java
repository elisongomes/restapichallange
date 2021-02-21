package com.elisongomes.restapichallenge.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table("planets")
public class Planet {

    @Id
    private Integer id;
    private String name;
    private String climate;
    private String terrain;
    private Integer filmsCount;
    private Integer swId;

    public Planet() {

    }

    public Planet(String name, String climate, String terrain, Integer filmsCount, Integer swId) {
        this.name = name;
        this.climate = climate;
        this.terrain = terrain;
        this.filmsCount = filmsCount;
        this.swId = swId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Integer getFilmsCount() {
        return filmsCount;
    }

    public void setFilmsCount(Integer filmsCount) {
        this.filmsCount = filmsCount;
    }

    public Integer getSwId() {
        return swId;
    }

    public void setSwId(Integer swId) {
        this.swId = swId;
    }
}
