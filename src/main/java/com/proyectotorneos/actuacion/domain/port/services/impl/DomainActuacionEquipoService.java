package com.proyectotorneos.actuacion.domain.port.services.impl;

import com.proyectotorneos.actuacion.domain.model.ActuacionEquipo;
import com.proyectotorneos.actuacion.domain.port.repositories.ActuacionEquipoRepository;
import com.proyectotorneos.actuacion.domain.port.services.ActuacionEquipoService;

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
