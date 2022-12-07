package com.proyectotorneos.domain.port.service.impl;

import com.proyectotorneos.domain.model.Jugador;
import com.proyectotorneos.domain.port.repositories.JugadorRepository;
import com.proyectotorneos.domain.port.service.JugadorService;


public class DomainJugadorService implements JugadorService {
    private final JugadorRepository jugadorRepository;


    public DomainJugadorService(JugadorRepository jugadorRepository) {
        this.jugadorRepository = jugadorRepository;
    }

    @Override
    public Jugador buscaPorID(Integer id) {
        return jugadorRepository.getById(id);
    }


    @Override
    public void elimina(Jugador o) {
        jugadorRepository.elimina(o);
    }


}
