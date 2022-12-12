package com.proyectotorneos.equipo.domain.port.service;

import com.proyectotorneos.equipo.domain.model.Equipo;
import com.proyectotorneos.jugador.domain.model.Jugador;

import java.util.List;

public interface EquipoService {
    void guarda(Equipo o);

    Equipo buscaPorID(Integer id);

    List<Equipo> getAll();

    void elimina(Equipo o);

    void agregaJugador(Equipo equipo, Jugador jugador);

}

