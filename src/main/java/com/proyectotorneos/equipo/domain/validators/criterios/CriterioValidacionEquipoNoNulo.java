package com.proyectotorneos.equipo.domain.validators.criterios;

import com.proyectotorneos.equipo.domain.exceptions.DomainExceptionEquipo;
import com.proyectotorneos.equipo.domain.model.Equipo;
import com.proyectotorneos.shared.domain.validators.criterios.CriterioValidacion;

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
