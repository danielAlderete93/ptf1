package com.proyectotorneos.infra.adaptors.repositories.db;

import com.proyectotorneos.domain.model.Equipo;
import com.proyectotorneos.infra.entities.repositories.EquipoRepository;
import com.proyectotorneos.infra.adaptors.repositories.EquipoRepositoryJPA;
import com.proyectotorneos.infra.entities.EquipoEntity;
import com.proyectotorneos.infra.mappers.EquipoMapper;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class DbEquipoRepository implements EquipoRepository {
    private final EquipoRepositoryJPA equipoRepositoryJPA;
    private final EquipoMapper equipoMapper;


    public DbEquipoRepository(EquipoRepositoryJPA equipoRepositoryJPA, EquipoMapper equipoMapper) {
        this.equipoRepositoryJPA = equipoRepositoryJPA;
        this.equipoMapper = equipoMapper;
    }

    @Override
    public void alta(Equipo equipo) {
        this.equipoRepositoryJPA.saveAndFlush(equipoMapper.toEntity(equipo));
    }

    @Override
    public Equipo getById(Integer id) {
        EquipoEntity equipoEntity;

        equipoEntity = equipoRepositoryJPA.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Recurso no encontrado"));

        return equipoMapper.toDomain(equipoEntity);
    }

    @Override
    public List<Equipo> getAll() {
        List<EquipoEntity> equipoEntityList;
        equipoEntityList = equipoRepositoryJPA.findAll();


        return equipoEntityList.stream()
                .map(equipoMapper::toDomain)
                .toList()
                ;
    }

    @Override
    public void elimina(Equipo o) {

    }
}
