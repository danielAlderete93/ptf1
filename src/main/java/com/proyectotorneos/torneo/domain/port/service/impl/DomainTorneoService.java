package com.proyectotorneos.torneo.domain.port.service.impl;

import com.proyectotorneos.torneo.domain.model.Torneo;
import com.proyectotorneos.torneo.domain.port.repositories.TorneoRepository;
import com.proyectotorneos.torneo.domain.port.service.TorneoService;

import java.util.List;

public class DomainTorneoService implements TorneoService {
    private final TorneoRepository torneoRepository;

    public DomainTorneoService(TorneoRepository torneoRepository) {
        this.torneoRepository = torneoRepository;
    }

    @Override
    public void guarda(Torneo o) {
        this.torneoRepository.alta(o);
    }

    @Override
    public Torneo buscaPorID(Integer id) {
        return this.torneoRepository.getById(id);
    }

    @Override
    public List<Torneo> buscaTodos() {
        return this.torneoRepository.getAll();
    }

    @Override
    public void elimina(Torneo o) {
        this.torneoRepository.elimina(o);
    }
}
