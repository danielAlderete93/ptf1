package com.proyectotorneos.application.api.rest.dto.response;

import java.util.List;

public record ActuacionEquipoResponse(
        Integer id,
        String equipo,
        List<String> jugadoresParticipante,
        List<PartidoGolResponse> goles
) {

}
