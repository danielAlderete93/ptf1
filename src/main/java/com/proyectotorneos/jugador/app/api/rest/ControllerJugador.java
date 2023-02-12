package com.proyectotorneos.jugador.app.api.rest;


import com.proyectotorneos.equipo.domain.model.Equipo;
import com.proyectotorneos.equipo.domain.port.service.EquipoService;
import com.proyectotorneos.jugador.app.api.rest.dto.JugadorRequest;
import com.proyectotorneos.jugador.app.api.rest.dto.JugadorResponse;
import com.proyectotorneos.jugador.app.api.rest.mapper.JugadorRestMapper;
import com.proyectotorneos.jugador.domain.model.Jugador;
import com.proyectotorneos.jugador.domain.port.services.JugadorService;
import com.proyectotorneos.shared.response.dto.MessageResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/api/jugador")
public class ControllerJugador {
    private final JugadorService jugadorService;


    private final JugadorRestMapper jugadorRestMapper;

    private final EquipoService equipoService;

    @Autowired
    public ControllerJugador(JugadorService jugadorService, JugadorRestMapper jugadorRestMapper, EquipoService equipoService) {
        this.jugadorService = jugadorService;
        this.jugadorRestMapper = jugadorRestMapper;
        this.equipoService = equipoService;
    }


    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<JugadorResponse> getByID(@PathVariable Integer id) {
        Jugador jugador = jugadorService.buscaPorID(id);

        return ResponseEntity.ok(jugadorRestMapper.toResponse(jugador));
    }

    @PostMapping(value = "/nuevo", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<MessageResponse> add(@RequestBody JugadorRequest request) {
        ResponseEntity<MessageResponse> response;
        MessageResponse messageResponse;
        Equipo equipo;
        Jugador jugador;

        try {
            jugador = jugadorRestMapper.toDomain(request);
            equipo = equipoService.buscaPorID(request.equipoID());

            equipoService.agregaJugador(equipo, jugador);
            messageResponse = new MessageResponse(
                    "Creacion de jugador",
                    "Se incorporo correctamente a " + jugador.getNombre() + " en el equipo " + equipo.getNombre()
            );
            response = new ResponseEntity<>(messageResponse, HttpStatus.CREATED);
        } catch (Exception e) {
            messageResponse = new MessageResponse(
                    "Error al crear jugador",
                    e.getMessage()
            );
            response = new ResponseEntity<>(messageResponse, HttpStatus.BAD_REQUEST);
        }


        return response;
    }

    @PutMapping(value = "{idJugador}/edita", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<MessageResponse> edita(@PathVariable Integer idJugador, @RequestBody JugadorRequest request) {
        Jugador jugador;
        MessageResponse messageResponse;
        ResponseEntity<MessageResponse> response;

        try {
            jugador = jugadorRestMapper.toDomain(request);
            jugador.setId(idJugador);

            jugadorService.guarda(jugador);
            messageResponse = new MessageResponse(
                    "Edicion de jugador",
                    "Se edito correctamente al jugador " + jugador.getNombre()
            );

            response = ResponseEntity.ok(messageResponse);
        } catch (Exception e) {
            messageResponse = new MessageResponse(
                    "Error al editar jugador",
                    e.getMessage()
            );
            response = new ResponseEntity<>(messageResponse, HttpStatus.BAD_REQUEST);
        }

        return response;

    }


    @DeleteMapping(value = "{idJugador}/borrar", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<MessageResponse> borrar(@PathVariable Integer idJugador) {
        Jugador jugador;
        MessageResponse messageResponse;
        ResponseEntity<MessageResponse> response;

        try {
            jugador = jugadorService.buscaPorID(idJugador);
            jugadorService.elimina(jugador);
            messageResponse = new MessageResponse(
                    "Eliminar jugador",
                    "Se elimino correctamente al jugador " + jugador.getNombre()
            );

            response = ResponseEntity.ok(messageResponse);
        } catch (Exception e) {
            messageResponse = new MessageResponse(
                    "Error al borrar jugador",
                    e.getMessage()
            );
            response = new ResponseEntity<>(messageResponse, HttpStatus.BAD_REQUEST);
        }

        return response;

    }


}
