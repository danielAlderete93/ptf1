package com.proyectotorneos.actuacion.app.api.rest.dto;

import com.proyectotorneos.gol.app.api.rest.dto.PartidoGolResponse;

import java.util.List;

public record ActuacionEquipoResponse(
        Integer id,
        String equipo,
        List<String> jugadoresParticipante,
        List<PartidoGolResponse> goles
) {

}
