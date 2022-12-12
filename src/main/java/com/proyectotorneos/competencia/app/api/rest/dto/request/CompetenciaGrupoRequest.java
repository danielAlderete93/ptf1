package com.proyectotorneos.competencia.app.api.rest.dto.request;

import java.util.List;

public record CompetenciaGrupoRequest(String nombre,
                                      List<Integer> equipoID,
                                      List<CompetenciaLigaRequest> grupos
                                      ) {
}
