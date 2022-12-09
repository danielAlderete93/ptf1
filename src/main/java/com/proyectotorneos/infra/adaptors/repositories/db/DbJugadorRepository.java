package com.proyectotorneos.infra.adaptors.repositories.db;

import com.proyectotorneos.domain.model.Jugador;
import com.proyectotorneos.infra.entities.repositories.JugadorRepository;
import com.proyectotorneos.infra.adaptors.repositories.JugadorRepositoryJPA;
import com.proyectotorneos.infra.entities.JugadorEntity;
import com.proyectotorneos.infra.mappers.JugadorMapper;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@Transactional
public class DbJugadorRepository implements JugadorRepository {

    private final JugadorRepositoryJPA jugadorRepositoryJPA;
    private final JugadorMapper jugadorMapper;


    public DbJugadorRepository(JugadorRepositoryJPA jugadorRepositoryJPA, JugadorMapper jugadorMapper) {
        this.jugadorRepositoryJPA = jugadorRepositoryJPA;
        this.jugadorMapper = jugadorMapper;
    }

    @Override
    public void alta(Jugador o) {
        this.jugadorRepositoryJPA.saveAndFlush(jugadorMapper.toEntity(o));
    }

    @Override
    public Jugador getById(Integer id) {
        JugadorEntity entity;
        entity = jugadorRepositoryJPA.findById(id).orElseThrow(() -> new ResourceNotFoundException("Recurso no encontrado"));

        return jugadorMapper.toDomain(entity);
    }

    @Override
    public List<Jugador> getAll() {
        List<JugadorEntity> entityList;
        entityList = jugadorRepositoryJPA.findAll();

        return entityList.stream().map(jugadorMapper::toDomain).toList();
    }

    @Override
    public void elimina(Jugador o) {

    }
}
