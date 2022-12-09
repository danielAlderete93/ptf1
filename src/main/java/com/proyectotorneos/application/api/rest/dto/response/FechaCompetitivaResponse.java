package com.proyectotorneos.application.api.rest.dto.response;

import java.util.List;

public record FechaCompetitivaResponse(Integer idFecha, Integer nroFecha, List<Integer> idPartidos) {
}
