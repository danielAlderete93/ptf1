package com.proyectotorneos.domain.validators;

import com.proyectotorneos.domain.model.Equipo;
import com.proyectotorneos.domain.validators.criterios.equipo.CriterioValidacionEquipoNoNulo;

import java.util.ArrayList;

public class ValidadorEquipo extends Validador<Equipo> {
    public ValidadorEquipo() {
        this.criterios = new ArrayList<>();
        this.criterios.add(new CriterioValidacionEquipoNoNulo());
    }
}
