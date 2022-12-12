package com.proyectotorneos.habilidad.domain.port.repositories;

import com.proyectotorneos.habilidad.domain.model.HabilidadJugador;

import java.util.List;

public interface HabilidadJugadorRepository {
    void alta(HabilidadJugador o);

    HabilidadJugador getById(Integer id);

    HabilidadJugador getByName(String name);

    List<HabilidadJugador> getAll();

    void elimina(HabilidadJugador o);
}
