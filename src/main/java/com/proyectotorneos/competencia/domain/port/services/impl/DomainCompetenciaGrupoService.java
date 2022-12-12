package com.proyectotorneos.competencia.domain.port.services.impl;

import com.proyectotorneos.competencia.domain.model.CompetenciaGrupo;
import com.proyectotorneos.competencia.domain.port.repositories.CompetenciaRepository;
import com.proyectotorneos.competencia.domain.port.services.CompetenciaService;

import java.util.List;

public class DomainCompetenciaGrupoService implements CompetenciaService<CompetenciaGrupo> {
    private final CompetenciaRepository<CompetenciaGrupo> competenciaRepository;

    public DomainCompetenciaGrupoService(CompetenciaRepository<CompetenciaGrupo> competenciaRepository) {
        this.competenciaRepository = competenciaRepository;
    }

    @Override
    public void guarda(CompetenciaGrupo competencia) {
        competenciaRepository.alta(competencia);
    }

    @Override
    public CompetenciaGrupo buscaPorID(Integer id) {
        return competenciaRepository.buscaPorID(id);
    }

    @Override
    public List<CompetenciaGrupo> buscaTodas() {
        return competenciaRepository.getAll();
    }
}
