package com.proyectotorneos.torneo.app.mapper;

import com.proyectotorneos.shared.domain.model.Identificable;
import com.proyectotorneos.torneo.app.dto.TorneoRequest;
import com.proyectotorneos.torneo.app.dto.TorneoResponse;
import com.proyectotorneos.torneo.domain.model.Torneo;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TorneoRestMapper {

    public TorneoResponse toResponse(Torneo torneo) {
        Integer idCompetencia;
        List<Integer> publicaciones;
        if (torneo == null) {
            return null;
        }

        idCompetencia = torneo.getCompetencia().getId();
        publicaciones = torneo.getPublicaciones().stream()
                .map(Identificable::getId)
                .toList();

        return new TorneoResponse(
                torneo.getId(),
                torneo.getNombre(),
                torneo.getDescripcion(),
                idCompetencia,
                publicaciones
        );

    }

    public Torneo toDomain(TorneoRequest request) {
        if (request == null) {
            return null;
        }


        return Torneo.builder()
                .nombre(request.nombre())
                .descripcion(request.descripcion())
                .build();
    }
}
