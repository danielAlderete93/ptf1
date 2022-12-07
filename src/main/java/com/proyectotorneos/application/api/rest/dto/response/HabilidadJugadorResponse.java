package com.proyectotorneos.application.api.rest.dto.response;

import lombok.Getter;
import lombok.Setter;

public record HabilidadJugadorResponse(
        Integer id,
        String nombre,
        String descripcion,
        TipoHabilidadResponse tipoHabilidad
) {




}
