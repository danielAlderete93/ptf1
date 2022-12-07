package com.proyectotorneos.infra.mappers;

import com.proyectotorneos.domain.model.Equipo;
import com.proyectotorneos.domain.model.Jugador;
import com.proyectotorneos.infra.entities.EquipoEntity;
import com.proyectotorneos.infra.entities.JugadorEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class EquipoMapper {
    private final JugadorMapper jugadorMapper;

    public EquipoMapper() {
        this.jugadorMapper = new JugadorMapper();
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

        if(equipo.getJugadores() == null){
            jugadorEntityList = new ArrayList<>();
        }else{
            jugadorEntityList = equipo.getJugadores().stream().map(jugadorMapper::toEntity).toList();
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

        if(equipoEntity.getJugadores() == null){
          jugadorList = new ArrayList<>();
        }else{
            jugadorList = equipoEntity.getJugadores().stream().map(jugadorMapper::toDomain).toList();
        }


        equipo.setJugadores(jugadorList);

        return equipo;
    }



}
