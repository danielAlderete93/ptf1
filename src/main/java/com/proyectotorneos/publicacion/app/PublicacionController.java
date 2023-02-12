package com.proyectotorneos.publicacion.app;

import com.proyectotorneos.publicacion.app.dto.PublicacionRequest;
import com.proyectotorneos.publicacion.app.dto.PublicacionResponse;
import com.proyectotorneos.publicacion.app.mapper.PublicacionRestMapper;
import com.proyectotorneos.publicacion.domain.model.Publicacion;
import com.proyectotorneos.publicacion.domain.port.services.PublicacionService;
import com.proyectotorneos.shared.response.dto.MessageResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/api/publicacion")
public class PublicacionController {

    private final PublicacionRestMapper mapper;
    private final PublicacionService publicacionService;

    @Autowired
    public PublicacionController(PublicacionRestMapper mapper, PublicacionService publicacionService) {
        this.mapper = mapper;
        this.publicacionService = publicacionService;
    }


    @GetMapping(value = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<List<PublicacionResponse>> getAll() {
        List<PublicacionResponse> publicaciones;

        publicaciones = publicacionService.buscaTodos()
                .stream()
                .map(publicacion -> mapper.toResponse(publicacion))
                .toList();


        return ResponseEntity.ok(publicaciones);
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<PublicacionResponse> getByID(@PathVariable Integer id) {
        PublicacionResponse publicacion;

        publicacion = mapper.toResponse(publicacionService.buscaPorID(id));

        return ResponseEntity.ok(publicacion);

    }

    @PostMapping(value = "/nuevo", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<MessageResponse> create(@RequestBody PublicacionRequest request) {
        ResponseEntity<MessageResponse> res;
        MessageResponse msg;
        try {
            publicacionService.guarda(mapper.toDomain(request));
            msg = new MessageResponse(
                    "Nueva publicacion",
                    "Se salvo correctamente la publicacion."
            );
            res = new ResponseEntity<>(msg, HttpStatus.CREATED);
        } catch (Exception e) {
            msg = new MessageResponse(
                    "Error al crear publicacion",
                    e.getMessage()
            );
            res = new ResponseEntity<>(msg, HttpStatus.BAD_REQUEST);
        }

        return res;

    }

    @PutMapping(value = "/{id}/edit", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<MessageResponse> edit(@PathVariable Integer id, @RequestBody PublicacionRequest request) {
        ResponseEntity<MessageResponse> res;
        MessageResponse msg;
        try {
            Publicacion publicacion = mapper.toDomain(request);
            publicacion.setId(id);
            publicacionService.guarda(publicacion);

            msg = new MessageResponse(
                    "Editar publicacion",
                    "Se edito correctamente la publicacion."
            );
            res = new ResponseEntity<>(msg, HttpStatus.CREATED);
        } catch (Exception e) {
            msg = new MessageResponse(
                    "Error al editar publicacion",
                    e.getMessage()
            );
            res = new ResponseEntity<>(msg, HttpStatus.BAD_REQUEST);
        }

        return res;

    }

    @DeleteMapping(value = "/{id}/borrar", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<MessageResponse> edit(@PathVariable Integer id) {
        ResponseEntity<MessageResponse> res;
        MessageResponse msg;
        try {
            publicacionService.elimina(publicacionService.buscaPorID(id));
            msg = new MessageResponse(
                    "Eliminar publicacion",
                    "Se elimino correctamente la publicacion."
            );
            res = new ResponseEntity<>(msg, HttpStatus.CREATED);
        } catch (Exception e) {
            msg = new MessageResponse(
                    "Error al eliminar publicacion",
                    e.getMessage()
            );
            res = new ResponseEntity<>(msg, HttpStatus.BAD_REQUEST);
        }

        return res;

    }
}
