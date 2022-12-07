package com.proyectotorneos.infra.adaptors.repositories.db;

import com.proyectotorneos.domain.model.ActuacionEquipo;
import com.proyectotorneos.domain.port.repositories.ActuacionEquipoRepository;
import com.proyectotorneos.infra.adaptors.repositories.ActuacionEquipoRepositoryJPA;
import com.proyectotorneos.infra.entities.ActuacionEquipoEntity;
import com.proyectotorneos.infra.mappers.ActuacionMapper;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional
public class DbActuacionEquipoRepository implements ActuacionEquipoRepository {

    private final ActuacionEquipoRepositoryJPA actuacionEquipoRepositoryJPA;
    private final ActuacionMapper actuacionMapper;


    public DbActuacionEquipoRepository(ActuacionEquipoRepositoryJPA actuacionEquipoRepositoryJPA, ActuacionMapper actuacionMapper) {
        this.actuacionEquipoRepositoryJPA = actuacionEquipoRepositoryJPA;
        this.actuacionMapper = actuacionMapper;
    }


    @Override
    public ActuacionEquipo getById(Integer id) {
        ActuacionEquipoEntity entity;
        entity = actuacionEquipoRepositoryJPA.findById(id).orElseThrow(() -> new ResourceNotFoundException("Recurso no encontrado"));

        return actuacionMapper.toDomain(entity);
    }


    @Override
    public void elimina(ActuacionEquipo o) {

    }
}
