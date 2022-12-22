package com.proyectotorneos.actuacion.infra.mapper;

import com.proyectotorneos.actuacion.domain.model.ActuacionEquipo;
import com.proyectotorneos.actuacion.infra.entities.ActuacionEquipoEntity;
import com.proyectotorneos.equipo.domain.model.Equipo;
import com.proyectotorneos.equipo.infra.entities.EquipoEntity;
import com.proyectotorneos.equipo.infra.mappers.EquipoMapper;
import com.proyectotorneos.gol.domain.model.PartidoGol;
import com.proyectotorneos.gol.infra.mapper.PartidoGolMapper;
import com.proyectotorneos.jugador.domain.model.Jugador;
import com.proyectotorneos.jugador.infra.entities.JugadorEntity;
import com.proyectotorneos.jugador.infra.mapper.JugadorMapper;
import com.proyectotorneos.posicion.infra.entities.PartidoGolEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ActuacionMapper {

    private final EquipoMapper equipoMapper;
    private final JugadorMapper jugadorMapper;

    private final PartidoGolMapper partidoGolMapper;

    public ActuacionMapper(EquipoMapper equipoMapper, JugadorMapper jugadorMapper, PartidoGolMapper partidoGolMapper) {
        this.equipoMapper = equipoMapper;
        this.jugadorMapper = jugadorMapper;
        this.partidoGolMapper = partidoGolMapper;
    }

    public ActuacionEquipoEntity toEntity(ActuacionEquipo domain) {
        EquipoEntity equipoEntity;
        List<JugadorEntity> jugadorEntityList;
        List<PartidoGolEntity> partidoGolEntities;

        jugadorEntityList = getJugadorEntities(domain);

        partidoGolEntities = getPartidoGolEntities(domain);

        equipoEntity = equipoMapper.toEntity(domain.getEquipo());

        return ActuacionEquipoEntity.builder()
                .id(domain.getId())
                .jugadores(jugadorEntityList)
                .goles(partidoGolEntities)
                .equipo(equipoEntity)
                .build();
    }


    public ActuacionEquipo toDomain(ActuacionEquipoEntity entity) {
        Equipo equipo;
        List<Jugador> jugadores;
        List<PartidoGol> partidoGoles;


        jugadores = getJugadores(entity);

        equipo = equipoMapper.toDomain(entity.getEquipo());

        partidoGoles = getGoles(entity);


        return ActuacionEquipo.builder()
                .id(entity.getId())
                .jugadoresParticipante(jugadores)
                .equipo(equipo)
                .goles(partidoGoles)
                .build();
    }

    private List<Jugador> getJugadores(ActuacionEquipoEntity entity) {
        List<Jugador> jugadores;
        jugadores = entity.getJugadores().stream().map(jugadorMapper::toDomain).toList();
        return jugadores;
    }

    private List<PartidoGol> getGoles(ActuacionEquipoEntity entity) {
        List<PartidoGol> partidoGoles;
        partidoGoles = entity.getGoles().stream().map(partidoGolMapper::toDomain).toList();
        return partidoGoles;
    }

    private List<PartidoGolEntity> getPartidoGolEntities(ActuacionEquipo domain) {
        List<PartidoGolEntity> partidoGolEntities;
        if (null != domain.getGoles()) {
            partidoGolEntities = domain.getGoles().stream().map(partidoGolMapper::toEntity).toList();
        } else {
            partidoGolEntities = new ArrayList<>();
        }
        return partidoGolEntities;
    }

    private List<JugadorEntity> getJugadorEntities(ActuacionEquipo domain) {
        List<JugadorEntity> jugadorEntityList;
        jugadorEntityList = domain.getJugadoresParticipante().stream().map(jugadorMapper::toEntity).toList();
        return jugadorEntityList;
    }


}
