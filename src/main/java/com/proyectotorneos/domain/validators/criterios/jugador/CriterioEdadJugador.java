package com.proyectotorneos.domain.validators.criterios.jugador;

import com.proyectotorneos.domain.exceptions.DomainExceptionJugador;
import com.proyectotorneos.domain.model.Jugador;
import com.proyectotorneos.domain.validators.criterios.CriterioValidacion;

import java.util.Date;

public class CriterioEdadJugador implements CriterioValidacion<Jugador> {
    @Override
    public boolean esValido(Jugador jugador) {
        return jugador.getFechaNacimiento().before(new Date());
    }

    @Override
    public void accion() {
        throw new DomainExceptionJugador("Fecha nacimiento es superior a la fecha actual.");
    }

}
