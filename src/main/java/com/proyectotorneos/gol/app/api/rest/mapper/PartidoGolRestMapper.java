package com.proyectotorneos.gol.app.api.rest.mapper;

import com.proyectotorneos.gol.app.api.rest.dto.PartidoGolRequest;
import com.proyectotorneos.gol.app.api.rest.dto.PartidoGolResponse;
import com.proyectotorneos.gol.domain.model.PartidoGol;
import com.proyectotorneos.jugador.domain.port.services.JugadorService;
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

        if (request == null) {
            return null;
        }

        return PartidoGol.builder()
                .descripcion(request.descripcion())
                .tiempo(request.tiempo())
                .jugador(jugadorService.buscaPorID(request.jugadorID()))
                .build();

    }
}
