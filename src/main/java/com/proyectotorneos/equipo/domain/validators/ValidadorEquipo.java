package com.proyectotorneos.equipo.domain.validators;

import com.proyectotorneos.shared.domain.validators.Validador;
import com.proyectotorneos.equipo.domain.model.Equipo;
import com.proyectotorneos.equipo.domain.validators.criterios.CriterioValidacionEquipoNoNulo;

import java.util.ArrayList;

public class ValidadorEquipo extends Validador<Equipo> {
    public ValidadorEquipo() {
        this.criterios = new ArrayList<>();
        this.criterios.add(new CriterioValidacionEquipoNoNulo());
    }
}
