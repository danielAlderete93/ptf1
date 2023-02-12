package com.proyectotorneos.torneo.app.dto;

import java.util.List;

public record TorneoResponse(
        Integer id,
        String nombre,
        String descripcion,
        Integer idCompetencia,
        List<Integer> idPublicaciones
) {


}
