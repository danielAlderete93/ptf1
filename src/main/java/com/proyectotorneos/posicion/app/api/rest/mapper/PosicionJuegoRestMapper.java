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
        PosicionJuego posicionJuego = new PosicionJuego();

        if (request == null) {
            return null;
        }


        posicionJuego.setDescripcion(request.descripcion());
        posicionJuego.setNombre(request.nombre());

        return posicionJuego;
    }
}
