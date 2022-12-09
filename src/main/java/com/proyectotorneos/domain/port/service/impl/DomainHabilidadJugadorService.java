package com.proyectotorneos.domain.port.service.impl;

import com.proyectotorneos.domain.exceptions.DomainExceptionHabilidadJugador;
import com.proyectotorneos.domain.model.HabilidadJugador;
import com.proyectotorneos.infra.entities.repositories.HabilidadJugadorRepository;
import com.proyectotorneos.domain.port.service.HabilidadJugadorService;

import java.util.List;

public class DomainHabilidadJugadorService implements HabilidadJugadorService {

    private final HabilidadJugadorRepository habilidadJugadorRepository;


    public DomainHabilidadJugadorService(HabilidadJugadorRepository jugadorGenericRepository) {
        this.habilidadJugadorRepository = jugadorGenericRepository;
    }


    @Override
    public void guarda(HabilidadJugador o) {

        if (null != habilidadJugadorRepository.getByName(o.getNombre())) {
            throw new DomainExceptionHabilidadJugador("Ya existe una habilidad con ese nombre");
        }

        habilidadJugadorRepository.alta(o);
    }

    @Override
    public HabilidadJugador buscaPorID(Integer id) {
        return habilidadJugadorRepository.getById(id);
    }


    @Override
    public List<HabilidadJugador> getAll() {
        return habilidadJugadorRepository.getAll();
    }

    @Override
    public void elimina(HabilidadJugador o) {
        habilidadJugadorRepository.elimina(o);
    }
}
