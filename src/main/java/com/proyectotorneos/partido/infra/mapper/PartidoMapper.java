package com.proyectotorneos.partido.infra.mapper;

import com.proyectotorneos.actuacion.infra.mapper.ActuacionMapper;
import com.proyectotorneos.partido.domain.model.Partido;
import com.proyectotorneos.gol.infra.entities.PartidoEntity;
import org.springframework.stereotype.Component;

@Component
public class PartidoMapper {

    private final ActuacionMapper actuacionMapper;

    public PartidoMapper(ActuacionMapper actuacionMapper) {
        this.actuacionMapper = actuacionMapper;
    }

    public PartidoEntity toEntity(Partido partido) {
        PartidoEntity entity = new PartidoEntity();

        entity.setId(partido.getId());
        entity.setEquipoLocal(actuacionMapper.toEntity(partido.getActuacionEquipoLocal()));
        entity.setEquipoVisitante(actuacionMapper.toEntity(partido.getActuacionEquipoVisitante()));
        entity.setFecha(partido.getFecha());
        entity.setFinalizado(partido.isFinalizado());

        return entity;
    }

    public Partido toDomain(PartidoEntity entity) {
        Partido domain = new Partido();

        domain.setId(entity.getId());
        domain.setActuacionEquipoLocal(actuacionMapper.toDomain(entity.getEquipoLocal()));
        domain.setActuacionEquipoVisitante(actuacionMapper.toDomain(entity.getEquipoVisitante()));
        domain.setFecha(entity.getFecha());
        domain.setFinalizado(entity.isFinalizado());


        return domain;
    }


}