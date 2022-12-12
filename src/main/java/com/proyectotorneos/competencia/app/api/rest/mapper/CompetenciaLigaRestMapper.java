package com.proyectotorneos.competencia.app.api.rest.mapper;

import com.proyectotorneos.competencia.app.api.rest.dto.request.CompetenciaLigaRequest;
import com.proyectotorneos.competencia.app.api.rest.dto.response.CompetenciaLigaResponse;
import com.proyectotorneos.competencia.domain.model.CompetenciaLiga;
import com.proyectotorneos.equipo.app.rest.mapper.EquipoRestMapper;
import com.proyectotorneos.equipo.domain.port.service.EquipoService;
import com.proyectotorneos.shared.domain.model.Identificable;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
public class CompetenciaLigaRestMapper extends CompetenciaRestMapper {

    public CompetenciaLigaRestMapper(EquipoRestMapper equipoMapper, EquipoService equipoService) {
        super(equipoMapper, equipoService);
    }

    public CompetenciaLigaResponse toResponse(CompetenciaLiga competenciaLiga) {

        List<Integer> fechasID;
        if (null == competenciaLiga) {
            return null;
        }


        fechasID = competenciaLiga.getFechas()
                .stream()
                .map(Identificable::getId)
                .toList();

        return new CompetenciaLigaResponse(
                competenciaLiga.getId(),
                competenciaLiga.getNombre(),
                getEquipoResponses(competenciaLiga),
                fechasID
        );
    }


    public CompetenciaLiga toDomain(CompetenciaLigaRequest request) {

        if (null == request) {
            return null;
        }

        return CompetenciaLiga.builder()
                .fechas(new ArrayList<>())
                .equipos(getEquiposById(request.equipoID()))
                .nombre(request.nombre())
                .build();

    }


}
