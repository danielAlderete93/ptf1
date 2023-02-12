package com.proyectotorneos.torneo.domain.port.repositories;

import com.proyectotorneos.torneo.domain.model.Torneo;

import java.util.List;

public interface TorneoRepository {
    void alta(Torneo o);

    Torneo getById(Integer id);


    List<Torneo> getAll();

    void elimina(Torneo o);
}
