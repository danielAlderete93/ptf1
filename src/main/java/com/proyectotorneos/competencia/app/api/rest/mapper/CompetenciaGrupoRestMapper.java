package com.proyectotorneos.competencia.app.api.rest.mapper;

import com.proyectotorneos.competencia.app.api.rest.dto.request.CompetenciaGrupoRequest;
import com.proyectotorneos.competencia.app.api.rest.dto.response.CompetenciaGrupoResponse;
import com.proyectotorneos.competencia.app.api.rest.dto.response.CompetenciaLigaResponse;
import com.proyectotorneos.competencia.domain.model.CompetenciaGrupo;
import com.proyectotorneos.competencia.domain.model.CompetenciaLiga;
import com.proyectotorneos.equipo.app.rest.mapper.EquipoRestMapper;
import com.proyectotorneos.equipo.domain.port.service.EquipoService;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CompetenciaGrupoRestMapper extends CompetenciaRestMapper {
    private final CompetenciaLigaRestMapper competenciaLigaRestMapper;

    public CompetenciaGrupoRestMapper(EquipoRestMapper equipoMapper, EquipoService equipoService, CompetenciaLigaRestMapper competenciaLigaRestMapper) {
        super(equipoMapper, equipoService);
        this.competenciaLigaRestMapper = competenciaLigaRestMapper;
    }

    public CompetenciaGrupoResponse toResponse(CompetenciaGrupo competenciaGrupo) {

        List<CompetenciaLigaResponse> competenciaLigaResponses;
        if (null == competenciaGrupo) {
            return null;
        }

        competenciaLigaResponses = competenciaGrupo.getGrupos()
                .stream()
                .map(competenciaLigaRestMapper::toResponse)
                .toList();


        return new CompetenciaGrupoResponse(
                competenciaGrupo.getId(),
                competenciaGrupo.getNombre(),
                getEquipoResponses(competenciaGrupo),
                competenciaLigaResponses
        );
    }


    public CompetenciaGrupo toDomain(CompetenciaGrupoRequest request) {
        List<CompetenciaLiga> grupos;
        if (null == request) {
            return null;
        }

        grupos = request.grupos()
                .stream()
                .map(competenciaLigaRestMapper::toDomain)
                .collect(Collectors.toList());

        return CompetenciaGrupo.builder()
                .equipos(getEquiposById(request.equipoID()))
                .nombre(request.nombre())
                .grupos(grupos)
                .build();

    }
}
