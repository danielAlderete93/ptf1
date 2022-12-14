package com.proyectotorneos.fecha.app.api.rest;

import com.proyectotorneos.fecha.app.api.rest.dto.FechaCompetitivaRequest;
import com.proyectotorneos.fecha.app.api.rest.dto.FechaCompetitivaResponse;
import com.proyectotorneos.shared.response.dto.MessageResponse;
import com.proyectotorneos.fecha.app.api.rest.mapper.FechaCompetitivaRestMapper;
import com.proyectotorneos.fecha.domain.model.FechaCompetitiva;
import com.proyectotorneos.fecha.domain.port.services.FechaCompetitivaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/fecha")
public class ControllerFechaCompetitiva {
    private final FechaCompetitivaService fechaCompetitivaService;
    private final FechaCompetitivaRestMapper fechaCompetitivaRestMapper;

    @Autowired
    public ControllerFechaCompetitiva(FechaCompetitivaService fechaCompetitivaService, FechaCompetitivaRestMapper fechaCompetitivaRestMapper) {
        this.fechaCompetitivaService = fechaCompetitivaService;
        this.fechaCompetitivaRestMapper = fechaCompetitivaRestMapper;
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<FechaCompetitivaResponse> getByID(@PathVariable Integer id) {
        FechaCompetitiva fechaCompetitiva;

        fechaCompetitiva = fechaCompetitivaService.buscaPorID(id);

        return ResponseEntity.ok(fechaCompetitivaRestMapper.toResponse(fechaCompetitiva));
    }

    @PostMapping(value = "/nuevo", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<MessageResponse> getByID(@RequestBody FechaCompetitivaRequest fechaCompetitivaRequest) {
        MessageResponse messageResponse;
        FechaCompetitiva fechaCompetitiva;

        fechaCompetitiva = fechaCompetitivaRestMapper.toDomain(fechaCompetitivaRequest);
        fechaCompetitivaService.guarda(fechaCompetitiva);

        messageResponse = new MessageResponse(
                "Creacion de fecha competitiva",
                "Se agrego correctamente la fecha " + fechaCompetitiva.getNroFecha()
        );

        return new ResponseEntity<>(messageResponse, HttpStatus.CREATED);
    }
}
