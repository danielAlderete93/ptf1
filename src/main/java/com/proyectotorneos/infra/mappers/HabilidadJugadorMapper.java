package com.proyectotorneos.infra.mappers;


import com.proyectotorneos.domain.model.HabilidadJugador;
import com.proyectotorneos.domain.model.TipoHabilidad;
import com.proyectotorneos.infra.entities.HabilidadJugadorEntity;
import com.proyectotorneos.infra.entities.TipoHabilidadEntity;
import org.springframework.stereotype.Component;

@Component
public class HabilidadJugadorMapper {

    private final TipoHabilidadMapper tipoHabilidadMapper;

    public HabilidadJugadorMapper() {
        this.tipoHabilidadMapper = new TipoHabilidadMapper();
    }

    public HabilidadJugadorEntity toEntity(HabilidadJugador habilidadJugador) {
        HabilidadJugadorEntity entity = new HabilidadJugadorEntity();
        TipoHabilidadEntity tipoHabilidadEntity;

        entity.setId(habilidadJugador.getId());
        entity.setDescripcion(habilidadJugador.getDescripcion());
        entity.setNombre(habilidadJugador.getNombre());

        tipoHabilidadEntity = tipoHabilidadMapper.toEntity(habilidadJugador.getTipoHabilidad());
        entity.setTipoHabilidadEntity(tipoHabilidadEntity);

        return entity;
    }

    public HabilidadJugador toDomain(HabilidadJugadorEntity habilidadJugadorEntity) {
        HabilidadJugador habilidadJugador = new HabilidadJugador();
        TipoHabilidad tipoHabilidad = tipoHabilidadMapper.toDomain(habilidadJugadorEntity.getTipoHabilidadEntity());
        habilidadJugador.setId(habilidadJugadorEntity.getId());
        habilidadJugador.setTipoHabilidad(tipoHabilidad);
        habilidadJugador.setDescripcion(habilidadJugadorEntity.getDescripcion());
        habilidadJugador.setNombre(habilidadJugadorEntity.getNombre());
        return habilidadJugador;
    }
}
