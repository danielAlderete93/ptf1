package com.proyectotorneos.competencia.app.api.rest.dto.request;

import java.util.List;

public record CompetenciaFaseEliminatoriaRequest(
        String nombre,
        List<Integer> equiposID
) {
}
