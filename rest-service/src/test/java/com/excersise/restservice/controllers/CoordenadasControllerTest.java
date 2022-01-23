package com.excersise.restservice.controllers;

import com.excersise.restservice.consumeRest.response.Coordenadas;
import com.excersise.restservice.consumeRest.service.ProvinciaException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.server.ResponseStatusException;

@SpringBootTest
public class CoordenadasControllerTest {

    @Autowired
    private CoordenadasController coordenadasController;

    @Test
    void buscarProvincia(){
        Coordenadas resEsperado= new Coordenadas(-27.3358332810217,-66.9476824299928);
        Coordenadas res= coordenadasController.obtenerCoordenadasProvincia("Catamarca");
        Assertions.assertEquals(res.getLat(),resEsperado.getLat());
        Assertions.assertEquals(res.getLon(),resEsperado.getLon());
    }

    @Test
    void buscarProvinciaNoExistente(){
        Exception exception = Assertions.assertThrows(ProvinciaException.class, () -> {
            coordenadasController.obtenerCoordenadasProvincia("xxxxxx");
        });
        String mensajeEsperado="Provincia no encontrada";
        String mensajeObtenido= exception.getMessage();
        Assertions.assertTrue(mensajeObtenido.contains(mensajeEsperado));
    }

    @Test
    void buscarProvinciaSinNombre(){
        Exception exception = Assertions.assertThrows(ResponseStatusException.class, () -> {
            coordenadasController.obtenerCoordenadasProvincia("");
        });
        String mensajeEsperado="No se puede buscar una provincia sin su nombre";
        String mensajeObtenido= exception.getMessage();
        Assertions.assertTrue(mensajeObtenido.contains(mensajeEsperado));
    }

}
