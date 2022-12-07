package com.proyectotorneos.application.api.rest.dto.request;

import java.util.Date;

public record PartidoRequest(Integer idEquipoLocal,
                             Integer idEquipoVisitante,
                             Date fecha) {
}
