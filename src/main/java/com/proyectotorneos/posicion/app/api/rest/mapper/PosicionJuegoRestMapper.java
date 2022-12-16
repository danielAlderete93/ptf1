package com.proyectotorneos.posicion.app.api.rest.mapper;

import com.proyectotorneos.posicion.app.api.rest.dto.PosicionJuegoRequest;
import com.proyectotorneos.posicion.app.api.rest.dto.PosicionJuegoResponse;
import com.proyectotorneos.posicion.domain.model.PosicionJuego;
import org.springframework.stereotype.Component;

@Component
public class PosicionJuegoRestMapper {

    public PosicionJuegoResponse toResponse(PosicionJuego posicionJuego) {

        if (posicionJuego == null) {
            return null;
        }

        return new PosicionJuegoResponse(
                posicionJuego.getId(),
                posicionJuego.getNombre(),
                posicionJuego.getDescripcion()
        );
    }

    public PosicionJuego toDomain(PosicionJuegoRequest request) {
        if (request == null) {
            return null;
        }

        return PosicionJuego.builder()
                .nombre(request.nombre())
                .descripcion(request.descripcion())
                .build();
    }
}
