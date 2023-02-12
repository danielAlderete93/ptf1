package com.proyectotorneos.publicacion.infra.adaptors.repositories;

import com.proyectotorneos.publicacion.domain.model.Publicacion;
import com.proyectotorneos.publicacion.domain.port.repositories.PublicacionRespository;
import com.proyectotorneos.publicacion.infra.adaptors.PublicacionRepositoryJPA;
import com.proyectotorneos.publicacion.infra.entities.PublicacionEntity;
import com.proyectotorneos.publicacion.infra.mapper.PublicacionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@Transactional
public class DbPublicacionRepositoryJPA implements PublicacionRespository {
    private final PublicacionRepositoryJPA publicacionRepositoryJPA;
    private final PublicacionMapper publicacionMapper;

    @Autowired
    public DbPublicacionRepositoryJPA(PublicacionRepositoryJPA publicacionRepositoryJPA, PublicacionMapper publicacionMapper) {
        this.publicacionRepositoryJPA = publicacionRepositoryJPA;
        this.publicacionMapper = publicacionMapper;
    }

    @Override
    public void alta(Publicacion o) {
        publicacionRepositoryJPA.save(publicacionMapper.toEntity(o));
    }

    @Override
    public Publicacion getById(Integer id) {
        PublicacionEntity entity;
        entity = publicacionRepositoryJPA.findById(id).orElseThrow(() -> new ResourceNotFoundException("Recurso no encontrado"));
        return publicacionMapper.toDomain(entity);
    }


    @Override
    public List<Publicacion> getAll() {
        List<PublicacionEntity> listEntities;
        listEntities = publicacionRepositoryJPA.findAll();


        return listEntities.stream().map(publicacionMapper::toDomain).toList();
    }

    @Override
    public void elimina(Publicacion o) {
        publicacionRepositoryJPA.delete(publicacionMapper.toEntity(o));
    }
}
