package com.proyectotorneos.domain.validators;

import com.proyectotorneos.domain.model.Partido;
import com.proyectotorneos.domain.validators.criterios.partido.CriterioValidacionEquiposDistintosPartido;
import com.proyectotorneos.domain.validators.criterios.partido.CriterioValidacionGolesDebenPertenecerAUnJugadorParticipante;
import com.proyectotorneos.domain.validators.criterios.partido.CriterioValidacionJugadoresParticipantesDebenSerDelEquipo;

import java.util.ArrayList;

public class ValidadorPartido extends Validador<Partido> {
    public ValidadorPartido() {
        this.criterios = new ArrayList<>();
        criterios.add(new CriterioValidacionEquiposDistintosPartido());
        criterios.add(new CriterioValidacionJugadoresParticipantesDebenSerDelEquipo());
        criterios.add(new CriterioValidacionGolesDebenPertenecerAUnJugadorParticipante());
    }
}
