package com.proyectotorneos.domain.port.service.impl;

import com.proyectotorneos.domain.model.ActuacionEquipo;
import com.proyectotorneos.infra.entities.repositories.ActuacionEquipoRepository;
import com.proyectotorneos.domain.port.service.ActuacionEquipoService;

public class DomainActuacionEquipoService implements ActuacionEquipoService {

    private final ActuacionEquipoRepository actuacionEquipoRepository;


    public DomainActuacionEquipoService(ActuacionEquipoRepository actuacionEquipoRepository) {
        this.actuacionEquipoRepository = actuacionEquipoRepository;
    }


    @Override
    public ActuacionEquipo buscaPorID(Integer id) {
        return actuacionEquipoRepository.getById(id);
    }

    @Override
    public void elimina(ActuacionEquipo o) {

    }


}
