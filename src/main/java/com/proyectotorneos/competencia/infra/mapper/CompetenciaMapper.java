package com.proyectotorneos.competencia.infra.mapper;

import com.proyectotorneos.competencia.domain.model.Competencia;
import com.proyectotorneos.competencia.infra.entities.CompetenciaEntity;
import com.proyectotorneos.equipo.domain.model.Equipo;
import com.proyectotorneos.equipo.infra.entities.EquipoEntity;
import com.proyectotorneos.equipo.infra.mappers.EquipoMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public abstract class CompetenciaMapper {
    private final EquipoMapper equipoMapper;

    protected CompetenciaMapper(EquipoMapper equipoMapper) {
        this.equipoMapper = equipoMapper;

    }

    protected List<EquipoEntity> getEquipoEntities(Competencia competencia) {
        List<EquipoEntity> equipoEntities;
        if (null == competencia.getEquipos()) {
            equipoEntities = new ArrayList<>();
        } else {
            equipoEntities = competencia.getEquipos().stream()
                    .map(equipoMapper::toEntity)
                    .collect(Collectors.toList())
            ;
        }
        return equipoEntities;
    }

    protected List<Equipo> getEquiposDomain(CompetenciaEntity entity) {
        List<Equipo> equipos;
        if (null == entity.getEquipos()) {
            equipos = new ArrayList<>();
        } else {
            equipos = entity.getEquipos().stream()
                    .map(equipoMapper::toDomain)
                    .collect(Collectors.toList())
            ;
        }
        return equipos;
    }


}
