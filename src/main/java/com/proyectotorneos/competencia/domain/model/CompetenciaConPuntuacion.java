package com.proyectotorneos.competencia.domain.model;

import com.proyectotorneos.equipo.domain.model.Equipo;
import com.proyectotorneos.tabla.domain.model.EntradaTablaPosicion;

import java.util.List;

public interface CompetenciaConPuntuacion<T> {

    List<T> getTabla();


    Integer getPosicionEquipo(Equipo equipo);
}
