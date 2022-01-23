package com.excersise.restservice.consumeRest.service;

import com.excersise.restservice.consumeRest.response.Coordenadas;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ProvinciasServiceTests {

    @Autowired
    private ProvinciasService provinciasService;

    @Test
    void obtenerCoordenadasFuncionando(){
        Coordenadas resEsperado= new Coordenadas(-27.3358332810217,-66.9476824299928);
        Coordenadas res=provinciasService.getCoordenadasProvincia("Catamarca");
        Assertions.assertEquals(res.getLat(),resEsperado.getLat());
        Assertions.assertEquals(res.getLon(),resEsperado.getLon());
    }

    @Test
    void obtenerCoordenadasProvinciaNoExistente(){
        Exception exception = Assertions.assertThrows(ProvinciaException.class, () -> {
            provinciasService.getCoordenadasProvincia("xxxxxx");
        });
        String mensajeEsperado="Provincia no encontrada";
        String mensajeObtenido= exception.getMessage();
        Assertions.assertTrue(mensajeObtenido.contains(mensajeEsperado));
    }




}
