package com.proyectotorneos.competencia.infra.adaptors.repositories.db;

import com.proyectotorneos.competencia.domain.model.CompetenciaFaseEliminatoria;
import com.proyectotorneos.competencia.domain.port.repositories.CompetenciaRepository;
import com.proyectotorneos.competencia.infra.adaptors.repositories.CompetenciaRepositoryJPA;
import com.proyectotorneos.competencia.infra.entities.CompetenciaEntity;
import com.proyectotorneos.competencia.infra.entities.CompetenciaFaseEliminatoriaEntity;
import com.proyectotorneos.competencia.infra.mapper.CompetenciaFaseEliminatoriaMapper;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class DbCompetenciaFaseEliminatoriaRepository implements CompetenciaRepository<CompetenciaFaseEliminatoria> {
    private final CompetenciaRepositoryJPA competenciaRepositoryJPA;
    private final CompetenciaFaseEliminatoriaMapper competenciaFaseEliminatoriaMapper;

    public DbCompetenciaFaseEliminatoriaRepository(CompetenciaRepositoryJPA competenciaRepositoryJPA, CompetenciaFaseEliminatoriaMapper competenciaFaseEliminatoriaMapper) {
        this.competenciaRepositoryJPA = competenciaRepositoryJPA;
        this.competenciaFaseEliminatoriaMapper = competenciaFaseEliminatoriaMapper;
    }

    @Override
    public void alta(CompetenciaFaseEliminatoria competencia) {
        competenciaRepositoryJPA.saveAndFlush(competenciaFaseEliminatoriaMapper.toEntity(competencia));
    }

    @Override
    public CompetenciaFaseEliminatoria buscaPorID(Integer id) {
        CompetenciaEntity entity;
        entity = competenciaRepositoryJPA.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Recurso no encontrado"));

        if (entity instanceof CompetenciaFaseEliminatoriaEntity competenciaGrupoEntity) {
            return competenciaFaseEliminatoriaMapper.toDomain(competenciaGrupoEntity);

        }

        throw new ResourceNotFoundException("Recurso no encontrado");
    }

    @Override
    public List<CompetenciaFaseEliminatoria> getAll() {
        List<CompetenciaFaseEliminatoria> competenciaGrupos;

        competenciaGrupos = competenciaRepositoryJPA.findAll()
                .stream()
                .filter(CompetenciaFaseEliminatoriaEntity.class::isInstance)
                .map(l -> competenciaFaseEliminatoriaMapper.toDomain((CompetenciaFaseEliminatoriaEntity) l))
                .collect(Collectors.toList())
        ;


        return competenciaGrupos;
    }

    @Override
    public void elimina(CompetenciaFaseEliminatoria o) {

    }
}
