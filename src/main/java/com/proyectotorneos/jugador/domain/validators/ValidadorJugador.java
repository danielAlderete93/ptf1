package com.proyectotorneos.jugador.domain.validators;

import com.proyectotorneos.shared.domain.validators.Validador;
import com.proyectotorneos.jugador.domain.model.Jugador;
import com.proyectotorneos.jugador.domain.validators.criterios.CriterioEdadJugador;
import com.proyectotorneos.jugador.domain.validators.criterios.CriterioPosicionJugador;
import com.proyectotorneos.jugador.domain.validators.criterios.CriterioValidacionJugadorNoNulo;

import java.util.ArrayList;

public class ValidadorJugador extends Validador<Jugador> {

    public ValidadorJugador() {
        this.criterios = new ArrayList<>();
        criterios.add(new CriterioValidacionJugadorNoNulo());
        criterios.add(new CriterioPosicionJugador());
        criterios.add(new CriterioEdadJugador());
    }

}
