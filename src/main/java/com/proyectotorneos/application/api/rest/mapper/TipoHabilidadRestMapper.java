package com.proyectotorneos.application.api.rest.mapper;

import com.proyectotorneos.application.api.rest.dto.request.TipoHabilidadRequest;
import com.proyectotorneos.application.api.rest.dto.response.TipoHabilidadResponse;
import com.proyectotorneos.domain.model.TipoHabilidad;
import org.springframework.stereotype.Component;

@Component
public class TipoHabilidadRestMapper {

    public TipoHabilidadResponse toResponse(TipoHabilidad tipoHabilidad) {

        if (tipoHabilidad == null) {
            return null;
        }

        return new TipoHabilidadResponse(
                tipoHabilidad.getId(),
                tipoHabilidad.getDescripcion(),
                tipoHabilidad.getNombre()
        );

    }

    public TipoHabilidad toDomain(TipoHabilidadRequest request) {
        TipoHabilidad tipoHabilidad = new TipoHabilidad();

        if (request == null) {
            return null;
        }

        tipoHabilidad.setDescripcion(request.descripcion());
        tipoHabilidad.setNombre(request.nombre());

        return tipoHabilidad;
    }
}
