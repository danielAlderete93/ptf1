package com.proyectotorneos.application.api.rest.dto.response;

import lombok.Getter;
import lombok.Setter;

public record PartidoGolResponse(
        String nombreJugador,
        Integer tiempo,
        String descripcion
) {

}
