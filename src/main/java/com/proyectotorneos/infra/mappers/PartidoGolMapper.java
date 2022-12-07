package com.proyectotorneos.infra.mappers;

import com.proyectotorneos.domain.model.PartidoGol;
import com.proyectotorneos.infra.entities.PartidoGolEntity;
import org.springframework.stereotype.Component;

@Component
public class PartidoGolMapper {
    private final JugadorMapper jugadorMapper;

    public PartidoGolMapper() {
        this.jugadorMapper = new JugadorMapper();
    }

    public PartidoGolEntity toEntity(PartidoGol gol) {
        PartidoGolEntity entity = new PartidoGolEntity();

        entity.setId(gol.getId());
        entity.setDescripcion(gol.getDescripcion());
        entity.setTiempo(gol.getTiempo());
        entity.setJugador(jugadorMapper.toEntity(gol.getJugador()));

        return entity;
    }

    public PartidoGol toDomain(PartidoGolEntity entity) {
        PartidoGol gol = new PartidoGol();

        gol.setId(entity.getId());
        gol.setDescripcion(entity.getDescripcion());
        gol.setTiempo(entity.getTiempo());
        gol.setJugador(jugadorMapper.toDomain(entity.getJugador()));

        return gol;
    }
}
