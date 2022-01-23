package com.excersise.restservice.consumeRest.service;

import com.excersise.restservice.consumeRest.response.Coordenadas;

public interface ProvinciasService {

    Coordenadas getCoordenadasProvincia(String nombre) throws ProvinciaException ;
}
