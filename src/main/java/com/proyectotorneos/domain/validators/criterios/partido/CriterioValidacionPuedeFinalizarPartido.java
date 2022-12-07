package com.proyectotorneos.domain.validators.criterios.partido;

import com.proyectotorneos.domain.exceptions.DomainExceptionPartido;
import com.proyectotorneos.domain.model.ActuacionEquipo;
import com.proyectotorneos.domain.model.Partido;
import com.proyectotorneos.domain.validators.criterios.CriterioValidacion;

public class CriterioValidacionPuedeFinalizarPartido implements CriterioValidacion<Partido> {
    @Override
    public boolean esValido(Partido partido) {
        return actuacionTieneJugadores(partido.getActuacionEquipoVisitante()) &&
                actuacionTieneJugadores(partido.getActuacionEquipoLocal());
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
