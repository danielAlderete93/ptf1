package com.proyectotorneos.application.api.rest.dto.request;

import java.util.List;

public record FechaCompetitivaRequest(Integer nroFecha, List<PartidoRequest> partidoRequests) {
}
