package com.proyectotorneos.jugador.domain.validators.criterios;

import com.proyectotorneos.jugador.domain.exceptions.DomainExceptionJugador;
import com.proyectotorneos.jugador.domain.model.Jugador;
import com.proyectotorneos.shared.domain.validators.criterios.CriterioValidacion;

public class CriterioPosicionJugador implements CriterioValidacion<Jugador> {
    @Override
    public boolean esValido(Jugador jugador) {
        return !jugador.tieneMismaPosicion();
    }

    @Override
    public void accion() {
        throw new DomainExceptionJugador("Posicion favorita y posicion opcional son iguales");
    }


}
