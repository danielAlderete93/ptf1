package com.proyectotorneos.jugador.domain.validators.criterios;

import com.proyectotorneos.jugador.domain.exceptions.DomainExceptionJugador;
import com.proyectotorneos.jugador.domain.model.Jugador;
import com.proyectotorneos.shared.domain.validators.criterios.CriterioValidacion;

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
