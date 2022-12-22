package com.proyectotorneos.tipo_habilidad.infra.mapper;

import com.proyectotorneos.tipo_habilidad.domain.model.TipoHabilidad;
import com.proyectotorneos.tipo_habilidad.infra.entities.TipoHabilidadEntity;
import org.springframework.stereotype.Component;

@Component
public class TipoHabilidadMapper {
    public TipoHabilidadEntity toEntity(TipoHabilidad tipoHabilidad) {
        return TipoHabilidadEntity.builder()
                .id(tipoHabilidad.getId())
                .descripcion(tipoHabilidad.getDescripcion())
                .nombre(tipoHabilidad.getNombre())
                .build();
    }

    public TipoHabilidad toDomain(TipoHabilidadEntity tipoHabilidadEntity) {
        return TipoHabilidad.builder()
                .id(tipoHabilidadEntity.getId())
                .descripcion(tipoHabilidadEntity.getDescripcion())
                .nombre(tipoHabilidadEntity.getNombre())
                .build();
    }
}
