package com.proyectotorneos.habilidad.infra.adaptors.repositories.db;

import com.proyectotorneos.habilidad.domain.model.HabilidadJugador;
import com.proyectotorneos.habilidad.domain.port.repositories.HabilidadJugadorRepository;
import com.proyectotorneos.habilidad.infra.adaptors.repositories.HabilidadJugadorRepositoryJPA;
import com.proyectotorneos.habilidad.infra.entities.HabilidadJugadorEntity;
import com.proyectotorneos.habilidad.infra.mapper.HabilidadJugadorMapper;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@Transactional
public class DbHabilidadJugadorRepository implements HabilidadJugadorRepository {

    private final HabilidadJugadorRepositoryJPA habilidadJugadorRepositoryJPA;
    private final HabilidadJugadorMapper habilidadJugadorMapper;


    public DbHabilidadJugadorRepository(HabilidadJugadorRepositoryJPA habilidadJugadorRepositoryJPA, HabilidadJugadorMapper habilidadJugadorMapper) {
        this.habilidadJugadorRepositoryJPA = habilidadJugadorRepositoryJPA;
        this.habilidadJugadorMapper = habilidadJugadorMapper;
    }


    @Override
    public void alta(HabilidadJugador o) {

        this.habilidadJugadorRepositoryJPA.saveAndFlush(habilidadJugadorMapper.toEntity(o));
    }

    @Override
    public HabilidadJugador getById(Integer id) {
        HabilidadJugadorEntity habilidadJugadorEntity;
        habilidadJugadorEntity = habilidadJugadorRepositoryJPA.findById(id).orElseThrow(() -> new ResourceNotFoundException("Recurso no encontrado"));

        return habilidadJugadorMapper.toDomain(habilidadJugadorEntity);
    }

    @Override
    public HabilidadJugador getByName(String name) {
        HabilidadJugadorEntity habilidadJugadorEntity = habilidadJugadorRepositoryJPA.findByName(name);
        if (habilidadJugadorEntity == null) {
            return null;
        }
        return habilidadJugadorMapper.toDomain(habilidadJugadorEntity);
    }

    @Override
    public List<HabilidadJugador> getAll() {
        List<HabilidadJugadorEntity> habilidadJugadorEntity;
        habilidadJugadorEntity = habilidadJugadorRepositoryJPA.findAll();


        return habilidadJugadorEntity.stream().map(habilidadJugadorMapper::toDomain).toList();
    }

    @Override
    public void elimina(HabilidadJugador o) {
        habilidadJugadorRepositoryJPA.delete(habilidadJugadorMapper.toEntity(o));
    }
}
