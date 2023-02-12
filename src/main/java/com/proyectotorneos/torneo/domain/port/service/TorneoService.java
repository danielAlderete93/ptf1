package com.proyectotorneos.torneo.domain.port.service;

import com.proyectotorneos.torneo.domain.model.Torneo;

import java.util.List;

public interface TorneoService {
    void guarda(Torneo o);

    Torneo buscaPorID(Integer id);

    List<Torneo> buscaTodos();

    void elimina(Torneo o);
}
