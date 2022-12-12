package com.proyectotorneos.actuacion.app.api.rest.dto;

import com.proyectotorneos.gol.app.api.rest.dto.PartidoGolRequest;

import java.util.List;

public record ActuacionPartidoRequest(
        Integer actuacionID,
        Integer equipoID,
        List<Integer> jugadoresParticipante,
        List<PartidoGolRequest> goles) {

}
