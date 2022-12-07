package com.proyectotorneos.application.api.rest.mapper;

import com.proyectotorneos.application.api.rest.dto.request.PartidoGolRequest;
import com.proyectotorneos.application.api.rest.dto.response.PartidoGolResponse;
import com.proyectotorneos.domain.model.PartidoGol;
import com.proyectotorneos.domain.port.service.JugadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PartidoGolRestMapper {

    private final JugadorService jugadorService;

    @Autowired
    public PartidoGolRestMapper(JugadorService jugadorService) {
        this.jugadorService = jugadorService;
    }

    public PartidoGolResponse toResponse(PartidoGol partidoGol) {
        if (partidoGol == null) {
            return null;
        }

        return new PartidoGolResponse(
                partidoGol.getDescripcion(),
                partidoGol.getTiempo(),
                partidoGol.getJugador().getNombre()
        );

    }

    public PartidoGol toDomain(PartidoGolRequest request) {
        PartidoGol partidoGol = new PartidoGol();
        if (request == null) {
            return null;
        }

        partidoGol.setDescripcion(request.descripcion());
        partidoGol.setTiempo(request.tiempo());
        partidoGol.setJugador(jugadorService.buscaPorID(request.jugadorID()));


        return partidoGol;

    }
}
