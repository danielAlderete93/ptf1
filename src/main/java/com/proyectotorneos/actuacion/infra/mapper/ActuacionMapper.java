package com.proyectotorneos.actuacion.infra.mapper;

import com.proyectotorneos.actuacion.domain.model.ActuacionEquipo;
import com.proyectotorneos.jugador.domain.model.Jugador;
import com.proyectotorneos.gol.domain.model.PartidoGol;
import com.proyectotorneos.actuacion.infra.entities.ActuacionEquipoEntity;
import com.proyectotorneos.jugador.infra.entities.JugadorEntity;
import com.proyectotorneos.posicion.infra.entities.PartidoGolEntity;
import com.proyectotorneos.equipo.infra.mappers.EquipoMapper;
import com.proyectotorneos.jugador.infra.mapper.JugadorMapper;
import com.proyectotorneos.gol.infra.mapper.PartidoGolMapper;
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
        ActuacionEquipoEntity entity = new ActuacionEquipoEntity();

        List<JugadorEntity> jugadorEntityList;
        List<PartidoGolEntity> partidoGolEntities;

        entity.setId(domain.getId());

        jugadorEntityList = domain.getJugadoresParticipante().stream().map(jugadorMapper::toEntity).toList();
        entity.setJugadores(jugadorEntityList);

        entity.setEquipo(equipoMapper.toEntity(domain.getEquipo()));

        if( null != domain.getGoles()){
            partidoGolEntities = domain.getGoles().stream().map(partidoGolMapper::toEntity).toList();
        }else{
            partidoGolEntities = new ArrayList<>();
        }




        entity.setGoles(partidoGolEntities);


        return entity;
    }


    public ActuacionEquipo toDomain(ActuacionEquipoEntity entity) {
        ActuacionEquipo domain = new ActuacionEquipo();
        List<Jugador> jugadores;
        List<PartidoGol> partidoGoles;

        domain.setId(entity.getId());

        jugadores = entity.getJugadores().stream().map(jugadorMapper::toDomain).toList();
        domain.setJugadoresParticipante(jugadores);

        domain.setEquipo(equipoMapper.toDomain(entity.getEquipo()));

        partidoGoles = entity.getGoles().stream().map(partidoGolMapper::toDomain).toList();
        domain.setGoles(partidoGoles);


        return domain;
    }

}
