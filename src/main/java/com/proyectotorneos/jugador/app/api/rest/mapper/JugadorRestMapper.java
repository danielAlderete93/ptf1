package com.proyectotorneos.jugador.app.api.rest.mapper;

import com.proyectotorneos.posicion.app.api.rest.mapper.PosicionJuegoRestMapper;
import com.proyectotorneos.habilidad.app.api.rest.mapper.HabilidadJugadorRestMapper;
import com.proyectotorneos.jugador.app.api.rest.dto.JugadorRequest;
import com.proyectotorneos.habilidad.app.api.rest.dto.HabilidadJugadorResponse;
import com.proyectotorneos.jugador.app.api.rest.dto.JugadorResponse;
import com.proyectotorneos.habilidad.domain.model.HabilidadJugador;
import com.proyectotorneos.jugador.domain.model.Jugador;
import com.proyectotorneos.posicion.domain.model.PosicionJuego;
import com.proyectotorneos.habilidad.domain.port.services.HabilidadJugadorService;
import com.proyectotorneos.posicion.domain.port.services.PosicionJuegoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
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
                posicionJuegoRestMapper.toResponse(jugador.getPosicionFavorita()),
                posicionJuegoRestMapper.toResponse(jugador.getPosicionOpcional()),
                jugador.getHabilidadPiernas(),
                habilidades
        );

    }

    public Jugador toDomain(JugadorRequest request) {
        Jugador jugador;
        PosicionJuego posicionJuegoFavorita;
        PosicionJuego posicionJuegoOpcional;
        List<HabilidadJugador> habilidadJugador;


        if (request == null) {
            return null;
        }

        if (request.habilidadesID().isEmpty()) {
            habilidadJugador = new ArrayList<>();
        } else {
            habilidadJugador = request.habilidadesID().stream()
                    .map(habilidadJugadorService::buscaPorID)
                    .collect(Collectors.toList());
        }


        posicionJuegoFavorita = posicionJuegoService.buscaPorID(request.posicionFavoritaID());
        posicionJuegoOpcional = posicionJuegoService.buscaPorID(request.posicionOpcionalID());

        jugador = Jugador.builder()
                .nombre(request.nombre())
                .fechaNacimiento(request.fechaNacimiento())
                .habilidades(habilidadJugador)
                .habilidadPiernas(request.habilidadPiernas())
                .posicionFavorita(posicionJuegoFavorita)
                .posicionOpcional(posicionJuegoOpcional)
                .build();
        return jugador;

    }
}
