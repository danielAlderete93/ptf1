package com.proyectotorneos.torneo.infra.repositories.db;

import com.proyectotorneos.torneo.domain.model.Torneo;
import com.proyectotorneos.torneo.domain.port.repositories.TorneoRepository;
import com.proyectotorneos.torneo.infra.entities.TorneoEntity;
import com.proyectotorneos.torneo.infra.mapper.TorneoMapper;
import com.proyectotorneos.torneo.infra.repositories.TorneoRepositoryJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@Transactional
public class DbTorneoRepository implements TorneoRepository {

    private final TorneoRepositoryJPA torneoRepositoryJPA;
    private final TorneoMapper torneoMapper;

    @Autowired
    public DbTorneoRepository(TorneoRepositoryJPA torneoRepositoryJPA, TorneoMapper torneoMapper) {
        this.torneoRepositoryJPA = torneoRepositoryJPA;
        this.torneoMapper = torneoMapper;
    }

    @Override
    public void alta(Torneo o) {
        torneoRepositoryJPA.saveAndFlush(torneoMapper.toEntity(o));
    }

    @Override
    public Torneo getById(Integer id) {
        TorneoEntity entity;
        entity = torneoRepositoryJPA.findById(id).orElseThrow(() -> new ResourceNotFoundException("Recurso no encontrado"));

        return torneoMapper.toDomain(entity);
    }


    @Override
    public List<Torneo> getAll() {
        List<TorneoEntity> listEntities;
        listEntities = torneoRepositoryJPA.findAll();


        return listEntities.stream().map(torneoMapper::toDomain).toList();
    }

    @Override
    public void elimina(Torneo o) {
        torneoRepositoryJPA.delete(torneoMapper.toEntity(o));
    }

}
