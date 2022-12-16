package com.proyectotorneos.habilidad.app.api.rest.mapper;

import com.proyectotorneos.habilidad.app.api.rest.dto.HabilidadJugadorRequest;
import com.proyectotorneos.habilidad.app.api.rest.dto.HabilidadJugadorResponse;
import com.proyectotorneos.habilidad.domain.model.HabilidadJugador;
import com.proyectotorneos.tipo_habilidad.app.api.rest.mapper.TipoHabilidadRestMapper;
import com.proyectotorneos.tipo_habilidad.domain.port.services.TipoHabilidadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class HabilidadJugadorRestMapper {

    private final TipoHabilidadService tipoHabilidadService;
    private final TipoHabilidadRestMapper tipoHabilidadRestMapper;

    @Autowired
    public HabilidadJugadorRestMapper(TipoHabilidadService tipoHabilidadService, TipoHabilidadRestMapper tipoHabilidadRestMapper) {

        this.tipoHabilidadService = tipoHabilidadService;
        this.tipoHabilidadRestMapper = tipoHabilidadRestMapper;
    }


    public HabilidadJugadorResponse toResponse(HabilidadJugador habilidadJugador) {

        if (habilidadJugador == null) {
            return null;
        }

        return new HabilidadJugadorResponse(
                habilidadJugador.getId(),
                habilidadJugador.getNombre(),
                habilidadJugador.getDescripcion(),
                tipoHabilidadRestMapper.toResponse(habilidadJugador.getTipoHabilidad())
        );
    }

    public HabilidadJugador toDomain(HabilidadJugadorRequest request) {


        if (request == null) {
            return null;
        }

        return HabilidadJugador.builder()
                .descripcion(request.descripcion())
                .nombre(request.nombre())
                .tipoHabilidad(tipoHabilidadService.buscaPorID(request.tipoHabilidadID()))
                .build();
    }
}
