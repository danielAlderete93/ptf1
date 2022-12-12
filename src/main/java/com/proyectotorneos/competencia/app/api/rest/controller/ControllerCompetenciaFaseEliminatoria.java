package com.proyectotorneos.competencia.app.api.rest.controller;

import com.proyectotorneos.competencia.app.api.rest.dto.request.CompetenciaFaseEliminatoriaRequest;
import com.proyectotorneos.competencia.app.api.rest.dto.response.CompetenciaFaseEliminatoriaResponse;
import com.proyectotorneos.competencia.app.api.rest.mapper.CompetenciaFaseEliminatoriaRestMapper;
import com.proyectotorneos.competencia.domain.model.CompetenciaFaseEliminatoria;
import com.proyectotorneos.competencia.domain.port.services.CompetenciaService;
import com.proyectotorneos.shared.response.dto.MessageResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/competencia/eliminatoria/")
public class ControllerCompetenciaFaseEliminatoria {

    private final CompetenciaService<CompetenciaFaseEliminatoria> competenciaService;
    private final CompetenciaFaseEliminatoriaRestMapper competenciaFaseEliminatoriaRestMapper;

    @Autowired
    public ControllerCompetenciaFaseEliminatoria(CompetenciaService<CompetenciaFaseEliminatoria> competenciaService, CompetenciaFaseEliminatoriaRestMapper competenciaFaseEliminatoriaRestMapper) {
        this.competenciaService = competenciaService;
        this.competenciaFaseEliminatoriaRestMapper = competenciaFaseEliminatoriaRestMapper;
    }

    @GetMapping(value = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<List<CompetenciaFaseEliminatoriaResponse>> getAll() {
        List<CompetenciaFaseEliminatoriaResponse> response;
        response = competenciaService.buscaTodas()
                .stream()
                .map(competenciaFaseEliminatoriaRestMapper::toResponse)
                .toList();
        return ResponseEntity.ok(response);
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<CompetenciaFaseEliminatoriaResponse> getByID(@PathVariable Integer id) {
        CompetenciaFaseEliminatoria response;
        response = competenciaService.buscaPorID(id);
        return ResponseEntity.ok(competenciaFaseEliminatoriaRestMapper.toResponse(response));

    }

    @PostMapping(value = "/nuevo", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<MessageResponse> add(@RequestBody CompetenciaFaseEliminatoriaRequest request) {
        MessageResponse messageResponse;
        competenciaService.guarda(competenciaFaseEliminatoriaRestMapper.toDomain(request));

        messageResponse = new MessageResponse(
                "Nueva competencia eliminatoria",
                "Se salvo la fase eliminatoria " + request.nombre()
        );

        return new ResponseEntity<>(messageResponse, HttpStatus.CREATED);
    }

}
