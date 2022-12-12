package com.proyectotorneos.competencia.app.api.rest.mapper;

import com.proyectotorneos.competencia.domain.model.Competencia;
import com.proyectotorneos.equipo.app.rest.dto.EquipoResponse;
import com.proyectotorneos.equipo.app.rest.mapper.EquipoRestMapper;
import com.proyectotorneos.equipo.domain.model.Equipo;
import com.proyectotorneos.equipo.domain.port.service.EquipoService;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public abstract class CompetenciaRestMapper {

    private final EquipoRestMapper equipoMapper;
    private final EquipoService equipoService;

    protected CompetenciaRestMapper(EquipoRestMapper equipoMapper, EquipoService equipoService) {
        this.equipoMapper = equipoMapper;
        this.equipoService = equipoService;
    }


    protected List<EquipoResponse> getEquipoResponses(Competencia competenciaLiga) {
        List<EquipoResponse> equipoResponses;
        equipoResponses = competenciaLiga.getEquipos()
                .stream()
                .map(equipoMapper::toResponse)
                .toList();
        return equipoResponses;
    }

    protected List<Equipo> getEquiposById(List<Integer> equiposID) {
        List<Equipo> equipos;
        equipos = equiposID
                .stream()
                .map(equipoService::buscaPorID)
                .collect(Collectors.toList());
        return equipos;
    }
}
