package com.proyectotorneos.tipo_habilidad.app.api.rest;

import com.proyectotorneos.tipo_habilidad.app.api.rest.dto.TipoHabilidadRequest;
import com.proyectotorneos.shared.response.dto.MessageResponse;
import com.proyectotorneos.tipo_habilidad.app.api.rest.dto.TipoHabilidadResponse;
import com.proyectotorneos.tipo_habilidad.app.api.rest.mapper.TipoHabilidadRestMapper;
import com.proyectotorneos.tipo_habilidad.domain.model.TipoHabilidad;
import com.proyectotorneos.tipo_habilidad.domain.port.services.TipoHabilidadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tipo-habilidad")
public class ControllerTipoHabilidad {
    private final TipoHabilidadService tipoHabilidadService;
    private final TipoHabilidadRestMapper mapper;

    @Autowired
    public ControllerTipoHabilidad(TipoHabilidadService tipoHabilidadService, TipoHabilidadRestMapper mapper) {
        this.tipoHabilidadService = tipoHabilidadService;
        this.mapper = mapper;
    }


    @GetMapping(value = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<List<TipoHabilidadResponse>> getAll() {
        List<TipoHabilidadResponse> tipoHabilidadResponseList;
        tipoHabilidadResponseList = tipoHabilidadService.buscaTodos()
                .stream()
                .map(mapper::toResponse)
                .toList();
        return ResponseEntity.ok(tipoHabilidadResponseList);
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<TipoHabilidadResponse> getByID(@PathVariable Integer id) {
        TipoHabilidad tipoHabilidad;

        tipoHabilidad = tipoHabilidadService.buscaPorID(id);

        return ResponseEntity.ok(mapper.toResponse(tipoHabilidad));
    }

    @PostMapping(value = "/nuevo", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<MessageResponse> add(@RequestBody TipoHabilidadRequest request) {
        MessageResponse messageResponse;

        tipoHabilidadService.guarda(mapper.toDomain(request));
        messageResponse = new MessageResponse(
                "Nuevo tipo de habilidad",
                "Se salvo correctamente el tipo de habilidad."
        );

        return new ResponseEntity<>(messageResponse, HttpStatus.CREATED);
    }
}
