package com.proyectotorneos.jugador.app.api.rest.dto;

import java.time.LocalDate;
import java.util.List;

public record JugadorRequest(String nombre,
                             LocalDate fechaNacimiento,
                             Integer posicionFavoritaID,
                             Integer posicionOpcionalID,
                             String habilidadPiernas,
                             List<Integer> habilidadesID,
                             Integer equipoID) {


}
