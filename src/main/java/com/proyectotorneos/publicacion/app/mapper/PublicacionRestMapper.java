package com.proyectotorneos.publicacion.app.mapper;

import com.proyectotorneos.publicacion.app.dto.PublicacionRequest;
import com.proyectotorneos.publicacion.app.dto.PublicacionResponse;
import com.proyectotorneos.publicacion.domain.model.Publicacion;
import org.springframework.stereotype.Component;

@Component
public class PublicacionRestMapper {
    public PublicacionResponse toResponse(Publicacion publicacion) {
        if (publicacion == null) {
            return null;
        }

        return new PublicacionResponse(
                publicacion.getId(),
                publicacion.getTitulo(),
                publicacion.getDescripcion()
        );
    }

    public Publicacion toDomain(PublicacionRequest request) {

        return Publicacion.builder()
                .titulo(request.titulo())
                .descripcion(request.descripcion())
                .build();
    }
}
