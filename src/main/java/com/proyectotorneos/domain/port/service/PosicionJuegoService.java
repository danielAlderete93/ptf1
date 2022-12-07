package com.proyectotorneos.domain.port.service;

import com.proyectotorneos.domain.model.PosicionJuego;

import java.util.List;

public interface PosicionJuegoService {
    void guarda(PosicionJuego o);

    PosicionJuego buscaPorID(Integer id);

    List<PosicionJuego> buscaTodos();

    void elimina(PosicionJuego o);
}
