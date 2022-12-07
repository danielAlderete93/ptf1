package com.proyectotorneos.application.api.rest;

import com.proyectotorneos.application.api.rest.dto.request.TipoHabilidadRequest;
import com.proyectotorneos.application.api.rest.dto.response.TipoHabilidadResponse;
import com.proyectotorneos.application.api.rest.mapper.TipoHabilidadRestMapper;
import com.proyectotorneos.domain.model.TipoHabilidad;
import com.proyectotorneos.domain.port.service.TipoHabilidadService;
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
    public ResponseEntity<?> add(@RequestBody TipoHabilidadRequest request) {
        tipoHabilidadService.guarda(mapper.toDomain(request));
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
