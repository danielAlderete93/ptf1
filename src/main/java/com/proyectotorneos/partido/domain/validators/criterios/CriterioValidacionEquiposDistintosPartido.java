package com.proyectotorneos.partido.domain.validators.criterios;

import com.proyectotorneos.partido.domain.exceptions.DomainExceptionPartido;
import com.proyectotorneos.equipo.domain.model.Equipo;
import com.proyectotorneos.partido.domain.model.Partido;
import com.proyectotorneos.shared.domain.validators.criterios.CriterioValidacion;

public class CriterioValidacionEquiposDistintosPartido implements CriterioValidacion<Partido> {
    @Override
    public boolean esValido(Partido partido) {
        Equipo equipoLocal = partido.getActuacionLocal().getEquipo();
        Equipo equipoVisitante = partido.getActuacionVisitante().getEquipo();

        return !equipoLocal.equals(equipoVisitante);
    }

    @Override
    public void accion() {
        throw new DomainExceptionPartido("Los equipos deben ser distintos");
    }
}
