package com.proyectotorneos.domain.port.repositories;

import com.proyectotorneos.domain.model.Partido;

import java.util.List;

public interface PartidoRepository {
    void alta(Partido o);

    Partido getById(Integer id);

    List<Partido> getAll();

    void elimina(Partido o);
}
