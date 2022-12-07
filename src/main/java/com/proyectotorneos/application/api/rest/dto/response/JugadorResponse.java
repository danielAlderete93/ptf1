package com.proyectotorneos.application.api.rest.dto.response;

import lombok.Getter;
import lombok.Setter;

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
