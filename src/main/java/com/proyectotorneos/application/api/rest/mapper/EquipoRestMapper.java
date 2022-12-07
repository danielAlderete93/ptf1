package com.proyectotorneos.application.api.rest.mapper;

import com.proyectotorneos.application.api.rest.dto.request.EquipoRequest;
import com.proyectotorneos.application.api.rest.dto.response.EquipoResponse;
import com.proyectotorneos.domain.model.Equipo;
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
        Equipo equipo = new Equipo();
        equipo.setNombre(request.nombre());
        equipo.setUrlEscudo(request.urlEscudo());
        equipo.setUrlPlantel(request.urlPlantel());
        return equipo;
    }
}
