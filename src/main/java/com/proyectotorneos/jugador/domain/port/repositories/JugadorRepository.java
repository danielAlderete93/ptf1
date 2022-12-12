package com.proyectotorneos.jugador.domain.port.repositories;

import com.proyectotorneos.jugador.domain.model.Jugador;

import java.util.List;

public interface JugadorRepository {
    void alta(Jugador o);

    Jugador getById(Integer id);

    List<Jugador> getAll();

    void elimina(Jugador o);
}
