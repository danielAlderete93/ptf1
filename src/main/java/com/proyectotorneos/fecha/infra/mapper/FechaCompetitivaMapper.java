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

        partidoEntityList = getPartidoEntities(fechaCompetitiva);

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

        partidoList = getPartidos(entity);

        return FechaCompetitiva.builder()
                .id(entity.getId())
                .nroFecha(entity.getNroFecha())
                .partidos(partidoList)
                .build();
    }

    private List<Partido> getPartidos(FechaCompetitivaEntity entity) {
        List<Partido> partidoList;
        if (entity.getPartidos() == null) {
            partidoList = new ArrayList<>();
        } else {
            partidoList = entity.getPartidos().stream()
                    .map(partidoMapper::toDomain)
                    .toList()
            ;

        }
        return partidoList;
    }

    private List<PartidoEntity> getPartidoEntities(FechaCompetitiva fechaCompetitiva) {
        List<PartidoEntity> partidoEntityList;
        if (fechaCompetitiva.getPartidos() == null) {
            partidoEntityList = new ArrayList<>();
        } else {
            partidoEntityList = fechaCompetitiva.getPartidos().stream().map(partidoMapper::toEntity).toList();
        }
        return partidoEntityList;
    }
}
