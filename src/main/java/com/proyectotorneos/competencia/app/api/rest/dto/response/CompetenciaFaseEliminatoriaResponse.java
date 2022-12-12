package com.proyectotorneos.competencia.app.api.rest.dto.response;

import com.proyectotorneos.fecha.app.api.rest.dto.FechaCompetitivaResponse;

public record CompetenciaFaseEliminatoriaResponse(
        Integer id,
        String nombre,
        FechaCompetitivaResponse fecha,
        Integer faseGanadoraID,
        Integer fasePerdedoraID

) {
}
