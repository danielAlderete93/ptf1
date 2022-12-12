package com.proyectotorneos.fecha.domain.port.services.impl;

import com.proyectotorneos.fecha.domain.model.FechaCompetitiva;
import com.proyectotorneos.habilidad.domain.model.HabilidadJugador;
import com.proyectotorneos.fecha.domain.port.services.FechaCompetitivaService;
import com.proyectotorneos.fecha.domain.port.repositories.FechaCompetitivaRepository;

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
