package com.proyectotorneos.jugador.app.api.rest.dto;

import com.proyectotorneos.habilidad.app.api.rest.dto.HabilidadJugadorResponse;
import com.proyectotorneos.posicion.app.api.rest.dto.PosicionJuegoResponse;

import java.util.Date;
import java.util.List;


public record JugadorResponse(
        Integer id,
        String nombre,
        Date fechaNacimiento,
        PosicionJuegoResponse posicionFavorita,
        PosicionJuegoResponse posicionOpcional,
        String habilidadPiernas,
        List<HabilidadJugadorResponse> habilidades
) {



}
