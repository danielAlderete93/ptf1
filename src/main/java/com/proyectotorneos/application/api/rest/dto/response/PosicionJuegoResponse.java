package com.proyectotorneos.application.api.rest.dto.response;

import lombok.Getter;
import lombok.Setter;


public record PosicionJuegoResponse(
        Integer id,
        String nombre,
        String descripcion
) {



}
