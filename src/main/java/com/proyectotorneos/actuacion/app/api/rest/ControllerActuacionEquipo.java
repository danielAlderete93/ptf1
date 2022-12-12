package com.proyectotorneos.actuacion.app.api.rest;

import com.proyectotorneos.actuacion.app.api.rest.dto.ActuacionPartidoRequest;
import com.proyectotorneos.actuacion.app.api.rest.dto.ActuacionEquipoResponse;
import com.proyectotorneos.shared.response.dto.MessageResponse;
import com.proyectotorneos.actuacion.app.api.rest.mapper.ActuacionEquipoRestMapper;
import com.proyectotorneos.actuacion.domain.model.ActuacionEquipo;
import com.proyectotorneos.partido.domain.model.Partido;
import com.proyectotorneos.partido.domain.port.services.PartidoService;
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
    public ResponseEntity<MessageResponse> addLocal(@PathVariable Integer idPartido, @RequestBody ActuacionPartidoRequest request) {
        MessageResponse messageResponse;
        Partido partido = partidoService.buscaPorID(idPartido);
        ActuacionEquipo actuacionEquipo = actuacionEquipoRestMapper.toDomain(request);

        actuacionEquipo.setId(request.actuacionID());

        partido.setActuacionEquipoLocal(actuacionEquipo);

        partidoService.guarda(partido);

        messageResponse = new MessageResponse(
                "Actualizacion de actuacion del equipo locales",
                "Se salvo correctamente la actuacion del equipo" + actuacionEquipo.getEquipo().getNombre()
        );

        return new ResponseEntity<>(messageResponse, HttpStatus.CREATED);
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
    public ResponseEntity<MessageResponse> addVisitante(@PathVariable Integer idPartido, @RequestBody ActuacionPartidoRequest request) {
        MessageResponse messageResponse;
        Partido partido = partidoService.buscaPorID(idPartido);
        ActuacionEquipo actuacionEquipo = actuacionEquipoRestMapper.toDomain(request);

        actuacionEquipo.setId(request.actuacionID());

        partido.setActuacionEquipoVisitante(actuacionEquipo);

        partidoService.guarda(partido);


        messageResponse = new MessageResponse(
                "Actualizacion de actuacion del equipo visitante",
                "Se salvo correctamente la actuacion del equipo" + actuacionEquipo.getEquipo().getNombre()
        );

        return new ResponseEntity<>(messageResponse, HttpStatus.CREATED);
    }

    @GetMapping(value = "/{idPartido}/actuacion/visitante", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<ActuacionEquipoResponse> getVisitante(@PathVariable Integer idPartido) {
        Partido partido = partidoService.buscaPorID(idPartido);
        ActuacionEquipoResponse actuacionEquipo = actuacionEquipoRestMapper.toResponse(partido.getActuacionEquipoVisitante());

        return ResponseEntity.ok(actuacionEquipo);
    }
}
