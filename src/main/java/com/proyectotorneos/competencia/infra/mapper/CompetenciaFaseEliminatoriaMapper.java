package com.proyectotorneos.competencia.infra.mapper;

import com.proyectotorneos.competencia.domain.model.CompetenciaFaseEliminatoria;
import com.proyectotorneos.competencia.infra.entities.CompetenciaFaseEliminatoriaEntity;
import com.proyectotorneos.equipo.infra.mappers.EquipoMapper;
import com.proyectotorneos.fecha.infra.mapper.FechaCompetitivaMapper;
import org.springframework.stereotype.Component;

@Component()
public class CompetenciaFaseEliminatoriaMapper extends CompetenciaMapper {
    private final FechaCompetitivaMapper fechaCompetitivaMapper;

    public CompetenciaFaseEliminatoriaMapper(EquipoMapper equipoMapper, FechaCompetitivaMapper fechaCompetitivaMapper) {
        super(equipoMapper);
        this.fechaCompetitivaMapper = fechaCompetitivaMapper;
    }

    public CompetenciaFaseEliminatoriaEntity toEntity(CompetenciaFaseEliminatoria competenciaFaseEliminatoria) {
        if (null == competenciaFaseEliminatoria) {
            return null;
        }

        return CompetenciaFaseEliminatoriaEntity.builder()
                .id(competenciaFaseEliminatoria.getId())
                .nombre(competenciaFaseEliminatoria.getNombre())
                .fecha(fechaCompetitivaMapper.toEntity(competenciaFaseEliminatoria.getFecha()))
                .equipos(getEquipoEntities(competenciaFaseEliminatoria))
                .proximaFasePerdedora(toEntity(competenciaFaseEliminatoria.getProximaFasePerdedora()))
                .proximaFaseGanadora(toEntity(competenciaFaseEliminatoria.getProximaFaseGanadora()))
                .build();
    }

    public CompetenciaFaseEliminatoria toDomain(CompetenciaFaseEliminatoriaEntity entity) {
        if (null == entity) {
            return null;
        }

        return CompetenciaFaseEliminatoria.builder()
                .id(entity.getId())
                .nombre(entity.getNombre())
                .fecha(fechaCompetitivaMapper.toDomain(entity.getFecha()))
                .equipos(getEquiposDomain(entity))
                .proximaFasePerdedora(toDomain(entity.getProximaFasePerdedora()))
                .proximaFaseGanadora(toDomain(entity.getProximaFaseGanadora()))
                .build();
    }
}
