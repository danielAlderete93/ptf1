package com.proyectotorneos.application.api.rest.dto.request;

import java.util.List;

public record ActuacionPartidoRequest(
        Integer actuacionID,
        Integer equipoID,
        List<Integer> jugadoresParticipante,
        List<PartidoGolRequest> goles) {

}
