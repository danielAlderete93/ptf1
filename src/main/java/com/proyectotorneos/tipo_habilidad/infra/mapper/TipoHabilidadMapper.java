package com.proyectotorneos.tipo_habilidad.infra.mapper;

import com.proyectotorneos.tipo_habilidad.domain.model.TipoHabilidad;
import com.proyectotorneos.tipo_habilidad.infra.entities.TipoHabilidadEntity;
import org.springframework.stereotype.Component;

@Component
public class TipoHabilidadMapper {
    public TipoHabilidadEntity toEntity(TipoHabilidad tipoHabilidad) {
        TipoHabilidadEntity entity = new TipoHabilidadEntity();
        entity.setId(tipoHabilidad.getId());
        entity.setDescripcion(tipoHabilidad.getDescripcion());
        entity.setNombre(tipoHabilidad.getNombre());
        return entity;
    }

    public TipoHabilidad toDomain(TipoHabilidadEntity tipoHabilidadEntity) {
        TipoHabilidad tipoHabilidad = new TipoHabilidad();
        tipoHabilidad.setId(tipoHabilidadEntity.getId());
        tipoHabilidad.setDescripcion(tipoHabilidadEntity.getDescripcion());
        tipoHabilidad.setNombre(tipoHabilidadEntity.getNombre());
        return tipoHabilidad;
    }
}
