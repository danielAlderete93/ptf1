package com.proyectotorneos.equipo.app.rest.mapper;

import com.proyectotorneos.equipo.app.rest.dto.EquipoRequest;
import com.proyectotorneos.equipo.app.rest.dto.EquipoResponse;
import com.proyectotorneos.equipo.domain.model.Equipo;
import org.springframework.stereotype.Component;

@Component
public class EquipoRestMapper {

    public EquipoResponse toResponse(Equipo equipo) {
        if (equipo == null) {
            return null;
        }

        return new EquipoResponse(
                equipo.getId(),
                equipo.getNombre(),
                equipo.getUrlEscudo(),
                equipo.getUrlPlantel()
        );
    }

    public Equipo toDomain(EquipoRequest request) {

        return Equipo.builder()
                .nombre(request.nombre())
                .urlPlantel(request.urlPlantel())
                .urlEscudo(request.urlEscudo())
                .build();
    }
}
