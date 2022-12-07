package com.proyectotorneos.domain.validators.criterios.jugador;

import com.proyectotorneos.domain.exceptions.DomainExceptionJugador;
import com.proyectotorneos.domain.model.Jugador;
import com.proyectotorneos.domain.validators.criterios.CriterioValidacion;

public class CriterioValidacionJugadorNoNulo implements CriterioValidacion<Jugador> {
    @Override
    public boolean esValido(Jugador o) {
        return null != o;
    }

    @Override
    public void accion() {
        throw new DomainExceptionJugador("Jugador no puede ser nulo");
    }
}
