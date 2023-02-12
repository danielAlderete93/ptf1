package com.proyectotorneos.tipo_habilidad.app.api.rest.mapper;

import com.proyectotorneos.tipo_habilidad.app.api.rest.dto.TipoHabilidadRequest;
import com.proyectotorneos.tipo_habilidad.app.api.rest.dto.TipoHabilidadResponse;
import com.proyectotorneos.tipo_habilidad.domain.model.TipoHabilidad;
import org.springframework.stereotype.Component;

@Component
public class TipoHabilidadRestMapper {

    public TipoHabilidadResponse toResponse(TipoHabilidad tipoHabilidad) {

        if (tipoHabilidad == null) {
            return null;
        }

        return new TipoHabilidadResponse(
                tipoHabilidad.getId(),
                tipoHabilidad.getNombre(),
                tipoHabilidad.getDescripcion()
        );

    }

    public TipoHabilidad toDomain(TipoHabilidadRequest request) {
        if (request == null) {
            return null;
        }

        return TipoHabilidad.builder()
                .descripcion(request.descripcion())
                .nombre(request.nombre())
                .build();
    }
}
