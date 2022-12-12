package com.proyectotorneos.fecha.infra.adaptors.repositories.db;

import com.proyectotorneos.fecha.domain.model.FechaCompetitiva;
import com.proyectotorneos.fecha.infra.adaptors.repositories.FechaCompetitivaRepositoryJPA;
import com.proyectotorneos.fecha.infra.entities.FechaCompetitivaEntity;
import com.proyectotorneos.fecha.domain.port.repositories.FechaCompetitivaRepository;
import com.proyectotorneos.fecha.infra.mapper.FechaCompetitivaMapper;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@Transactional
public class DbFechaCompetitivaRepository implements FechaCompetitivaRepository {

    private final FechaCompetitivaRepositoryJPA fechaCompetitivaRepositoryJPA;
    private final FechaCompetitivaMapper fechaCompetitivaMapper;

    public DbFechaCompetitivaRepository(FechaCompetitivaRepositoryJPA fechaCompetitivaRepositoryJPA, FechaCompetitivaMapper fechaCompetitivaMapper) {
        this.fechaCompetitivaRepositoryJPA = fechaCompetitivaRepositoryJPA;
        this.fechaCompetitivaMapper = fechaCompetitivaMapper;
    }

    @Override
    public void alta(FechaCompetitiva fechaCompetitiva) {
        this.fechaCompetitivaRepositoryJPA.saveAndFlush(fechaCompetitivaMapper.toEntity(fechaCompetitiva));
    }

    @Override
    public FechaCompetitiva getById(Integer id) {
        FechaCompetitivaEntity entity;
        entity = fechaCompetitivaRepositoryJPA.findById(id).orElseThrow(() -> new ResourceNotFoundException("Recurso no encontrado"));

        return fechaCompetitivaMapper.toDomain(entity);
    }

    @Override
    public List<FechaCompetitiva> getAll() {
        List<FechaCompetitivaEntity> entityList;
        entityList = fechaCompetitivaRepositoryJPA.findAll();

        return entityList.stream().map(fechaCompetitivaMapper::toDomain).toList();
    }

    @Override
    public void elimina(FechaCompetitiva o) {

    }
}
