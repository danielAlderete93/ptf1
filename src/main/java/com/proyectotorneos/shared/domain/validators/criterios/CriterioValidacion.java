package com.proyectotorneos.shared.domain.validators.criterios;

public interface CriterioValidacion<T> {
    boolean esValido(T o);

    void accion();

    default void valida(T o) {
        if (!esValido(o)) {
            accion();
        }
    }
}
