package com.proyectotorneos.jugador.domain.port.services;

import com.proyectotorneos.jugador.domain.model.Jugador;

public interface JugadorService {

    void guarda(Jugador jugador);
    Jugador buscaPorID(Integer id);
    void elimina(Jugador o);
}
