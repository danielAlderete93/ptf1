package com.proyectotorneos.infra.mappers;

import com.proyectotorneos.domain.model.FechaCompetitiva;
import com.proyectotorneos.domain.model.Partido;
import com.proyectotorneos.infra.entities.FechaCompetitivaEntity;
import com.proyectotorneos.infra.entities.PartidoEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class FechaCompetitivaMapper {

    private final PartidoMapper partidoMapper;


    public FechaCompetitivaMapper(PartidoMapper partidoMapper) {
        this.partidoMapper = partidoMapper;
    }

    public FechaCompetitivaEntity toEntity(FechaCompetitiva fechaCompetitiva) {
        FechaCompetitivaEntity entity = new FechaCompetitivaEntity();
        List<PartidoEntity> partidoEntityList;

        if (fechaCompetitiva == null) {
            return null;
        }

        entity.setNroFecha(fechaCompetitiva.getNroFecha());

        if (fechaCompetitiva.getPartidos() == null) {
            partidoEntityList = new ArrayList<>();
        } else {
            partidoEntityList = fechaCompetitiva.getPartidos().stream().map(partidoMapper::toEntity).toList();
        }


        entity.setPartidos(partidoEntityList);

        return entity;
    }


    public FechaCompetitiva toDomain(FechaCompetitivaEntity entity) {
        FechaCompetitiva fechaCompetitiva = new FechaCompetitiva();
        List<Partido> partidoList;
        fechaCompetitiva.setId(entity.getId());
        fechaCompetitiva.setNroFecha(entity.getNroFecha());

        if (entity.getPartidos() == null) {
            partidoList = new ArrayList<>();
        } else {
            partidoList = entity.getPartidos().stream()
                    .map(partidoMapper::toDomain)
                    .toList()
            ;
        }

        fechaCompetitiva.setPartidos(partidoList);

        return fechaCompetitiva;
    }
}
