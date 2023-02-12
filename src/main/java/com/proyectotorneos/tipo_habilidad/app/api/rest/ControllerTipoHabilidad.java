package com.proyectotorneos.tipo_habilidad.app.api.rest;

import com.proyectotorneos.shared.response.dto.MessageResponse;
import com.proyectotorneos.tipo_habilidad.app.api.rest.dto.TipoHabilidadRequest;
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

@CrossOrigin(origins = "*", allowedHeaders = "*")
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
        ResponseEntity<MessageResponse> res;
        MessageResponse messageResponse;
        try {
            tipoHabilidadService.guarda(mapper.toDomain(request));
            messageResponse = new MessageResponse(
                    "Nuevo tipo de habilidad",
                    "Se salvo correctamente el tipo de habilidad: " + request.nombre() + "."
            );
            res = new ResponseEntity<>(messageResponse, HttpStatus.CREATED);
        } catch (Exception e) {
            messageResponse = new MessageResponse(
                    "Error al eliminar tipo habilidad",
                    e.getMessage()
            );
            res = new ResponseEntity<>(messageResponse, HttpStatus.BAD_REQUEST);
        }

        return res;
    }

    @PutMapping(value = "/{id}/edit", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<MessageResponse> edit(@PathVariable Integer id, @RequestBody TipoHabilidadRequest request) {
        ResponseEntity<MessageResponse> res;
        MessageResponse messageResponse;
        TipoHabilidad tipoHabilidad;
        try {
            tipoHabilidad = mapper.toDomain(request);
            tipoHabilidad.setId(id);
            tipoHabilidadService.guarda(tipoHabilidad);
            messageResponse = new MessageResponse(
                    "Edicion tipo de habilidad",
                    "Se salvo correctamente el tipo de habilidad: " + request.nombre() + "."
            );
            res = new ResponseEntity<>(messageResponse, HttpStatus.CREATED);
        } catch (Exception e) {
            messageResponse = new MessageResponse(
                    "Error al eliminar tipo habilidad",
                    e.getMessage()
            );
            res = new ResponseEntity<>(messageResponse, HttpStatus.BAD_REQUEST);
        }

        return res;
    }


    @DeleteMapping(value = "/{id}/borrar", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<MessageResponse> delete(@PathVariable Integer id) {
        ResponseEntity<MessageResponse> res;
        MessageResponse messageResponse;
        try {
            TipoHabilidad tipoHabilidad = tipoHabilidadService.buscaPorID(id);
            tipoHabilidadService.elimina(tipoHabilidad);
            messageResponse = new MessageResponse(
                    "Eliminar tipo de habilidad",
                    "Se elimino correctamente el tipo de habilidad:" + tipoHabilidad.getNombre()
            );
            res = new ResponseEntity<>(messageResponse, HttpStatus.CREATED);
        } catch (Exception e) {
            messageResponse = new MessageResponse(
                    "Error al eliminar tipo habilidad",
                    e.getMessage()
            );
            res = new ResponseEntity<>(messageResponse, HttpStatus.BAD_REQUEST);
        }


        return res;
    }

}