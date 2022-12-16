package com.proyectotorneos.habilidad.infra.mapper;


import com.proyectotorneos.habilidad.domain.model.HabilidadJugador;
import com.proyectotorneos.habilidad.infra.entities.HabilidadJugadorEntity;
import com.proyectotorneos.tipo_habilidad.infra.mapper.TipoHabilidadMapper;
import org.springframework.stereotype.Component;

@Component
public class HabilidadJugadorMapper {

    private final TipoHabilidadMapper tipoHabilidadMapper;

    public HabilidadJugadorMapper(TipoHabilidadMapper tipoHabilidadMapper) {
        this.tipoHabilidadMapper = tipoHabilidadMapper;
    }

    public HabilidadJugadorEntity toEntity(HabilidadJugador habilidadJugador) {

        return HabilidadJugadorEntity.builder()
                .id(habilidadJugador.getId())
                .descripcion(habilidadJugador.getDescripcion())
                .nombre(habilidadJugador.getNombre())
                .tipoHabilidad(tipoHabilidadMapper.toEntity(habilidadJugador.getTipoHabilidad()))
                .build();
    }

    public HabilidadJugador toDomain(HabilidadJugadorEntity habilidadJugadorEntity) {

        return HabilidadJugador.builder()
                .id(habilidadJugadorEntity.getId())
                .tipoHabilidad(tipoHabilidadMapper.toDomain(habilidadJugadorEntity.getTipoHabilidad()))
                .descripcion(habilidadJugadorEntity.getDescripcion())
                .nombre(habilidadJugadorEntity.getNombre())
                .build();
    }
}
