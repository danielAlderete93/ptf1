package com.proyectotorneos.domain.validators;

import com.proyectotorneos.domain.model.Partido;
import com.proyectotorneos.domain.validators.criterios.partido.CriterioValidacionPuedeFinalizarPartido;

import java.util.ArrayList;

public class ValidadorFinalizaPartido extends Validador<Partido> {
    public ValidadorFinalizaPartido() {
        this.criterios = new ArrayList<>();
        criterios.add(new CriterioValidacionPuedeFinalizarPartido());

    }
}
