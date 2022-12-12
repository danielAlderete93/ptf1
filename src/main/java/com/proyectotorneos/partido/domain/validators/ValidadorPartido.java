package com.proyectotorneos.partido.domain.validators;

import com.proyectotorneos.shared.domain.validators.Validador;
import com.proyectotorneos.partido.domain.model.Partido;
import com.proyectotorneos.partido.domain.validators.criterios.CriterioValidacionEquiposDistintosPartido;
import com.proyectotorneos.partido.domain.validators.criterios.CriterioValidacionGolesDebenPertenecerAUnJugadorParticipante;
import com.proyectotorneos.partido.domain.validators.criterios.CriterioValidacionJugadoresParticipantesDebenSerDelEquipo;

import java.util.ArrayList;

public class ValidadorPartido extends Validador<Partido> {
    public ValidadorPartido() {
        this.criterios = new ArrayList<>();
        criterios.add(new CriterioValidacionEquiposDistintosPartido());
        criterios.add(new CriterioValidacionJugadoresParticipantesDebenSerDelEquipo());
        criterios.add(new CriterioValidacionGolesDebenPertenecerAUnJugadorParticipante());
    }
}
