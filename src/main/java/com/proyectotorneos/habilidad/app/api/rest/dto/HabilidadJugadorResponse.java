package com.proyectotorneos.habilidad.app.api.rest.dto;

import com.proyectotorneos.tipo_habilidad.app.api.rest.dto.TipoHabilidadResponse;

public record HabilidadJugadorResponse(
        Integer id,
        String nombre,
        String descripcion,
        TipoHabilidadResponse tipoHabilidad
) {




}
