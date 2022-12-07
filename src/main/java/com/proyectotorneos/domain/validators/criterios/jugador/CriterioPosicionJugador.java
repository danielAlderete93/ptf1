package com.proyectotorneos.domain.validators.criterios.jugador;

import com.proyectotorneos.domain.exceptions.DomainExceptionJugador;
import com.proyectotorneos.domain.model.Jugador;
import com.proyectotorneos.domain.validators.criterios.CriterioValidacion;

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
