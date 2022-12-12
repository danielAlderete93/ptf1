package com.proyectotorneos.fecha.domain.port.services;

import com.proyectotorneos.fecha.domain.model.FechaCompetitiva;
import com.proyectotorneos.habilidad.domain.model.HabilidadJugador;

public interface FechaCompetitivaService {
    void guarda(FechaCompetitiva o);

    FechaCompetitiva buscaPorID(Integer id);


    void elimina(HabilidadJugador o);
}
