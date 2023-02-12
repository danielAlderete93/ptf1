package com.proyectotorneos.torneo.app;

import com.proyectotorneos.shared.response.dto.MessageResponse;
import com.proyectotorneos.torneo.app.dto.TorneoRequest;
import com.proyectotorneos.torneo.app.dto.TorneoResponse;
import com.proyectotorneos.torneo.app.mapper.TorneoRestMapper;
import com.proyectotorneos.torneo.domain.model.Torneo;
import com.proyectotorneos.torneo.domain.port.service.TorneoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/api/torneo")
public class ControllerTorneo {
    private final TorneoService torneoService;
    private final TorneoRestMapper mapper;

    public ControllerTorneo(TorneoService torneoService, TorneoRestMapper mapper) {
        this.torneoService = torneoService;
        this.mapper = mapper;
    }

    @Autowired


    @GetMapping(value = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<List<TorneoResponse>> getAll() {
        List<TorneoResponse> torneoResponseList;
        torneoResponseList = torneoService.buscaTodos()
                .stream()
                .map(mapper::toResponse)
                .toList();
        return ResponseEntity.ok(torneoResponseList);
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<TorneoResponse> getByID(@PathVariable Integer id) {
        Torneo torneo;

        torneo = torneoService.buscaPorID(id);

        return ResponseEntity.ok(mapper.toResponse(torneo));
    }

    @PostMapping(value = "/nuevo", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<MessageResponse> add(@RequestBody TorneoRequest request) {
        ResponseEntity<MessageResponse> res;
        MessageResponse messageResponse;
        try {
            torneoService.guarda(mapper.toDomain(request));
            messageResponse = new MessageResponse(
                    "Nuevo Torneo",
                    "Se salvo correctamente el torneo: " + request.nombre() + "."
            );
            res = new ResponseEntity<>(messageResponse, HttpStatus.CREATED);
        } catch (Exception e) {
            messageResponse = new MessageResponse(
                    "Error al eliminar torneo",
                    e.getMessage()
            );
            res = new ResponseEntity<>(messageResponse, HttpStatus.BAD_REQUEST);
        }

        return res;
    }

    @PutMapping(value = "/{id}/edit", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<MessageResponse> edit(@PathVariable Integer id, @RequestBody TorneoRequest request) {
        ResponseEntity<MessageResponse> res;
        MessageResponse messageResponse;
        Torneo torneo;
        try {
            torneo = mapper.toDomain(request);
            torneo.setId(id);
            torneoService.guarda(torneo);
            messageResponse = new MessageResponse(
                    "Edicion torneo",
                    "Se salvo correctamente el torneo: " + request.nombre() + "."
            );
            res = new ResponseEntity<>(messageResponse, HttpStatus.CREATED);
        } catch (Exception e) {
            messageResponse = new MessageResponse(
                    "Error al eliminar torneo",
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
            Torneo torneo = torneoService.buscaPorID(id);
            torneoService.elimina(torneo);
            messageResponse = new MessageResponse(
                    "Eliminar torneo",
                    "Se elimino correctamente el torneo:" + torneo.getNombre()
            );
            res = new ResponseEntity<>(messageResponse, HttpStatus.CREATED);
        } catch (Exception e) {
            messageResponse = new MessageResponse(
                    "Error al eliminar torneo",
                    e.getMessage()
            );
            res = new ResponseEntity<>(messageResponse, HttpStatus.BAD_REQUEST);
        }


        return res;
    }

}