package com.proyectotorneos.competencia.domain.model.requisitos;

import com.proyectotorneos.competencia.domain.model.Competencia;
import com.proyectotorneos.equipo.domain.model.Equipo;

public interface RequisitoClasificacion {

    Boolean puedeClasificar(Equipo equipo, Competencia competencia);
}
