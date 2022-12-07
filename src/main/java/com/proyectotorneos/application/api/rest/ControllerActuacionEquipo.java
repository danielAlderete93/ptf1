package com.proyectotorneos.application.api.rest;

import com.proyectotorneos.application.api.rest.dto.request.ActuacionPartidoRequest;
import com.proyectotorneos.application.api.rest.dto.response.ActuacionEquipoResponse;
import com.proyectotorneos.application.api.rest.mapper.ActuacionEquipoRestMapper;
import com.proyectotorneos.domain.model.ActuacionEquipo;
import com.proyectotorneos.domain.model.Partido;
import com.proyectotorneos.domain.port.service.PartidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/partido")
public class ControllerActuacionEquipo {
    private final PartidoService partidoService;

    private final ActuacionEquipoRestMapper actuacionEquipoRestMapper;

    @Autowired
    public ControllerActuacionEquipo(PartidoService partidoService, ActuacionEquipoRestMapper actuacionEquipoRestMapper) {
        this.partidoService = partidoService;
        this.actuacionEquipoRestMapper = actuacionEquipoRestMapper;
    }


    @PostMapping(value = "/{idPartido}/actuacion/local", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<?> addLocal(@PathVariable Integer idPartido, @RequestBody ActuacionPartidoRequest request) {
        Partido partido = partidoService.buscaPorID(idPartido);
        ActuacionEquipo actuacionEquipo = actuacionEquipoRestMapper.toDomain(request);

        actuacionEquipo.setId(request.actuacionID());

        partido.setActuacionEquipoLocal(actuacionEquipo);

        partidoService.guarda(partido);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping(value = "/{idPartido}/actuacion/local", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<ActuacionEquipoResponse> getLocal(@PathVariable Integer idPartido) {
        Partido partido = partidoService.buscaPorID(idPartido);
        ActuacionEquipoResponse actuacionEquipo = actuacionEquipoRestMapper.toResponse(partido.getActuacionEquipoLocal());

        return ResponseEntity.ok(actuacionEquipo);
    }

    @PostMapping(value = "/{idPartido}/actuacion/visitante", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<?> addVisitante(@PathVariable Integer idPartido, @RequestBody ActuacionPartidoRequest request) {
        Partido partido = partidoService.buscaPorID(idPartido);
        ActuacionEquipo actuacionEquipo = actuacionEquipoRestMapper.toDomain(request);

        actuacionEquipo.setId(request.actuacionID());

        partido.setActuacionEquipoVisitante(actuacionEquipo);

        partidoService.guarda(partido);


        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping(value = "/{idPartido}/actuacion/visitante", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<ActuacionEquipoResponse> getVisitante(@PathVariable Integer idPartido) {
        Partido partido = partidoService.buscaPorID(idPartido);
        ActuacionEquipoResponse actuacionEquipo = actuacionEquipoRestMapper.toResponse(partido.getActuacionEquipoVisitante());

        return ResponseEntity.ok(actuacionEquipo);
    }
}
