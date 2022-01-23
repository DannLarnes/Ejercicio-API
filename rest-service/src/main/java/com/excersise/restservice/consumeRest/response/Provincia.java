package com.excersise.restservice.consumeRest.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Provincia {
    private Integer id;
    private String nombre;
    private Coordenadas centroide;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Coordenadas getCentroide() {
        return centroide;
    }

    public void setCentroide(Coordenadas centroide) {
        this.centroide = centroide;
    }
}
