package com.proyectotorneos.application.api.rest;

import com.proyectotorneos.application.api.rest.dto.request.PosicionJuegoRequest;
import com.proyectotorneos.application.api.rest.dto.response.MessageResponse;
import com.proyectotorneos.application.api.rest.dto.response.PosicionJuegoResponse;
import com.proyectotorneos.application.api.rest.mapper.PosicionJuegoRestMapper;
import com.proyectotorneos.domain.model.PosicionJuego;
import com.proyectotorneos.domain.port.service.PosicionJuegoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/posicion")
public class ControllerPosicionJuego {
    private final PosicionJuegoService posicionJuegoService;
    private final PosicionJuegoRestMapper mapper;

    @Autowired
    public ControllerPosicionJuego(PosicionJuegoService posicionJuegoService, PosicionJuegoRestMapper mapper) {
        this.posicionJuegoService = posicionJuegoService;
        this.mapper = mapper;
    }


    @GetMapping(value = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<List<PosicionJuegoResponse>> getAll() {
        List<PosicionJuegoResponse> posicionJuegoList;
        posicionJuegoList = posicionJuegoService.buscaTodos()
                .stream()
                .map(mapper::toResponse)
                .toList();
        return ResponseEntity.ok(posicionJuegoList);
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<PosicionJuegoResponse> getByID(@PathVariable Integer id) {
        PosicionJuego posicionJuego;
        posicionJuego = posicionJuegoService.buscaPorID(id);
        return ResponseEntity.ok(mapper.toResponse(posicionJuego));
    }

    @PostMapping(value = "/nuevo", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<MessageResponse> add(@RequestBody PosicionJuegoRequest request) {
        MessageResponse messageResponse;
        posicionJuegoService.guarda(mapper.toDomain(request));

        messageResponse = new MessageResponse(
                "Nuevo posicion de juego",
                "Se salvo correctamente la posicion de juego."
        );
        return new ResponseEntity<>(messageResponse,HttpStatus.CREATED);
    }
}
