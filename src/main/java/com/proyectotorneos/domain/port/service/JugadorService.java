package com.proyectotorneos.domain.port.service;

import com.proyectotorneos.domain.model.Jugador;

public interface JugadorService {

    void guarda(Jugador jugador);
    Jugador buscaPorID(Integer id);


    void elimina(Jugador o);
}
