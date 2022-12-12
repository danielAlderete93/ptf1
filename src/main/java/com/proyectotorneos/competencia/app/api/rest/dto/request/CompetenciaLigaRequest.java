package com.proyectotorneos.competencia.app.api.rest.dto.request;

import java.util.List;

public record CompetenciaLigaRequest(
        String nombre,
        List<Integer> equipoID,
        List<CompetenciaLigaRequest> grupos
) {
}
