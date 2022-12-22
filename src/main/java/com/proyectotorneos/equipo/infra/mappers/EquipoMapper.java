package com.proyectotorneos.equipo.infra.mappers;

import com.proyectotorneos.equipo.domain.model.Equipo;
import com.proyectotorneos.equipo.infra.entities.EquipoEntity;
import com.proyectotorneos.jugador.domain.model.Jugador;
import com.proyectotorneos.jugador.infra.entities.JugadorEntity;
import com.proyectotorneos.jugador.infra.mapper.JugadorMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class EquipoMapper {
    private final JugadorMapper jugadorMapper;

    public EquipoMapper(JugadorMapper jugadorMapper) {
        this.jugadorMapper = jugadorMapper;
    }


    public EquipoEntity toEntity(Equipo equipo) {

        List<JugadorEntity> jugadorEntityList;

        if (equipo == null) {
            return null;
        }

        jugadorEntityList = getJugadorEntities(equipo);


        return EquipoEntity.builder()
                .id(equipo.getId())
                .nombre(equipo.getNombre())
                .urlEscudo(equipo.getUrlEscudo())
                .urlPlantel(equipo.getUrlPlantel())
                .jugadores(jugadorEntityList)
                .build();

    }


    public Equipo toDomain(EquipoEntity equipoEntity) {
        List<Jugador> jugadorList;

        if (equipoEntity == null) {
            return null;
        }

        jugadorList = getJugadors(equipoEntity);


        return Equipo.builder()
                .id(equipoEntity.getId())
                .nombre(equipoEntity.getNombre())
                .urlEscudo(equipoEntity.getUrlEscudo())
                .urlPlantel(equipoEntity.getUrlPlantel())
                .jugadores(jugadorList)
                .build();
    }

    private List<JugadorEntity> getJugadorEntities(Equipo equipo) {
        List<JugadorEntity> jugadorEntityList;
        if (equipo.getJugadores() == null) {
            jugadorEntityList = new ArrayList<>();
        } else {
            jugadorEntityList = equipo.getJugadores().stream()
                    .map(jugadorMapper::toEntity)
                    .toList()
            ;
        }
        return jugadorEntityList;
    }

    private List<Jugador> getJugadors(EquipoEntity equipoEntity) {
        List<Jugador> jugadorList;
        if (equipoEntity.getJugadores() == null) {
            jugadorList = new ArrayList<>();
        } else {
            jugadorList = equipoEntity.getJugadores().stream()
                    .map(jugadorMapper::toDomain)
                    .collect(Collectors.toList())
            ;
        }
        return jugadorList;
    }


}
