package com.proyectotorneos.tipo_habilidad.infra.adaptors.repositories.db;

import com.proyectotorneos.tipo_habilidad.domain.model.TipoHabilidad;
import com.proyectotorneos.tipo_habilidad.domain.port.repositories.TipoHabilidadRepository;
import com.proyectotorneos.tipo_habilidad.infra.adaptors.repositories.TipoHabilidadRepositoryJPA;
import com.proyectotorneos.tipo_habilidad.infra.entities.TipoHabilidadEntity;
import com.proyectotorneos.tipo_habilidad.infra.mapper.TipoHabilidadMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@Transactional
public class DbTipoHabilidadRepository implements TipoHabilidadRepository {

    private final TipoHabilidadRepositoryJPA tipoHabilidadRepositoryJPA;
    private final TipoHabilidadMapper tipoHabilidadMapper;

    @Autowired
    public DbTipoHabilidadRepository(TipoHabilidadRepositoryJPA tipoHabilidadRepositoryJPA, TipoHabilidadMapper tipoHabilidadMapper) {
        this.tipoHabilidadRepositoryJPA = tipoHabilidadRepositoryJPA;
        this.tipoHabilidadMapper = tipoHabilidadMapper;
    }


    @Override
    public void alta(TipoHabilidad o) {
        tipoHabilidadRepositoryJPA.saveAndFlush(tipoHabilidadMapper.toEntity(o));
    }

    @Override
    public TipoHabilidad getById(Integer id) {
        TipoHabilidadEntity entity;
        entity = tipoHabilidadRepositoryJPA.findById(id).orElseThrow(() -> new ResourceNotFoundException("Recurso no encontrado"));

        return tipoHabilidadMapper.toDomain(entity);
    }

    @Override
    public TipoHabilidad getByName(String name) {
        TipoHabilidadEntity tipoHabilidadEntity = tipoHabilidadRepositoryJPA.findByName(name);
        if (null == tipoHabilidadEntity) {
            return null;
        }
        return tipoHabilidadMapper.toDomain(tipoHabilidadEntity);
    }

    @Override
    public List<TipoHabilidad> getAll() {
        List<TipoHabilidadEntity> listEntities;
        listEntities = tipoHabilidadRepositoryJPA.findAll();


        return listEntities.stream().map(tipoHabilidadMapper::toDomain).toList();
    }

    @Override
    public void elimina(TipoHabilidad o) {

    }
}
