package com.proyectotorneos.application.api.rest;

import com.proyectotorneos.application.api.rest.dto.request.HabilidadJugadorRequest;
import com.proyectotorneos.application.api.rest.dto.response.HabilidadJugadorResponse;
import com.proyectotorneos.application.api.rest.mapper.HabilidadJugadorRestMapper;
import com.proyectotorneos.domain.model.HabilidadJugador;
import com.proyectotorneos.domain.port.service.HabilidadJugadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/habilidad")
public class ControllerHabilidadJugador {
    private final HabilidadJugadorService habilidadJugadorService;

    private final HabilidadJugadorRestMapper mapper;

    @Autowired
    public ControllerHabilidadJugador(HabilidadJugadorService habilidadJugadorService, HabilidadJugadorRestMapper mapper) {
        this.habilidadJugadorService = habilidadJugadorService;
        this.mapper = mapper;
    }


    @GetMapping(value = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<List<HabilidadJugadorResponse>> getAll() {
        List<HabilidadJugadorResponse> habilidadJugadorResponses;
        habilidadJugadorResponses = habilidadJugadorService.getAll()
                .stream()
                .map(mapper::toResponse)
                .toList();

        return ResponseEntity.ok(habilidadJugadorResponses);
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<HabilidadJugadorResponse> getByID(@PathVariable Integer id) {
        HabilidadJugador habilidadJugador = habilidadJugadorService.buscaPorID(id);

        return ResponseEntity.ok(mapper.toResponse(habilidadJugador));
    }

    @PostMapping(value = "/nuevo", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<?> add(@RequestBody HabilidadJugadorRequest request) {

        habilidadJugadorService.guarda(mapper.toDomain(request));

        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
