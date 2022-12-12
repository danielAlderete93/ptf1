package com.proyectotorneos.gol.app.api.rest.dto;

public record PartidoGolResponse(
        String nombreJugador,
        Integer tiempo,
        String descripcion
) {

}
