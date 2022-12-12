package com.proyectotorneos.jugador.domain.port.services.impl;

import com.proyectotorneos.jugador.domain.model.Jugador;
import com.proyectotorneos.jugador.domain.port.repositories.JugadorRepository;
import com.proyectotorneos.jugador.domain.port.services.JugadorService;


public class DomainJugadorService implements JugadorService {
    private final JugadorRepository jugadorRepository;


    public DomainJugadorService(JugadorRepository jugadorRepository) {
        this.jugadorRepository = jugadorRepository;
    }

    @Override
    public void guarda(Jugador jugador) {
        jugadorRepository.alta(jugador);
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
