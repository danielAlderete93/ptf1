package com.proyectotorneos.competencia.domain.port.services.impl;

import com.proyectotorneos.competencia.domain.model.CompetenciaFaseEliminatoria;
import com.proyectotorneos.competencia.domain.port.repositories.CompetenciaRepository;
import com.proyectotorneos.competencia.domain.port.services.CompetenciaService;

import java.util.List;

public class DomainCompetenciaFaseEliminatoria implements CompetenciaService<CompetenciaFaseEliminatoria> {
    private final CompetenciaRepository<CompetenciaFaseEliminatoria> competenciaRepository;

    public DomainCompetenciaFaseEliminatoria(CompetenciaRepository<CompetenciaFaseEliminatoria> competenciaRepository) {
        this.competenciaRepository = competenciaRepository;
    }

    @Override
    public void guarda(CompetenciaFaseEliminatoria competencia) {
        competenciaRepository.alta(competencia);
    }

    @Override
    public CompetenciaFaseEliminatoria buscaPorID(Integer id) {
        return competenciaRepository.buscaPorID(id);
    }

    @Override
    public List<CompetenciaFaseEliminatoria> buscaTodas() {
        return competenciaRepository.getAll();
    }
}
