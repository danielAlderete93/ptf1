package com.proyectotorneos.domain.validators.criterios.partido;

import com.proyectotorneos.domain.exceptions.DomainExceptionPartido;
import com.proyectotorneos.domain.model.Equipo;
import com.proyectotorneos.domain.model.Partido;
import com.proyectotorneos.domain.validators.criterios.CriterioValidacion;

public class CriterioValidacionEquiposDistintosPartido implements CriterioValidacion<Partido> {
    @Override
    public boolean esValido(Partido partido) {
        Equipo equipoLocal = partido.getActuacionEquipoLocal().getEquipo();
        Equipo equipoVisitante = partido.getActuacionEquipoVisitante().getEquipo();

        return !equipoLocal.equals(equipoVisitante);
    }

    @Override
    public void accion() {
        throw new DomainExceptionPartido("Los equipos deben ser distintos");
    }
}
