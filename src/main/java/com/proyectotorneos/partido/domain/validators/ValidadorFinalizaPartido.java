package com.proyectotorneos.partido.domain.validators;

import com.proyectotorneos.shared.domain.validators.Validador;
import com.proyectotorneos.partido.domain.model.Partido;
import com.proyectotorneos.partido.domain.validators.criterios.CriterioValidacionPuedeFinalizarPartido;

import java.util.ArrayList;

public class ValidadorFinalizaPartido extends Validador<Partido> {
    public ValidadorFinalizaPartido() {
        this.criterios = new ArrayList<>();
        criterios.add(new CriterioValidacionPuedeFinalizarPartido());

    }
}
