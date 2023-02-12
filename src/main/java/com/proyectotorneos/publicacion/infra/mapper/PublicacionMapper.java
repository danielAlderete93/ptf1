package com.proyectotorneos.publicacion.infra.mapper;

import com.proyectotorneos.publicacion.domain.model.Publicacion;
import com.proyectotorneos.publicacion.infra.entities.PublicacionEntity;
import org.springframework.stereotype.Component;

@Component
public class PublicacionMapper {
    public PublicacionEntity toEntity(Publicacion publicacion) {
        return PublicacionEntity.builder()
                .id(publicacion.getId())
                .descripcion(publicacion.getDescripcion())
                .titulo(publicacion.getTitulo())
                .build();
    }

    public Publicacion toDomain(PublicacionEntity entity) {
        return Publicacion.builder()
                .id(entity.getId())
                .descripcion(entity.getDescripcion())
                .titulo(entity.getTitulo())
                .build();
    }
}
