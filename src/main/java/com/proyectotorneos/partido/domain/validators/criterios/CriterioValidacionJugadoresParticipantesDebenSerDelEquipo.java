package com.proyectotorneos.partido.domain.validators.criterios;

import com.proyectotorneos.partido.domain.exceptions.DomainExceptionPartido;
import com.proyectotorneos.actuacion.domain.model.ActuacionEquipo;
import com.proyectotorneos.partido.domain.model.Partido;
import com.proyectotorneos.shared.domain.validators.criterios.CriterioValidacion;

public class CriterioValidacionJugadoresParticipantesDebenSerDelEquipo implements CriterioValidacion<Partido> {

    @Override
    public boolean esValido(Partido partido) {
        return jugadoresCorrespondeAEquipo(partido.getActuacionVisitante()) &&
                jugadoresCorrespondeAEquipo(partido.getActuacionLocal());
    }

    @Override
    public void accion() {
        throw new DomainExceptionPartido("Hay jugadores que no pertenecen algun equipo.");
    }

    private boolean jugadoresCorrespondeAEquipo(ActuacionEquipo actuacionEquipo) {
        if (actuacionEquipo.getJugadoresParticipante().isEmpty()) {
            return true;
        }

        return actuacionEquipo.getJugadoresParticipante().stream().allMatch(j -> actuacionEquipo.getEquipo().tenesJugador(j));
    }
}
