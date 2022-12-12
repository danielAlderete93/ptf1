package com.proyectotorneos.partido.app.api.rest;

import com.proyectotorneos.partido.app.api.rest.dto.PartidoRequest;
import com.proyectotorneos.partido.app.api.rest.dto.PartidoResponse;
import com.proyectotorneos.partido.app.api.rest.mapper.PartidoRestMapper;
import com.proyectotorneos.partido.domain.model.Partido;
import com.proyectotorneos.partido.domain.port.services.PartidoService;
import com.proyectotorneos.shared.response.dto.MessageResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/partido")
public class ControllerPartido {
    private final PartidoService partidoService;


    private final PartidoRestMapper partidoMapper;

    @Autowired
    public ControllerPartido(PartidoService partidoService, PartidoRestMapper partidoMapper) {
        this.partidoService = partidoService;
        this.partidoMapper = partidoMapper;
    }


    @GetMapping(value = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<List<PartidoResponse>> getAll() {
        List<PartidoResponse> partidoResponses;
        partidoResponses = partidoService.buscaTodos()
                .stream()
                .map(partidoMapper::toResponse)
                .toList();

        return ResponseEntity.ok(partidoResponses);
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<PartidoResponse> getByID(@PathVariable Integer id) {
        Partido partido = partidoService.buscaPorID(id);

        return ResponseEntity.ok(partidoMapper.toResponse(partido));
    }

    @PostMapping(value = "/nuevo", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<MessageResponse> add(@RequestBody PartidoRequest request) {
        MessageResponse messageResponse;
        Partido partido;


        partido = partidoMapper.toDomain(request);
        partidoService.guarda(partido);

        messageResponse = new MessageResponse(
                "Nuevo partido",
                "Se salvo correctamente el partido entre " +
                        partido.getNombreLocales() +
                        " vs " +
                        partido.getNombreVisitante()
        );

        return new ResponseEntity<>(messageResponse, HttpStatus.CREATED);
    }

    @GetMapping(value = "/{id}/finaliza", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<MessageResponse> finaliza(@PathVariable Integer id) {
        Partido partido = partidoService.buscaPorID(id);
        MessageResponse messageResponse;

        partidoService.finaliza(partido);

        messageResponse = new MessageResponse("Se finalizo partido"
                , "Partido entre " + partido.getNombreLocales() + " vs " + partido.getNombreVisitante() + " finalizado"
        );

        return ResponseEntity.ok(messageResponse);
    }


}
