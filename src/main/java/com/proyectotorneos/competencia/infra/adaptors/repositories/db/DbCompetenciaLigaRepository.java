package com.proyectotorneos.competencia.infra.adaptors.repositories.db;

import com.proyectotorneos.competencia.domain.model.CompetenciaLiga;
import com.proyectotorneos.competencia.domain.port.repositories.CompetenciaRepository;
import com.proyectotorneos.competencia.infra.adaptors.repositories.CompetenciaRepositoryJPA;
import com.proyectotorneos.competencia.infra.entities.CompetenciaEntity;
import com.proyectotorneos.competencia.infra.entities.CompetenciaLigaEntity;
import com.proyectotorneos.competencia.infra.mapper.CompetenciaLigaMapper;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class DbCompetenciaLigaRepository implements CompetenciaRepository<CompetenciaLiga> {

    private final CompetenciaLigaMapper competenciaLigaMapper;
    private final CompetenciaRepositoryJPA competenciaLigaRepositoryJPA;

    public DbCompetenciaLigaRepository(CompetenciaLigaMapper competenciaLigaMapper, CompetenciaRepositoryJPA competenciaLigaRepositoryJPA) {
        this.competenciaLigaMapper = competenciaLigaMapper;
        this.competenciaLigaRepositoryJPA = competenciaLigaRepositoryJPA;
    }

    @Override
    public void alta(CompetenciaLiga competencia) {
        competenciaLigaRepositoryJPA.saveAndFlush(competenciaLigaMapper.toEntity(competencia));
    }


    @Override
    public CompetenciaLiga buscaPorID(Integer id) {
        CompetenciaEntity entity;
        entity = competenciaLigaRepositoryJPA.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Recurso no encontrado"));

        if (entity instanceof CompetenciaLigaEntity competenciaLigaEntity) {
            return competenciaLigaMapper.toDomain(competenciaLigaEntity);

        }

        throw new ResourceNotFoundException("Recurso no encontrado");

    }


    @Override
    public List<CompetenciaLiga> getAll() {
        List<CompetenciaLiga> competenciaLigas;

        competenciaLigas = competenciaLigaRepositoryJPA.findAll()
                .stream()
                .filter(CompetenciaLigaEntity.class::isInstance)
                .map(l -> competenciaLigaMapper.toDomain((CompetenciaLigaEntity) l))
                .collect(Collectors.toList())
        ;


        return competenciaLigas;
    }

    @Override
    public void elimina(CompetenciaLiga o) {
        // TODO a implementar

    }
}
