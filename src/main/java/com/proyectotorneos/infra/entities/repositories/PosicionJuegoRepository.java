package com.proyectotorneos.infra.entities.repositories;

import com.proyectotorneos.domain.model.PosicionJuego;

import java.util.List;

public interface PosicionJuegoRepository {
    void alta(PosicionJuego o);

    PosicionJuego getById(Integer id);

    PosicionJuego getByName(String name);

    List<PosicionJuego> getAll();


    void elimina(PosicionJuego o);
}
