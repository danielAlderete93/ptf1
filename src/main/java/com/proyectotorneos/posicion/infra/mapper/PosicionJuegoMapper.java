package com.proyectotorneos.posicion.infra.mapper;

import com.proyectotorneos.posicion.domain.model.PosicionJuego;
import com.proyectotorneos.partido.infra.entities.PosicionJuegoEntity;
import org.springframework.stereotype.Component;

@Component
public class PosicionJuegoMapper {
    public PosicionJuegoEntity toEntity(PosicionJuego posicionJuego) {
        PosicionJuegoEntity entity = new PosicionJuegoEntity();
        entity.setId(posicionJuego.getId());
        entity.setDescripcion(posicionJuego.getDescripcion());
        entity.setNombre(posicionJuego.getNombre());
        return entity;
    }

    public PosicionJuego toDomain(PosicionJuegoEntity posicionJuegoEntity) {
        PosicionJuego posicionJuego = new PosicionJuego();
        posicionJuego.setId(posicionJuegoEntity.getId());
        posicionJuego.setDescripcion(posicionJuegoEntity.getDescripcion());
        posicionJuego.setNombre(posicionJuegoEntity.getNombre());
        return posicionJuego;
    }
}
