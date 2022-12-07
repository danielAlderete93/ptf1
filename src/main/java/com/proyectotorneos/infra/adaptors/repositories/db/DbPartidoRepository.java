package com.proyectotorneos.infra.adaptors.repositories.db;

import com.proyectotorneos.domain.model.Partido;
import com.proyectotorneos.domain.port.repositories.PartidoRepository;
import com.proyectotorneos.infra.adaptors.repositories.PartidoRepositoryJPA;
import com.proyectotorneos.infra.entities.PartidoEntity;
import com.proyectotorneos.infra.mappers.PartidoMapper;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@Transactional
public class DbPartidoRepository implements PartidoRepository {

    private final PartidoRepositoryJPA partidoRepositoryJPA;
    private final PartidoMapper partidoMapper;

    public DbPartidoRepository(PartidoRepositoryJPA partidoRepositoryJPA, PartidoMapper partidoMapper) {
        this.partidoRepositoryJPA = partidoRepositoryJPA;
        this.partidoMapper = partidoMapper;
    }

    @Override
    public void alta(Partido o) {
        partidoRepositoryJPA.saveAndFlush(partidoMapper.toEntity(o));
    }

    @Override
    public Partido getById(Integer id) {
        PartidoEntity entity;
        entity = partidoRepositoryJPA.findById(id).orElseThrow(() -> new ResourceNotFoundException("Recurso no encontrado"));

        return partidoMapper.toDomain(entity);
    }

    @Override
    public List<Partido> getAll() {
        List<PartidoEntity> listEntities;
        listEntities = partidoRepositoryJPA.findAll();
        return listEntities.stream().map(partidoMapper::toDomain).toList();
    }

    @Override
    public void elimina(Partido o) {

    }
}
