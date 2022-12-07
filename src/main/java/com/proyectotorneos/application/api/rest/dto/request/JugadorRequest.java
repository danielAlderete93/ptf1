package com.proyectotorneos.application.api.rest.dto.request;

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
