package com.proyectotorneos.domain.validators.criterios.partido;

import com.proyectotorneos.domain.exceptions.DomainExceptionPartido;
import com.proyectotorneos.domain.model.ActuacionEquipo;
import com.proyectotorneos.domain.model.Partido;
import com.proyectotorneos.domain.validators.criterios.CriterioValidacion;

public class CriterioValidacionJugadoresParticipantesDebenSerDelEquipo implements CriterioValidacion<Partido> {

    @Override
    public boolean esValido(Partido partido) {
        return jugadoresCorrespondeAEquipo(partido.getActuacionEquipoVisitante()) &&
                jugadoresCorrespondeAEquipo(partido.getActuacionEquipoLocal());
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
