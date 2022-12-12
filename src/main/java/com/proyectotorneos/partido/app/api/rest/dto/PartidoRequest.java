package com.proyectotorneos.partido.app.api.rest.dto;

import java.util.Date;

public record PartidoRequest(Integer idEquipoLocal,
                             Integer idEquipoVisitante,
                             Date fecha) {
}
