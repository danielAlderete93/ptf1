package com.proyectotorneos.infra.entities.repositories;

import com.proyectotorneos.domain.model.FechaCompetitiva;

import java.util.List;

public interface FechaCompetitivaRepository {
    void alta(FechaCompetitiva o);

    FechaCompetitiva getById(Integer id);

    List<FechaCompetitiva> getAll();

    void elimina(FechaCompetitiva o);
}
