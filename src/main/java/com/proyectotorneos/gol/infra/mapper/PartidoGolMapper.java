package com.proyectotorneos.gol.infra.mapper;

import com.proyectotorneos.gol.domain.model.PartidoGol;
import com.proyectotorneos.jugador.infra.mapper.JugadorMapper;
import com.proyectotorneos.posicion.infra.entities.PartidoGolEntity;
import org.springframework.stereotype.Component;

@Component
public class PartidoGolMapper {
    private final JugadorMapper jugadorMapper;

    public PartidoGolMapper(JugadorMapper jugadorMapper) {
        this.jugadorMapper = jugadorMapper;
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
