package com.proyectotorneos.competencia.app.api.rest.controller;

import com.proyectotorneos.competencia.app.api.rest.dto.request.CompetenciaGrupoRequest;
import com.proyectotorneos.competencia.app.api.rest.dto.response.CompetenciaGrupoResponse;
import com.proyectotorneos.competencia.app.api.rest.mapper.CompetenciaGrupoRestMapper;
import com.proyectotorneos.competencia.domain.model.CompetenciaGrupo;
import com.proyectotorneos.competencia.domain.port.services.CompetenciaService;
import com.proyectotorneos.shared.response.dto.MessageResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/competencia/grupo/")
public class ControllerCompetenciaGrupos {
    private final CompetenciaService<CompetenciaGrupo> competenciaService;
    private final CompetenciaGrupoRestMapper competenciaGrupoRestMapper;

    public ControllerCompetenciaGrupos(CompetenciaService<CompetenciaGrupo> competenciaService, CompetenciaGrupoRestMapper competenciaGrupoRestMapper) {
        this.competenciaService = competenciaService;
        this.competenciaGrupoRestMapper = competenciaGrupoRestMapper;
    }

    @GetMapping(value = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<List<CompetenciaGrupoResponse>> getAll() {
        List<CompetenciaGrupoResponse> response;
        response = competenciaService.buscaTodas()
                .stream()
                .map(competenciaGrupoRestMapper::toResponse)
                .toList();
        return ResponseEntity.ok(response);
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<CompetenciaGrupoResponse> getByID(@PathVariable Integer id) {
        CompetenciaGrupo response;
        response = competenciaService.buscaPorID(id);
        return ResponseEntity.ok(competenciaGrupoRestMapper.toResponse(response));

    }

    @PostMapping(value = "/nuevo", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<MessageResponse> add(@RequestBody CompetenciaGrupoRequest request) {
        MessageResponse messageResponse;
        competenciaService.guarda(competenciaGrupoRestMapper.toDomain(request));

        messageResponse = new MessageResponse(
                "Nueva competencia",
                "Se salvo correctamente el torneo " + request.nombre()
        );

        return new ResponseEntity<>(messageResponse, HttpStatus.CREATED);
    }
}
