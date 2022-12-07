package com.proyectotorneos.application.api.rest.mapper;

import com.proyectotorneos.application.api.rest.dto.request.PartidoRequest;
import com.proyectotorneos.application.api.rest.dto.response.ActuacionEquipoResponse;
import com.proyectotorneos.application.api.rest.dto.response.PartidoResponse;
import com.proyectotorneos.domain.model.ActuacionEquipo;
import com.proyectotorneos.domain.model.Partido;
import com.proyectotorneos.domain.port.service.EquipoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;

@Component
public class PartidoRestMapper {
    private final EquipoService equipoService;
    private final ActuacionEquipoRestMapper actuacionEquipoRestMapper;

    @Autowired
    public PartidoRestMapper(EquipoService equipoService, ActuacionEquipoRestMapper actuacionEquipoRestMapper) {
        this.equipoService = equipoService;
        this.actuacionEquipoRestMapper = actuacionEquipoRestMapper;
    }

    public PartidoResponse toResponse(Partido partido) {

        if (partido == null) {
            return null;
        }

        return new PartidoResponse(
                partido.getId(),
                actuacionEquipoRestMapper.toResponse(partido.getActuacionEquipoLocal()),
                actuacionEquipoRestMapper.toResponse(partido.getActuacionEquipoVisitante()),
                partido.isFinalizado(),
                partido.getFecha(),
                partido.cantGolesLocales(),
                partido.cantGolesVisitante()
        );
    }

    public Partido toDomain(PartidoRequest request) {
        Partido partido;
        ActuacionEquipo locales;
        ActuacionEquipo visitante;

        if (request == null) {
            return null;
        }

        partido = new Partido();

        partido.setFecha(request.fecha());
        partido.setFinalizado(false);

        locales = new ActuacionEquipo();
        locales.setGoles(new ArrayList<>());
        locales.setJugadoresParticipante(new ArrayList<>());
        locales.setEquipo(equipoService.buscaPorID(request.idEquipoLocal()));

        visitante = new ActuacionEquipo();
        visitante.setGoles(new ArrayList<>());
        visitante.setJugadoresParticipante(new ArrayList<>());
        visitante.setEquipo(equipoService.buscaPorID(request.idEquipoVisitante()));

        partido.setActuacionEquipoLocal(locales);
        partido.setActuacionEquipoVisitante(visitante);


        return partido;
    }
}
