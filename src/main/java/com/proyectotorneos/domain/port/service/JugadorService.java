package com.proyectotorneos.domain.port.service;

import com.proyectotorneos.domain.model.Jugador;

public interface JugadorService {
    Jugador buscaPorID(Integer id);


    void elimina(Jugador o);
}
