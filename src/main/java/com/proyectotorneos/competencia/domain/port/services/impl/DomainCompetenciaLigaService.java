package com.proyectotorneos.competencia.domain.port.services.impl;

import com.proyectotorneos.competencia.domain.model.CompetenciaLiga;
import com.proyectotorneos.competencia.domain.port.repositories.CompetenciaRepository;
import com.proyectotorneos.competencia.domain.port.services.CompetenciaService;

import java.util.List;

public class DomainCompetenciaLigaService implements CompetenciaService<CompetenciaLiga> {
    private final CompetenciaRepository<CompetenciaLiga> competenciaRepository;

    public DomainCompetenciaLigaService(CompetenciaRepository<CompetenciaLiga> competenciaRepository) {
        this.competenciaRepository = competenciaRepository;
    }


    @Override
    public void guarda(CompetenciaLiga competencia) {
        competenciaRepository.alta(competencia);
    }


    @Override
    public CompetenciaLiga buscaPorID(Integer id) {
        return competenciaRepository.buscaPorID(id);
    }

    @Override
    public List<CompetenciaLiga> buscaTodas() {
        return competenciaRepository.getAll();
    }


}

