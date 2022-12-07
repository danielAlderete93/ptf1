package com.proyectotorneos.domain.port.service;

import com.proyectotorneos.domain.model.Equipo;
import com.proyectotorneos.domain.model.Jugador;

import java.util.List;

public interface EquipoService {
    void guarda(Equipo o);

    Equipo buscaPorID(Integer id);

    List<Equipo> getAll();

    void elimina(Equipo o);

    void agregaJugador(Equipo equipo, Jugador jugador);

}

