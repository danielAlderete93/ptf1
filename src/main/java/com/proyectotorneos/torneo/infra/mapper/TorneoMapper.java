package com.proyectotorneos.torneo.infra.mapper;

import com.proyectotorneos.competencia.domain.model.Competencia;
import com.proyectotorneos.competencia.domain.model.CompetenciaFaseEliminatoria;
import com.proyectotorneos.competencia.domain.model.CompetenciaGrupo;
import com.proyectotorneos.competencia.domain.model.CompetenciaLiga;
import com.proyectotorneos.competencia.infra.entities.CompetenciaEntity;
import com.proyectotorneos.competencia.infra.entities.CompetenciaFaseEliminatoriaEntity;
import com.proyectotorneos.competencia.infra.entities.CompetenciaGrupoEntity;
import com.proyectotorneos.competencia.infra.entities.CompetenciaLigaEntity;
import com.proyectotorneos.competencia.infra.mapper.CompetenciaFaseEliminatoriaMapper;
import com.proyectotorneos.competencia.infra.mapper.CompetenciaGrupoMapper;
import com.proyectotorneos.competencia.infra.mapper.CompetenciaLigaMapper;
import com.proyectotorneos.torneo.domain.model.Torneo;
import com.proyectotorneos.torneo.infra.entities.TorneoEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TorneoMapper {
    private final CompetenciaLigaMapper ligaMapper;
    private final CompetenciaGrupoMapper grupoMapper;
    private final CompetenciaFaseEliminatoriaMapper eliminatoriaMapper;

    @Autowired
    public TorneoMapper(CompetenciaLigaMapper ligaMapper, CompetenciaGrupoMapper grupoMapper, CompetenciaFaseEliminatoriaMapper eliminatoriaMapper) {
        this.ligaMapper = ligaMapper;
        this.grupoMapper = grupoMapper;
        this.eliminatoriaMapper = eliminatoriaMapper;
    }


    public TorneoEntity toEntity(Torneo torneo) {
        CompetenciaEntity competencia = null;

        if (torneo.getCompetencia() instanceof CompetenciaLiga competenciaLiga) {
            competencia = ligaMapper.toEntity(competenciaLiga);
        }
        if (torneo.getCompetencia() instanceof CompetenciaGrupo competenciaGrupo) {
            competencia = grupoMapper.toEntity(competenciaGrupo);
        }
        if (torneo.getCompetencia() instanceof CompetenciaFaseEliminatoria competenciaFaseEliminatoria) {
            competencia = eliminatoriaMapper.toEntity(competenciaFaseEliminatoria);
        }


        return TorneoEntity.builder()
                .id(torneo.getId())
                .nombre(torneo.getNombre())
                .descripcion(torneo.getDescripcion())
                .competencia(competencia)
                .build();
    }

    public Torneo toDomain(TorneoEntity entity) {
        Competencia competencia = null;

        if (entity.getCompetencia() instanceof CompetenciaLigaEntity competenciaLiga) {
            competencia = ligaMapper.toDomain(competenciaLiga);
        }
        if (entity.getCompetencia() instanceof CompetenciaGrupoEntity competenciaGrupo) {
            competencia = grupoMapper.toDomain(competenciaGrupo);
        }
        if (entity.getCompetencia() instanceof CompetenciaFaseEliminatoriaEntity competenciaFaseEliminatoria) {
            competencia = eliminatoriaMapper.toDomain(competenciaFaseEliminatoria);
        }


        return Torneo.builder()
                .id(entity.getId())
                .nombre(entity.getNombre())
                .descripcion(entity.getDescripcion())
                .competencia(competencia)
                .build();
    }
}
