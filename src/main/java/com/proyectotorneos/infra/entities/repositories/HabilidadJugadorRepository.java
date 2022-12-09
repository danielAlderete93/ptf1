package com.proyectotorneos.infra.entities.repositories;

import com.proyectotorneos.domain.model.HabilidadJugador;

import java.util.List;

public interface HabilidadJugadorRepository {
    void alta(HabilidadJugador o);

    HabilidadJugador getById(Integer id);

    HabilidadJugador getByName(String name);

    List<HabilidadJugador> getAll();

    void elimina(HabilidadJugador o);
}
