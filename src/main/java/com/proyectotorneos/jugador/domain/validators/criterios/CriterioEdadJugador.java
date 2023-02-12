package com.proyectotorneos.jugador.domain.validators.criterios;

import com.proyectotorneos.jugador.domain.exceptions.DomainExceptionJugador;
import com.proyectotorneos.jugador.domain.model.Jugador;
import com.proyectotorneos.shared.domain.validators.criterios.CriterioValidacion;

import java.time.LocalDate;

public class CriterioEdadJugador implements CriterioValidacion<Jugador> {
    @Override
    public boolean esValido(Jugador jugador) {
        return jugador.getFechaNacimiento().compareTo(LocalDate.now()) < 0;
    }

    @Override
    public void accion() {
        throw new DomainExceptionJugador("Fecha nacimiento es superior a la fecha actual.");
    }

}
