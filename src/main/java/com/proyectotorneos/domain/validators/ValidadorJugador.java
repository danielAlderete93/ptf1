package com.proyectotorneos.domain.validators;

import com.proyectotorneos.domain.model.Jugador;
import com.proyectotorneos.domain.validators.criterios.jugador.CriterioEdadJugador;
import com.proyectotorneos.domain.validators.criterios.jugador.CriterioPosicionJugador;
import com.proyectotorneos.domain.validators.criterios.jugador.CriterioValidacionJugadorNoNulo;

import java.util.ArrayList;

public class ValidadorJugador extends Validador<Jugador> {

    public ValidadorJugador() {
        this.criterios = new ArrayList<>();
        criterios.add(new CriterioValidacionJugadorNoNulo());
        criterios.add(new CriterioPosicionJugador());
        criterios.add(new CriterioEdadJugador());
    }

}
