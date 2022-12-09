package com.proyectotorneos.application.api.rest;


import com.proyectotorneos.application.api.rest.dto.request.JugadorRequest;
import com.proyectotorneos.application.api.rest.dto.response.JugadorResponse;
import com.proyectotorneos.application.api.rest.dto.response.MessageResponse;
import com.proyectotorneos.application.api.rest.mapper.JugadorRestMapper;
import com.proyectotorneos.domain.model.Equipo;
import com.proyectotorneos.domain.model.Jugador;
import com.proyectotorneos.domain.port.service.EquipoService;
import com.proyectotorneos.domain.port.service.JugadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
        MessageResponse messageResponse;
        Equipo equipo;
        Jugador jugador;


        jugador = jugadorRestMapper.toDomain(request);
        equipo = equipoService.buscaPorID(request.equipoID());

        equipoService.agregaJugador(equipo, jugador);

        messageResponse = new MessageResponse(
                "Creacion de jugador",
                "Se agrego correctamente al jugador " + jugador.getNombre() + " en equipo " + equipo.getNombre()
        );

        return new ResponseEntity<>(messageResponse, HttpStatus.CREATED);
    }

    @PutMapping(value = "{idJugador}/edita", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<MessageResponse> edita(@PathVariable Integer idJugador, @RequestBody JugadorRequest request) {
        Jugador jugador;
        MessageResponse messageResponse;

        jugador = jugadorRestMapper.toDomain(request);
        jugador.setId(idJugador);

        jugadorService.guarda(jugador);
        messageResponse = new MessageResponse(
                "Edicion de jugador",
                "Se edito correctamente al jugador de id: " + idJugador
        );

        return ResponseEntity.ok(messageResponse);
    }

}
