package com.proyectotorneos.fecha.infra.mapper;

import com.proyectotorneos.fecha.domain.model.FechaCompetitiva;
import com.proyectotorneos.fecha.infra.entities.FechaCompetitivaEntity;
import com.proyectotorneos.gol.infra.entities.PartidoEntity;
import com.proyectotorneos.partido.domain.model.Partido;
import com.proyectotorneos.partido.infra.mapper.PartidoMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class FechaCompetitivaMapper {

    private final PartidoMapper partidoMapper;


    public FechaCompetitivaMapper(PartidoMapper partidoMapper) {
        this.partidoMapper = partidoMapper;
    }

    public FechaCompetitivaEntity toEntity(FechaCompetitiva fechaCompetitiva) {
        List<PartidoEntity> partidoEntityList;

        if (fechaCompetitiva == null) {
            return null;
        }

        if (fechaCompetitiva.getPartidos() == null) {
            partidoEntityList = new ArrayList<>();
        } else {
            partidoEntityList = fechaCompetitiva.getPartidos().stream().map(partidoMapper::toEntity).toList();
        }


        return FechaCompetitivaEntity.builder()
                .nroFecha(fechaCompetitiva.getNroFecha())
                .partidos(partidoEntityList)
                .build();
    }


    public FechaCompetitiva toDomain(FechaCompetitivaEntity entity) {
        List<Partido> partidoList;

        if (null == entity) {
            return null;
        }


        if (entity.getPartidos() == null) {
            partidoList = new ArrayList<>();
        } else {
            partidoList = entity.getPartidos().stream()
                    .map(partidoMapper::toDomain)
                    .toList()
            ;
        }

        return FechaCompetitiva.builder()
                .id(entity.getId())
                .nroFecha(entity.getNroFecha())
                .partidos(partidoList)
                .build();
    }
}
