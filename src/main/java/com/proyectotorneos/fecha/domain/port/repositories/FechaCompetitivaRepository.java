package com.proyectotorneos.fecha.domain.port.repositories;

import com.proyectotorneos.fecha.domain.model.FechaCompetitiva;

import java.util.List;

public interface FechaCompetitivaRepository {
    void alta(FechaCompetitiva o);

    FechaCompetitiva getById(Integer id);

    List<FechaCompetitiva> getAll();

    void elimina(FechaCompetitiva o);
}
