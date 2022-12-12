package com.proyectotorneos.competencia.app.api.rest.controller;

import com.proyectotorneos.competencia.app.api.rest.dto.request.CompetenciaLigaRequest;
import com.proyectotorneos.competencia.app.api.rest.dto.response.CompetenciaLigaResponse;
import com.proyectotorneos.competencia.app.api.rest.mapper.CompetenciaLigaRestMapper;
import com.proyectotorneos.competencia.domain.model.CompetenciaLiga;
import com.proyectotorneos.competencia.domain.port.services.CompetenciaService;
import com.proyectotorneos.shared.response.dto.MessageResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/competencia/liga/")
public class ControllerCompetenciaLiga {
    private final CompetenciaService<CompetenciaLiga> competenciaService;
    private final CompetenciaLigaRestMapper competenciaLigaRestMapper;

    public ControllerCompetenciaLiga(CompetenciaService<CompetenciaLiga> competenciaService, CompetenciaLigaRestMapper competenciaLigaRestMapper) {
        this.competenciaService = competenciaService;
        this.competenciaLigaRestMapper = competenciaLigaRestMapper;
    }

    @GetMapping(value = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<List<CompetenciaLigaResponse>> getAll() {
        List<CompetenciaLigaResponse> response;
        response = competenciaService.buscaTodas()
                .stream()
                .map(competenciaLigaRestMapper::toResponse)
                .toList();
        return ResponseEntity.ok(response);
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<CompetenciaLigaResponse> getByID(@PathVariable Integer id) {
        CompetenciaLiga response;
        response = competenciaService.buscaPorID(id);
        return ResponseEntity.ok(competenciaLigaRestMapper.toResponse(response));

    }

    @PostMapping(value = "/nuevo", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<MessageResponse> add(@RequestBody CompetenciaLigaRequest request) {
        MessageResponse messageResponse;
        competenciaService.guarda(competenciaLigaRestMapper.toDomain(request));

        messageResponse = new MessageResponse(
                "Nueva competencia",
                "Se salvo correctamente el torneo " + request.nombre()
        );

        return new ResponseEntity<>(messageResponse, HttpStatus.CREATED);
    }


}
