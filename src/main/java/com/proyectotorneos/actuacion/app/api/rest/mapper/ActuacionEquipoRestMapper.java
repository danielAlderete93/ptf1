package com.proyectotorneos.actuacion.app.api.rest.mapper;

import com.proyectotorneos.actuacion.app.api.rest.dto.ActuacionEquipoResponse;
import com.proyectotorneos.actuacion.app.api.rest.dto.ActuacionPartidoRequest;
import com.proyectotorneos.actuacion.domain.model.ActuacionEquipo;
import com.proyectotorneos.equipo.domain.port.service.EquipoService;
import com.proyectotorneos.gol.app.api.rest.dto.PartidoGolResponse;
import com.proyectotorneos.gol.app.api.rest.mapper.PartidoGolRestMapper;
import com.proyectotorneos.gol.domain.model.PartidoGol;
import com.proyectotorneos.jugador.domain.model.Jugador;
import com.proyectotorneos.jugador.domain.port.services.JugadorService;
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
        List<PartidoGol> goles;
        List<Jugador> jugadorList;

        if (request == null) {
            return null;
        }

        jugadorList = request.jugadoresParticipante().stream()
                .map(jugadorService::buscaPorID)
                .collect(Collectors.toList());

        goles = request.goles().stream()
                .map(partidoGolRestMapper::toDomain)
                .collect(Collectors.toList());

        return ActuacionEquipo.builder()
                .equipo(equipoService.buscaPorID(request.equipoID()))
                .jugadoresParticipante(jugadorList)
                .goles(goles)
                .build();
    }
}
