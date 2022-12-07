package com.proyectotorneos.domain.validators.criterios.equipo;

import com.proyectotorneos.domain.exceptions.DomainExceptionEquipo;
import com.proyectotorneos.domain.model.Equipo;
import com.proyectotorneos.domain.validators.criterios.CriterioValidacion;

public class CriterioValidacionEquipoNoNulo implements CriterioValidacion<Equipo> {
    @Override
    public boolean esValido(Equipo o) {
        return null != o;
    }

    @Override
    public void accion() {
        throw new DomainExceptionEquipo("Equipo no puede ser nulo");
    }
}
