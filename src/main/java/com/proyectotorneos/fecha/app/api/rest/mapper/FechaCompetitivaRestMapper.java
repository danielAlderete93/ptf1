package com.proyectotorneos.fecha.app.api.rest.mapper;

import com.proyectotorneos.fecha.app.api.rest.dto.FechaCompetitivaRequest;
import com.proyectotorneos.fecha.app.api.rest.dto.FechaCompetitivaResponse;
import com.proyectotorneos.fecha.domain.model.FechaCompetitiva;
import com.proyectotorneos.partido.app.api.rest.mapper.PartidoRestMapper;
import com.proyectotorneos.partido.domain.model.Partido;
import com.proyectotorneos.shared.domain.model.Identificable;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class FechaCompetitivaRestMapper {
    private final PartidoRestMapper partidoRestMapper;

    public FechaCompetitivaRestMapper(PartidoRestMapper partidoRestMapper) {
        this.partidoRestMapper = partidoRestMapper;
    }

    public FechaCompetitivaResponse toResponse(FechaCompetitiva fechaCompetitiva) {

        if (fechaCompetitiva == null) {
            return null;
        }

        return new FechaCompetitivaResponse(
                fechaCompetitiva.getId(),
                fechaCompetitiva.getNroFecha(),
                fechaCompetitiva.getPartidos().stream()
                        .map(Identificable::getId)
                        .collect(Collectors.toList())
        );
    }

    public FechaCompetitiva toDomain(FechaCompetitivaRequest request) {
        List<Partido> partidoList;

        if (request == null) {
            return null;
        }

        partidoList = request.partidoRequests().stream()
                .map(partidoRestMapper::toDomain)
                .collect(Collectors.toList())
        ;

        return FechaCompetitiva.builder()
                .nroFecha(request.nroFecha())
                .partidos(partidoList)
                .build();
    }
}
