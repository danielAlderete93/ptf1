package com.proyectotorneos.competencia.infra.mapper;

import com.proyectotorneos.competencia.domain.model.CompetenciaGrupo;
import com.proyectotorneos.competencia.domain.model.CompetenciaLiga;
import com.proyectotorneos.competencia.infra.entities.CompetenciaGrupoEntity;
import com.proyectotorneos.competencia.infra.entities.CompetenciaLigaEntity;
import com.proyectotorneos.equipo.infra.mappers.EquipoMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component()
public class CompetenciaGrupoMapper extends CompetenciaMapper {
    private final CompetenciaLigaMapper competenciaLigaMapper;

    protected CompetenciaGrupoMapper(EquipoMapper equipoMapper, CompetenciaLigaMapper competenciaLigaMapper) {
        super(equipoMapper);
        this.competenciaLigaMapper = competenciaLigaMapper;
    }

    public CompetenciaGrupoEntity toEntity(CompetenciaGrupo competenciaGrupo) {

        if (null == competenciaGrupo) {
            return null;
        }

        return CompetenciaGrupoEntity.builder()
                .id(competenciaGrupo.getId())
                .nombre(competenciaGrupo.getNombre())
                .equipos(getEquipoEntities(competenciaGrupo))
                .grupos(getGruposEntities(competenciaGrupo))
                .build();
    }

    public CompetenciaGrupo toDomain(CompetenciaGrupoEntity entity) {
        if (null == entity) {
            return null;
        }

        return CompetenciaGrupo.builder()
                .id(entity.getId())
                .nombre(entity.getNombre())
                .equipos(getEquiposDomain(entity))
                .grupos(getGrupos(entity))
                .build();
    }

    private List<CompetenciaLiga> getGrupos(CompetenciaGrupoEntity entity) {
        List<CompetenciaLiga> grupos;
        if (null == entity.getGrupos()) {
            grupos = new ArrayList<>();
        } else {
            grupos = entity.getGrupos()
                    .stream()
                    .map(competenciaLigaMapper::toDomain)
                    .collect(Collectors.toList());
        }
        return grupos;
    }

    private List<CompetenciaLigaEntity> getGruposEntities(CompetenciaGrupo competenciaGrupo) {
        List<CompetenciaLigaEntity> gruposEntities;
        if (null == competenciaGrupo.getGrupos()) {
            gruposEntities = new ArrayList<>();
        } else {
            gruposEntities = competenciaGrupo.getGrupos()
                    .stream()
                    .map(competenciaLigaMapper::toEntity)
                    .collect(Collectors.toList());
        }
        return gruposEntities;
    }
}
