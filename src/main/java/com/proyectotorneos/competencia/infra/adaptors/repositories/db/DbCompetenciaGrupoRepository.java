package com.proyectotorneos.competencia.infra.adaptors.repositories.db;

import com.proyectotorneos.competencia.domain.model.CompetenciaGrupo;
import com.proyectotorneos.competencia.domain.port.repositories.CompetenciaRepository;
import com.proyectotorneos.competencia.infra.adaptors.repositories.CompetenciaRepositoryJPA;
import com.proyectotorneos.competencia.infra.entities.CompetenciaEntity;
import com.proyectotorneos.competencia.infra.entities.CompetenciaGrupoEntity;
import com.proyectotorneos.competencia.infra.mapper.CompetenciaGrupoMapper;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class DbCompetenciaGrupoRepository implements CompetenciaRepository<CompetenciaGrupo> {
    private final CompetenciaGrupoMapper competenciaGrupoMapper;
    private final CompetenciaRepositoryJPA competenciaRepositoryJPA;

    public DbCompetenciaGrupoRepository(CompetenciaGrupoMapper competenciaGrupoMapper, CompetenciaRepositoryJPA competenciaRepositoryJPA) {
        this.competenciaGrupoMapper = competenciaGrupoMapper;
        this.competenciaRepositoryJPA = competenciaRepositoryJPA;
    }

    @Override
    public void alta(CompetenciaGrupo competencia) {
        competenciaRepositoryJPA.saveAndFlush(competenciaGrupoMapper.toEntity(competencia));
    }

    @Override
    public CompetenciaGrupo buscaPorID(Integer id) {
        CompetenciaEntity entity;
        entity = competenciaRepositoryJPA.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Recurso no encontrado"));

        if (entity instanceof CompetenciaGrupoEntity competenciaGrupoEntity) {
            return competenciaGrupoMapper.toDomain(competenciaGrupoEntity);

        }

        throw new ResourceNotFoundException("Recurso no encontrado");
    }

    @Override
    public List<CompetenciaGrupo> getAll() {
        List<CompetenciaGrupo> competenciaGrupos;

        competenciaGrupos = competenciaRepositoryJPA.findAll()
                .stream()
                .filter(CompetenciaGrupoEntity.class::isInstance)
                .map(l -> competenciaGrupoMapper.toDomain((CompetenciaGrupoEntity) l))
                .collect(Collectors.toList())
        ;


        return competenciaGrupos;
    }

    @Override
    public void elimina(CompetenciaGrupo o) {

    }
}
