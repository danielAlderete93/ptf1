package com.proyectotorneos.equipo.app.rest.controller;

import com.proyectotorneos.equipo.app.rest.dto.EquipoRequest;
import com.proyectotorneos.equipo.app.rest.dto.EquipoResponse;
import com.proyectotorneos.jugador.app.api.rest.dto.JugadorResponse;
import com.proyectotorneos.shared.response.dto.MessageResponse;
import com.proyectotorneos.equipo.app.rest.mapper.EquipoRestMapper;
import com.proyectotorneos.jugador.app.api.rest.mapper.JugadorRestMapper;
import com.proyectotorneos.equipo.domain.model.Equipo;
import com.proyectotorneos.equipo.domain.port.service.EquipoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/equipo")
public class ControllerEquipo {

    private final EquipoService equipoService;

    private final EquipoRestMapper equipoMapper;

    private final JugadorRestMapper jugadorRestMapper;

    @Autowired
    public ControllerEquipo(EquipoService equipoService, EquipoRestMapper equipoMapper, JugadorRestMapper jugadorRestMapper) {
        this.equipoService = equipoService;
        this.equipoMapper = equipoMapper;
        this.jugadorRestMapper = jugadorRestMapper;
    }


    @GetMapping(value = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<List<EquipoResponse>> getAll() {
        List<EquipoResponse> equipoResponses;
        equipoResponses = equipoService.getAll().stream().map(equipoMapper::toResponse).toList();
        return ResponseEntity.ok(equipoResponses);
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<EquipoResponse> getByID(@PathVariable Integer id) {
        Equipo equipo;
        equipo = equipoService.buscaPorID(id);
        return ResponseEntity.ok(equipoMapper.toResponse(equipo));

    }

    @PostMapping(value = "/nuevo", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<MessageResponse> add(@RequestBody EquipoRequest request) {
        MessageResponse messageResponse;
        equipoService.guarda(equipoMapper.toDomain(request));

        messageResponse = new MessageResponse(
                "Nuevo Equipo",
                "Se salvo correctamente el equipo"
        );

        return new ResponseEntity<>(messageResponse, HttpStatus.CREATED);
    }

    @GetMapping(value = "/{id}/jugadores", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<List<JugadorResponse>> getAll(@PathVariable Integer id) {
        Equipo equipo;
        List<JugadorResponse> jugadorResponses;

        equipo = equipoService.buscaPorID(id);

        jugadorResponses = equipo.getJugadores()
                .stream()
                .map(jugadorRestMapper::toResponse)
                .toList();

        return ResponseEntity.ok(jugadorResponses);
    }




}
