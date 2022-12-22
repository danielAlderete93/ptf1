package com.proyectotorneos.gol.app.api.rest.dto;

public record PartidoGolRequest(
        String descripcion,
        Integer tiempo,
        Integer jugadorID
) {
}
