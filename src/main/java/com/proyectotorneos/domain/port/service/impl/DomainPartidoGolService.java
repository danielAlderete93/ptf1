package com.proyectotorneos.domain.port.service.impl;

import com.proyectotorneos.domain.model.PartidoGol;
import com.proyectotorneos.domain.port.repositories.PartidoGolRepository;
import com.proyectotorneos.domain.port.service.PartidoGolService;

public class DomainPartidoGolService implements PartidoGolService {
    private final PartidoGolRepository partidoGolRepository;

    public DomainPartidoGolService(PartidoGolRepository partidoGolRepository) {
        this.partidoGolRepository = partidoGolRepository;
    }

    @Override
    public PartidoGol BuscaPorID(Integer id) {
        return partidoGolRepository.getById(id);
    }


    @Override
    public void elimina(PartidoGol o) {

    }
}
