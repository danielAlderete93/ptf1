package com.proyectotorneos.competencia.domain.model;

import com.proyectotorneos.tabla.domain.model.EntradaTablaPosicion;

import java.util.List;

public interface CompetenciaConPuntuacion {

    List<EntradaTablaPosicion> getTabla();

    List<List<EntradaTablaPosicion>> getAllTablas();
}
