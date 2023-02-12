package com.proyectotorneos.jugador.app.api.rest.mapper;

import com.proyectotorneos.habilidad.app.api.rest.dto.HabilidadJugadorResponse;
import com.proyectotorneos.habilidad.app.api.rest.mapper.HabilidadJugadorRestMapper;
import com.proyectotorneos.habilidad.domain.model.HabilidadJugador;
import com.proyectotorneos.habilidad.domain.port.services.HabilidadJugadorService;
import com.proyectotorneos.jugador.app.api.rest.dto.JugadorRequest;
import com.proyectotorneos.jugador.app.api.rest.dto.JugadorResponse;
import com.proyectotorneos.jugador.domain.model.Jugador;
import com.proyectotorneos.posicion.app.api.rest.mapper.PosicionJuegoRestMapper;
import com.proyectotorneos.posicion.domain.port.services.PosicionJuegoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class JugadorRestMapper {
    private final PosicionJuegoRestMapper posicionJuegoRestMapper;
    private final HabilidadJugadorRestMapper habilidadJugadorRestMapper;

    private final HabilidadJugadorService habilidadJugadorService;

    private final PosicionJuegoService posicionJuegoService;

    @Autowired
    public JugadorRestMapper(PosicionJuegoRestMapper posicionJuegoRestMapper, HabilidadJugadorRestMapper habilidadJugadorRestMapper, HabilidadJugadorService habilidadJugadorService, PosicionJuegoService posicionJuegoService) {
        this.posicionJuegoRestMapper = posicionJuegoRestMapper;
        this.habilidadJugadorRestMapper = habilidadJugadorRestMapper;
        this.habilidadJugadorService = habilidadJugadorService;
        this.posicionJuegoService = posicionJuegoService;
    }

    public JugadorResponse toResponse(Jugador jugador) {
        List<HabilidadJugadorResponse> habilidades;

        if (jugador == null) {
            return null;
        }

        habilidades = jugador.getHabilidades().stream()
                .map(habilidadJugadorRestMapper::toResponse)
                .toList()
        ;

        return new JugadorResponse(
                jugador.getId(),
                jugador.getNombre(),
                jugador.getFechaNacimiento(),
                jugador.getEdad(),
                posicionJuegoRestMapper.toResponse(jugador.getPosicionFavorita()),
                posicionJuegoRestMapper.toResponse(jugador.getPosicionOpcional()),
                jugador.getHabilidadPiernas(),
                habilidades
        );

    }

    public Jugador toDomain(JugadorRequest request) {
        Jugador jugador;
        List<HabilidadJugador> habilidadJugador;

        if (request == null) {
            return null;
        }


        habilidadJugador = request.habilidadesID().stream()
                .map(habilidadJugadorService::buscaPorID)
                .collect(Collectors.toList());


        jugador = Jugador.builder()
                .nombre(request.nombre())
                .fechaNacimiento(request.fechaNacimiento())
                .habilidades(habilidadJugador)
                .habilidadPiernas(request.habilidadPiernas())
                .posicionFavorita(posicionJuegoService.buscaPorID(request.posicionFavoritaID()))
                .posicionOpcional(posicionJuegoService.buscaPorID(request.posicionOpcionalID()))
                .build();
        return jugador;

    }
}
