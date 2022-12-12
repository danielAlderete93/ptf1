package com.proyectotorneos.competencia.app.api.rest.mapper;

import com.proyectotorneos.competencia.app.api.rest.dto.request.CompetenciaFaseEliminatoriaRequest;
import com.proyectotorneos.competencia.app.api.rest.dto.response.CompetenciaFaseEliminatoriaResponse;
import com.proyectotorneos.competencia.domain.model.CompetenciaFaseEliminatoria;
import com.proyectotorneos.equipo.app.rest.mapper.EquipoRestMapper;
import com.proyectotorneos.equipo.domain.port.service.EquipoService;
import com.proyectotorneos.fecha.app.api.rest.mapper.FechaCompetitivaRestMapper;
import org.springframework.stereotype.Component;

@Component()
public class CompetenciaFaseEliminatoriaRestMapper extends CompetenciaRestMapper {
    private final FechaCompetitivaRestMapper fechaCompetitivaRestMapper;

    public CompetenciaFaseEliminatoriaRestMapper(EquipoRestMapper equipoMapper, EquipoService equipoService, FechaCompetitivaRestMapper fechaCompetitivaRestMapper) {
        super(equipoMapper, equipoService);
        this.fechaCompetitivaRestMapper = fechaCompetitivaRestMapper;
    }

    public CompetenciaFaseEliminatoriaResponse toResponse(CompetenciaFaseEliminatoria competenciaFaseEliminatoria) {

        if (null == competenciaFaseEliminatoria) {
            return null;
        }


        return new CompetenciaFaseEliminatoriaResponse(
                competenciaFaseEliminatoria.getId(),
                competenciaFaseEliminatoria.getNombre(),
                fechaCompetitivaRestMapper.toResponse(competenciaFaseEliminatoria.getFecha()),
                faseToID(competenciaFaseEliminatoria.getProximaFaseGanadora()),
                faseToID(competenciaFaseEliminatoria.getProximaFasePerdedora())
        );

    }

    private Integer faseToID(CompetenciaFaseEliminatoria competenciaFaseEliminatoria) {
        return null == competenciaFaseEliminatoria ?
                null :
                competenciaFaseEliminatoria.getId()
                ;
    }

    public CompetenciaFaseEliminatoria toDomain(CompetenciaFaseEliminatoriaRequest request) {

        if (null == request) {
            return null;
        }


        return CompetenciaFaseEliminatoria.builder()
                .equipos(getEquiposById(request.equiposID()))
                .nombre(request.nombre())
                .build();

    }
}
