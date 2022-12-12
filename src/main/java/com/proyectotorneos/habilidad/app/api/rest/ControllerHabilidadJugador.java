package com.proyectotorneos.habilidad.app.api.rest;

import com.proyectotorneos.habilidad.app.api.rest.dto.HabilidadJugadorRequest;
import com.proyectotorneos.habilidad.app.api.rest.dto.HabilidadJugadorResponse;
import com.proyectotorneos.shared.response.dto.MessageResponse;
import com.proyectotorneos.habilidad.app.api.rest.mapper.HabilidadJugadorRestMapper;
import com.proyectotorneos.habilidad.domain.model.HabilidadJugador;
import com.proyectotorneos.habilidad.domain.port.services.HabilidadJugadorService;
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
    public ResponseEntity<MessageResponse> add(@RequestBody HabilidadJugadorRequest request) {
        MessageResponse messageResponse;
        habilidadJugadorService.guarda(mapper.toDomain(request));


        messageResponse = new MessageResponse(
                "Nueva habilidad",
                "Se salvo correctamente la habilidad."
        );
        return new ResponseEntity<>(messageResponse, HttpStatus.CREATED);
    }
}
