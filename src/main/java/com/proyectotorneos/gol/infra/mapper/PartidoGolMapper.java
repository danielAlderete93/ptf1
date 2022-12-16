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

        return PartidoGolEntity.builder()
                .id(gol.getId())
                .descripcion(gol.getDescripcion())
                .tiempo(gol.getTiempo())
                .jugador(jugadorMapper.toEntity(gol.getJugador()))
                .build();
    }

    public PartidoGol toDomain(PartidoGolEntity entity) {

        return PartidoGol.builder()
                .id(entity.getId())
                .tiempo(entity.getTiempo())
                .descripcion(entity.getDescripcion())
                .jugador(jugadorMapper.toDomain(entity.getJugador()))
                .build();
    }
}
