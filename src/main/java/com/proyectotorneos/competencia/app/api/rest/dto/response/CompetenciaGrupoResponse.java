package com.proyectotorneos.competencia.app.api.rest.dto.response;

import com.proyectotorneos.equipo.app.rest.dto.EquipoResponse;

import java.util.List;

public record CompetenciaGrupoResponse(Integer id,
                                       String nombre,
                                       List<EquipoResponse> equipo,
                                       List<CompetenciaLigaResponse> grupos) {
}
