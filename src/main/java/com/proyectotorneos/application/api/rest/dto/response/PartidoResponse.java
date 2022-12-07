package com.proyectotorneos.application.api.rest.dto.response;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;


public record PartidoResponse(
        Integer id,
        ActuacionEquipoResponse local,
        ActuacionEquipoResponse visitante,
        Boolean finalizado,
        Date fecha,
        Integer golesLocales,
        Integer golesVisitante
){

}
