package com.proyectotorneos.jugador.app.api.rest.dto;

import java.util.Date;
import java.util.List;

public record JugadorRequest(String nombre,
                             Date fechaNacimiento,
                             Integer posicionFavoritaID,
                             Integer posicionOpcionalID,
                             String habilidadPiernas,
                             List<Integer> habilidadesID,
                             Integer equipoID) {


}
