package com.proyectotorneos.domain.port.service.impl;

import com.proyectotorneos.domain.model.FechaCompetitiva;
import com.proyectotorneos.domain.model.HabilidadJugador;
import com.proyectotorneos.domain.port.service.FechaCompetitivaService;
import com.proyectotorneos.infra.entities.repositories.FechaCompetitivaRepository;

public class DomainFechaCompetitivaService implements FechaCompetitivaService {

    private final FechaCompetitivaRepository fechaCompetitivaRepository;

    public DomainFechaCompetitivaService(FechaCompetitivaRepository repository) {
        this.fechaCompetitivaRepository = repository;
    }

    @Override
    public void guarda(FechaCompetitiva o) {
        this.fechaCompetitivaRepository.alta(o);
    }

    @Override
    public FechaCompetitiva buscaPorID(Integer id) {
        return this.fechaCompetitivaRepository.getById(id);
    }

    @Override
    public void elimina(HabilidadJugador o) {

    }
}
