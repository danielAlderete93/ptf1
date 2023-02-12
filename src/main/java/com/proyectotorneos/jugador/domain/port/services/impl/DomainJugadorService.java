package com.proyectotorneos.jugador.domain.port.services.impl;

import com.proyectotorneos.jugador.domain.model.Jugador;
import com.proyectotorneos.jugador.domain.port.repositories.JugadorRepository;
import com.proyectotorneos.jugador.domain.port.services.JugadorService;
import com.proyectotorneos.jugador.domain.validators.ValidadorJugador;
import com.proyectotorneos.shared.domain.validators.Validador;


public class DomainJugadorService implements JugadorService {
    private final JugadorRepository jugadorRepository;

    private final Validador<Jugador> jugadorValidador;


    public DomainJugadorService(JugadorRepository jugadorRepository) {
        this.jugadorRepository = jugadorRepository;
        this.jugadorValidador = new ValidadorJugador();
    }

    @Override
    public void guarda(Jugador jugador) {
        jugadorValidador.valida(jugador);
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
