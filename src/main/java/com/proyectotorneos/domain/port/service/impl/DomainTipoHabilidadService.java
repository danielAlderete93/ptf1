package com.proyectotorneos.domain.port.service.impl;

import com.proyectotorneos.domain.exceptions.DomainExceptionTipoHabilidad;
import com.proyectotorneos.domain.model.TipoHabilidad;
import com.proyectotorneos.infra.entities.repositories.TipoHabilidadRepository;
import com.proyectotorneos.domain.port.service.TipoHabilidadService;

import java.util.List;


public class DomainTipoHabilidadService implements TipoHabilidadService {

    private final TipoHabilidadRepository tipoHabilidadRepository;

    public DomainTipoHabilidadService(TipoHabilidadRepository tipoHabilidadRepository) {
        this.tipoHabilidadRepository = tipoHabilidadRepository;
    }

    @Override
    public void guarda(TipoHabilidad o) {
        if (null != tipoHabilidadRepository.getByName(o.getNombre())) {
            throw new DomainExceptionTipoHabilidad("Ya existe un tipo habilidad con ese nombre");
        }
        this.tipoHabilidadRepository.alta(o);
    }

    @Override
    public TipoHabilidad buscaPorID(Integer id) {
        return tipoHabilidadRepository.getById(id);
    }

    @Override
    public List<TipoHabilidad> buscaTodos() {
        return tipoHabilidadRepository.getAll();
    }

    @Override
    public void elimina(TipoHabilidad o) {
        tipoHabilidadRepository.elimina(o);
    }
}
