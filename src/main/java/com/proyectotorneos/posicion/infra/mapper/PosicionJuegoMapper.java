package com.proyectotorneos.posicion.infra.mapper;

import com.proyectotorneos.partido.infra.entities.PosicionJuegoEntity;
import com.proyectotorneos.posicion.domain.model.PosicionJuego;
import org.springframework.stereotype.Component;

@Component
public class PosicionJuegoMapper {
    public PosicionJuegoEntity toEntity(PosicionJuego posicionJuego) {
        return PosicionJuegoEntity.builder()
                .id(posicionJuego.getId())
                .descripcion(posicionJuego.getDescripcion())
                .nombre(posicionJuego.getNombre())
                .build();
    }

    public PosicionJuego toDomain(PosicionJuegoEntity entity) {
        return PosicionJuego.builder()
                .id(entity.getId())
                .descripcion(entity.getDescripcion())
                .nombre(entity.getNombre())
                .build();
    }
}
