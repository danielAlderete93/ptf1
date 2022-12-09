package com.proyectotorneos.application.api.rest.mapper;

import com.proyectotorneos.application.api.rest.dto.request.ActuacionPartidoRequest;
import com.proyectotorneos.application.api.rest.dto.response.ActuacionEquipoResponse;
import com.proyectotorneos.application.api.rest.dto.response.PartidoGolResponse;
import com.proyectotorneos.domain.model.ActuacionEquipo;
import com.proyectotorneos.domain.model.Equipo;
import com.proyectotorneos.domain.model.Jugador;
import com.proyectotorneos.domain.model.PartidoGol;
import com.proyectotorneos.domain.port.service.EquipoService;
import com.proyectotorneos.domain.port.service.JugadorService;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ActuacionEquipoRestMapper {
    private final PartidoGolRestMapper partidoGolRestMapper;
    private final EquipoService equipoService;
    private final JugadorService jugadorService;


    public ActuacionEquipoRestMapper(PartidoGolRestMapper partidoGolRestMapper, EquipoService equipoService, JugadorService jugadorService) {
        this.partidoGolRestMapper = partidoGolRestMapper;
        this.equipoService = equipoService;
        this.jugadorService = jugadorService;
    }

    public ActuacionEquipoResponse toResponse(ActuacionEquipo actuacionEquipo) {
        List<String> nombreJugadores;
        List<PartidoGolResponse> golResponses;
        if (actuacionEquipo == null) {
            return null;
        }
        nombreJugadores = actuacionEquipo.getJugadoresParticipante()
                .stream()
                .map(Jugador::getNombre)
                .toList()
        ;

        golResponses = actuacionEquipo.getGoles()
                .stream()
                .map(partidoGolRestMapper::toResponse)
                .toList()
        ;


        return new ActuacionEquipoResponse(
                actuacionEquipo.getId(),
                actuacionEquipo.getEquipo().getNombre(),
                nombreJugadores,
                golResponses
        );

    }


    public ActuacionEquipo toDomain(ActuacionPartidoRequest request) {
        ActuacionEquipo actuacionEquipo = new ActuacionEquipo();
        Equipo equipo;
        List<PartidoGol> goles;
        List<Jugador> jugadorList;
        if (request == null) {
            return null;
        }

        equipo = equipoService.buscaPorID(request.equipoID());
        jugadorList = request.jugadoresParticipante().stream()
                .map(jugadorService::buscaPorID)
                .collect(Collectors.toList());

        goles = request.goles().stream()
                .map(partidoGolRestMapper::toDomain)
                .collect(Collectors.toList());

        actuacionEquipo.setEquipo(equipo);
        actuacionEquipo.setJugadoresParticipante(jugadorList);
        actuacionEquipo.setGoles(goles);


        return actuacionEquipo;

    }
}
