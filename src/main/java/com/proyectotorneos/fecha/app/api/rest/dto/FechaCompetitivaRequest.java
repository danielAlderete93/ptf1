package com.proyectotorneos.fecha.app.api.rest.dto;

import com.proyectotorneos.partido.app.api.rest.dto.PartidoRequest;

import java.util.List;

public record FechaCompetitivaRequest(Integer nroFecha, List<PartidoRequest> partidoRequests) {
}
