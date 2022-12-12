package com.proyectotorneos.habilidad.domain.port.services;

import com.proyectotorneos.habilidad.domain.model.HabilidadJugador;

import java.util.List;

public interface HabilidadJugadorService {
    void guarda(HabilidadJugador o);

    HabilidadJugador buscaPorID(Integer id);



    List<HabilidadJugador> getAll();

    void elimina(HabilidadJugador o);
}
