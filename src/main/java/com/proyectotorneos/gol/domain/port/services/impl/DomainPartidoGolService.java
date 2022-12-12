package com.proyectotorneos.gol.domain.port.services.impl;

import com.proyectotorneos.gol.domain.model.PartidoGol;
import com.proyectotorneos.gol.domain.port.repositories.PartidoGolRepository;
import com.proyectotorneos.gol.domain.port.services.PartidoGolService;

public class DomainPartidoGolService implements PartidoGolService {
    private final PartidoGolRepository partidoGolRepository;

    public DomainPartidoGolService(PartidoGolRepository partidoGolRepository) {
        this.partidoGolRepository = partidoGolRepository;
    }

    @Override
    public PartidoGol buscaPorID(Integer id) {
        return partidoGolRepository.getById(id);
    }


    @Override
    public void elimina(PartidoGol o) {

    }
}
