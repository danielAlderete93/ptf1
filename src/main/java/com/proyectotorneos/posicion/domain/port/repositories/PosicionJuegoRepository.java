package com.proyectotorneos.posicion.domain.port.repositories;

import com.proyectotorneos.posicion.domain.model.PosicionJuego;

import java.util.List;

public interface PosicionJuegoRepository {
    void alta(PosicionJuego o);

    PosicionJuego getById(Integer id);

    PosicionJuego getByName(String name);

    List<PosicionJuego> getAll();


    void elimina(PosicionJuego o);
}
