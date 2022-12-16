package com.proyectotorneos.partido.app.api.rest.mapper;

import com.proyectotorneos.actuacion.app.api.rest.mapper.ActuacionEquipoRestMapper;
import com.proyectotorneos.actuacion.domain.model.ActuacionEquipo;
import com.proyectotorneos.equipo.domain.port.service.EquipoService;
import com.proyectotorneos.partido.app.api.rest.dto.PartidoRequest;
import com.proyectotorneos.partido.app.api.rest.dto.PartidoResponse;
import com.proyectotorneos.partido.domain.model.Partido;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

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
                actuacionEquipoRestMapper.toResponse(partido.getActuacionLocal()),
                actuacionEquipoRestMapper.toResponse(partido.getActuacionVisitante()),
                partido.isFinalizado(),
                partido.getFecha(),
                partido.cantGolesLocales(),
                partido.cantGolesVisitante()
        );
    }

    public Partido toDomain(PartidoRequest request) {

        if (request == null) {
            return null;
        }

        return Partido.builder()
                .fecha(request.fecha())
                .finalizado(false)
                .actuacionLocal(getActuacionByEquipoID(request.idEquipoLocal()))
                .actuacionVisitante(getActuacionByEquipoID(request.idEquipoVisitante()))
                .build();
    }

    private ActuacionEquipo getActuacionByEquipoID(Integer idEquipo) {
        ActuacionEquipo actuacion;
        actuacion = new ActuacionEquipo();
        actuacion.setGoles(new ArrayList<>());
        actuacion.setJugadoresParticipante(new ArrayList<>());
        actuacion.setEquipo(equipoService.buscaPorID(idEquipo));
        return actuacion;
    }
}
