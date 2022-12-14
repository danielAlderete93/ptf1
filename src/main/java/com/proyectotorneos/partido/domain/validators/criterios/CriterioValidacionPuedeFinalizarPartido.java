package com.proyectotorneos.partido.domain.validators.criterios;

import com.proyectotorneos.partido.domain.exceptions.DomainExceptionPartido;
import com.proyectotorneos.actuacion.domain.model.ActuacionEquipo;
import com.proyectotorneos.partido.domain.model.Partido;
import com.proyectotorneos.shared.domain.validators.criterios.CriterioValidacion;

public class CriterioValidacionPuedeFinalizarPartido implements CriterioValidacion<Partido> {
    @Override
    public boolean esValido(Partido partido) {
        return actuacionTieneJugadores(partido.getActuacionVisitante()) &&
                actuacionTieneJugadores(partido.getActuacionLocal());
    }

    @Override
    public void accion() {
        throw new DomainExceptionPartido("No se puede finalizar un partido sin jugadores participantes");
    }

    private boolean actuacionTieneJugadores(ActuacionEquipo actuacionEquipo) {
        //TODO: DEPENDE DE LA CANTIDAD DE JUGADORES MINIMOS DEL TORNEO
        return !actuacionEquipo.getJugadoresParticipante().isEmpty();
    }
}
