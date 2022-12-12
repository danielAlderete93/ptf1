package com.proyectotorneos.fecha.app.api.rest.dto;

import java.util.List;

public record FechaCompetitivaResponse(Integer idFecha, Integer nroFecha, List<Integer> idPartidos) {
}
