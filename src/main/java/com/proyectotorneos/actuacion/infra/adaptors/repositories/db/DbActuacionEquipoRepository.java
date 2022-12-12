package com.proyectotorneos.actuacion.infra.adaptors.repositories.db;

import com.proyectotorneos.actuacion.domain.model.ActuacionEquipo;
import com.proyectotorneos.actuacion.domain.port.repositories.ActuacionEquipoRepository;
import com.proyectotorneos.actuacion.infra.adaptors.repositories.ActuacionEquipoRepositoryJPA;
import com.proyectotorneos.actuacion.infra.entities.ActuacionEquipoEntity;
import com.proyectotorneos.actuacion.infra.mapper.ActuacionMapper;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
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
