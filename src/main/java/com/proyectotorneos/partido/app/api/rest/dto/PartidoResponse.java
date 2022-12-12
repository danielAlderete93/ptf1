package com.proyectotorneos.partido.app.api.rest.dto;

import com.proyectotorneos.actuacion.app.api.rest.dto.ActuacionEquipoResponse;

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
