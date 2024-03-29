package com.proyectotorneos.posicion.infra.adaptors.repositories.db;

import com.proyectotorneos.partido.infra.entities.PosicionJuegoEntity;
import com.proyectotorneos.posicion.domain.model.PosicionJuego;
import com.proyectotorneos.posicion.domain.port.repositories.PosicionJuegoRepository;
import com.proyectotorneos.posicion.infra.adaptors.repositories.PosicionJuegoRepositoryJPA;
import com.proyectotorneos.posicion.infra.mapper.PosicionJuegoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@Transactional
public class DbPosicionJuegoRepository implements PosicionJuegoRepository {

    private final PosicionJuegoRepositoryJPA posicionJuegoRepositoryJPA;
    private final PosicionJuegoMapper posicionJuegoMapper;

    @Autowired
    public DbPosicionJuegoRepository(PosicionJuegoRepositoryJPA posicionJuegoRepositoryJPA, PosicionJuegoMapper posicionJuegoMapper) {
        this.posicionJuegoRepositoryJPA = posicionJuegoRepositoryJPA;
        this.posicionJuegoMapper = posicionJuegoMapper;
    }

    @Override
    public void alta(PosicionJuego o) {
        this.posicionJuegoRepositoryJPA.saveAndFlush(posicionJuegoMapper.toEntity(o));
    }

    @Override
    public PosicionJuego getById(Integer id) {
        PosicionJuegoEntity entity;
        entity = posicionJuegoRepositoryJPA.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Recurso no encontrado"));

        return posicionJuegoMapper.toDomain(entity);
    }

    @Override
    public PosicionJuego getByName(String name) {
        PosicionJuegoEntity posicionJuegoEntity = posicionJuegoRepositoryJPA.findByName(name);
        if (null == posicionJuegoEntity) {
            return null;
        }
        return posicionJuegoMapper.toDomain(posicionJuegoEntity);
    }

    @Override
    public List<PosicionJuego> getAll() {

        return posicionJuegoRepositoryJPA.findAll()
                .stream()
                .map(posicionJuegoMapper::toDomain)
                .toList()
                ;
    }

    @Override
    public void elimina(PosicionJuego o) {
        posicionJuegoRepositoryJPA.delete(posicionJuegoMapper.toEntity(o));
    }
}
