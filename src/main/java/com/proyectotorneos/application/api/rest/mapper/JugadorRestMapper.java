package com.proyectotorneos.application.api.rest.mapper;

import com.proyectotorneos.application.api.rest.dto.request.JugadorRequest;
import com.proyectotorneos.application.api.rest.dto.response.HabilidadJugadorResponse;
import com.proyectotorneos.application.api.rest.dto.response.JugadorResponse;
import com.proyectotorneos.domain.model.HabilidadJugador;
import com.proyectotorneos.domain.model.Jugador;
import com.proyectotorneos.domain.model.PosicionJuego;
import com.proyectotorneos.domain.port.service.HabilidadJugadorService;
import com.proyectotorneos.domain.port.service.PosicionJuegoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

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

        habilidades = jugador.getHabilidades().stream().map(habilidadJugadorRestMapper::toResponse).toList();

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
        //TODO:Refactor ojota
        if (request.habilidadesID().isEmpty()) {
            habilidadJugador = new ArrayList<>();
        } else {
            habilidadJugador = request.habilidadesID().stream().map(habilidadJugadorService::buscaPorID).toList();
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
