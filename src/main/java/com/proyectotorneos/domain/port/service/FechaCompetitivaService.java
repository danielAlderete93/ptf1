package com.proyectotorneos.domain.port.service;

import com.proyectotorneos.domain.model.FechaCompetitiva;
import com.proyectotorneos.domain.model.HabilidadJugador;

public interface FechaCompetitivaService {
    void guarda(FechaCompetitiva o);

    FechaCompetitiva buscaPorID(Integer id);


    void elimina(HabilidadJugador o);
}
