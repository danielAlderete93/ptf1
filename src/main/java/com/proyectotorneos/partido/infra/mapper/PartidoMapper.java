package com.proyectotorneos.partido.infra.mapper;

import com.proyectotorneos.actuacion.domain.model.ActuacionEquipo;
import com.proyectotorneos.actuacion.infra.entities.ActuacionEquipoEntity;
import com.proyectotorneos.actuacion.infra.mapper.ActuacionMapper;
import com.proyectotorneos.gol.infra.entities.PartidoEntity;
import com.proyectotorneos.partido.domain.model.Partido;
import org.springframework.stereotype.Component;

@Component
public class PartidoMapper {

    private final ActuacionMapper actuacionMapper;

    public PartidoMapper(ActuacionMapper actuacionMapper) {
        this.actuacionMapper = actuacionMapper;
    }

    public PartidoEntity toEntity(Partido partido) {
        ActuacionEquipoEntity locales;
        ActuacionEquipoEntity visitante;

        locales = actuacionMapper.toEntity(partido.getActuacionLocal());
        visitante = actuacionMapper.toEntity(partido.getActuacionVisitante());


        return PartidoEntity.builder()
                .id(partido.getId())
                .actuacionLocal(locales)
                .actuacionVisitante(visitante)
                .fecha(partido.getFecha())
                .finalizado(partido.isFinalizado())
                .build();
    }

    public Partido toDomain(PartidoEntity entity) {
        ActuacionEquipo locales;
        ActuacionEquipo visitante;

        locales = actuacionMapper.toDomain(entity.getActuacionLocal());
        visitante = actuacionMapper.toDomain(entity.getActuacionVisitante());

        return Partido.builder()
                .id(entity.getId())
                .actuacionLocal(locales)
                .actuacionVisitante(visitante)
                .fecha(entity.getFecha())
                .finalizado(entity.isFinalizado())
                .build();
    }


}
