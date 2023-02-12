package com.proyectotorneos.jugador.infra.mapper;

import com.proyectotorneos.habilidad.domain.model.HabilidadJugador;
import com.proyectotorneos.habilidad.infra.entities.HabilidadJugadorEntity;
import com.proyectotorneos.habilidad.infra.mapper.HabilidadJugadorMapper;
import com.proyectotorneos.jugador.domain.model.Jugador;
import com.proyectotorneos.jugador.infra.entities.JugadorEntity;
import com.proyectotorneos.partido.infra.entities.PosicionJuegoEntity;
import com.proyectotorneos.posicion.domain.model.PosicionJuego;
import com.proyectotorneos.posicion.infra.mapper.PosicionJuegoMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class JugadorMapper {
    private final PosicionJuegoMapper posicionJuegoMapper;
    private final HabilidadJugadorMapper habilidadJugadorMapper;

    public JugadorMapper(PosicionJuegoMapper posicionJuegoMapper, HabilidadJugadorMapper habilidadJugadorMapper) {
        this.posicionJuegoMapper = posicionJuegoMapper;
        this.habilidadJugadorMapper = habilidadJugadorMapper;
    }


    public JugadorEntity toEntity(Jugador domain) {
        PosicionJuegoEntity posicionOpcional;
        PosicionJuegoEntity posicionFavorita;
        List<HabilidadJugadorEntity> habilidadJugadorEntities;

        if (null == domain) {
            return null;
        }

        posicionOpcional = posicionJuegoMapper.toEntity(domain.getPosicionOpcional());
        posicionFavorita = posicionJuegoMapper.toEntity(domain.getPosicionFavorita());

        habilidadJugadorEntities = getHabilidadJugadorEntities(domain);

        return JugadorEntity.builder()
                .id(domain.getId())
                .fechaNacimiento(domain.getFechaNacimiento())
                .posicionOpcional(posicionOpcional)
                .posicionFavorita(posicionFavorita)
                .nombre(domain.getNombre())
                .habilidadPiernas(domain.getHabilidadPiernas())
                .habilidades(habilidadJugadorEntities)
                .build();
    }


    public Jugador toDomain(JugadorEntity entity) {
        PosicionJuego posicionFavorita;
        PosicionJuego posicionOpcional;
        List<HabilidadJugador> habilidades;

        if (null == entity) {
            return null;
        }

        posicionFavorita = posicionJuegoMapper.toDomain(entity.getPosicionFavorita());
        posicionOpcional = posicionJuegoMapper.toDomain(entity.getPosicionOpcional());

        habilidades = getHabilidadJugadores(entity);

        return Jugador.builder()
                .id(entity.getId())
                .fechaNacimiento(entity.getFechaNacimiento())
                .posicionOpcional(posicionOpcional)
                .posicionFavorita(posicionFavorita)
                .nombre(entity.getNombre())
                .habilidadPiernas(entity.getHabilidadPiernas())
                .habilidades(habilidades)
                .build();
    }

    private List<HabilidadJugador> getHabilidadJugadores(JugadorEntity entity) {
        List<HabilidadJugador> habilidades;
        habilidades = entity.getHabilidades().stream()
                .map(habilidadJugadorMapper::toDomain)
                .collect(Collectors.toList());
        return habilidades;
    }

    private List<HabilidadJugadorEntity> getHabilidadJugadorEntities(Jugador domain) {
        List<HabilidadJugadorEntity> habilidadJugadorEntities;
        habilidadJugadorEntities = domain.getHabilidades().stream()
                .map(habilidadJugadorMapper::toEntity)
                .collect(Collectors.toList());
        return habilidadJugadorEntities;
    }
}
