package com.proyectotorneos.competencia.infra.mapper;

import com.proyectotorneos.competencia.domain.model.CompetenciaLiga;
import com.proyectotorneos.competencia.infra.entities.CompetenciaLigaEntity;
import com.proyectotorneos.equipo.infra.mappers.EquipoMapper;
import com.proyectotorneos.fecha.domain.model.FechaCompetitiva;
import com.proyectotorneos.fecha.infra.entities.FechaCompetitivaEntity;
import com.proyectotorneos.fecha.infra.mapper.FechaCompetitivaMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class CompetenciaLigaMapper extends CompetenciaMapper {
    private final FechaCompetitivaMapper fechaCompetitivaMapper;

    public CompetenciaLigaMapper(EquipoMapper equipoMapper, FechaCompetitivaMapper fechaCompetitivaMapper) {
        super(equipoMapper);
        this.fechaCompetitivaMapper = fechaCompetitivaMapper;
    }

    public CompetenciaLigaEntity toEntity(CompetenciaLiga competenciaLiga) {

        if (null == competenciaLiga) {
            return null;
        }

        return CompetenciaLigaEntity.builder()
                .id(competenciaLiga.getId())
                .nombre(competenciaLiga.getNombre())
                .equipos(getEquipoEntities(competenciaLiga))
                .fechas(getFechaCompetitivaEntities(competenciaLiga))
                .build();
    }

    public CompetenciaLiga toDomain(CompetenciaLigaEntity entity) {
        if (null == entity) {
            return null;
        }

        return CompetenciaLiga.builder()
                .id(entity.getId())
                .nombre(entity.getNombre())
                .equipos(getEquiposDomain(entity))
                .fechas(getFechaCompetitivas(entity))
                .build();
    }

    private List<FechaCompetitivaEntity> getFechaCompetitivaEntities(CompetenciaLiga competenciaLiga) {
        List<FechaCompetitivaEntity> fechasEntities;
        if (null == competenciaLiga.getFechas()) {
            fechasEntities = new ArrayList<>();
        } else {
            fechasEntities = competenciaLiga.getFechas()
                    .stream()
                    .map(fechaCompetitivaMapper::toEntity)
                    .collect(Collectors.toList())
            ;
        }
        return fechasEntities;
    }


    private List<FechaCompetitiva> getFechaCompetitivas(CompetenciaLigaEntity entity) {
        List<FechaCompetitiva> fechas;
        if (null == entity.getFechas()) {
            fechas = new ArrayList<>();
        } else {
            fechas = entity.getFechas()
                    .stream()
                    .map(fechaCompetitivaMapper::toDomain)
                    .collect(Collectors.toList())
            ;
        }
        return fechas;
    }


}
