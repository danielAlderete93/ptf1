package com.proyectotorneos.domain.validators;

import com.proyectotorneos.domain.validators.criterios.CriterioValidacion;

import java.util.List;

public abstract class Validador<T> {

    protected List<CriterioValidacion<T>> criterios;


    public void valida(T o) {
        this.criterios.forEach(criterio -> criterio.valida(o));
    }

}
