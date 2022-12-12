package com.proyectotorneos.equipo.infra.mappers;

import com.proyectotorneos.equipo.domain.model.Equipo;
import com.proyectotorneos.jugador.domain.model.Jugador;
import com.proyectotorneos.equipo.infra.entities.EquipoEntity;
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

    @SuppressWarnings("DuplicatedCode")
    public EquipoEntity toEntity(Equipo equipo) {
        EquipoEntity entity;
        List<JugadorEntity> jugadorEntityList;

        if (equipo == null) {
            return null;
        }

        entity = new EquipoEntity();
        entity.setId(equipo.getId());
        entity.setNombre(equipo.getNombre());
        entity.setUrlEscudo(equipo.getUrlEscudo());
        entity.setUrlPlantel(equipo.getUrlPlantel());

        if (equipo.getJugadores() == null) {
            jugadorEntityList = new ArrayList<>();
        } else {
            jugadorEntityList = equipo.getJugadores().stream()
                    .map(jugadorMapper::toEntity)
                    .toList()
            ;
        }


        entity.setJugadores(jugadorEntityList);

        return entity;
    }

    @SuppressWarnings("DuplicatedCode")
    public Equipo toDomain(EquipoEntity equipoEntity) {
        Equipo equipo = new Equipo();
        List<Jugador> jugadorList;

        if (equipoEntity == null) {
            return null;
        }


        equipo.setId(equipoEntity.getId());
        equipo.setNombre(equipoEntity.getNombre());
        equipo.setUrlEscudo(equipoEntity.getUrlEscudo());
        equipo.setUrlPlantel(equipoEntity.getUrlPlantel());

        if (equipoEntity.getJugadores() == null) {
            jugadorList = new ArrayList<>();
        } else {
            jugadorList = equipoEntity.getJugadores().stream()
                    .map(jugadorMapper::toDomain)
                    .collect(Collectors.toList())
            ;
        }


        equipo.setJugadores(jugadorList);

        return equipo;
    }


}
