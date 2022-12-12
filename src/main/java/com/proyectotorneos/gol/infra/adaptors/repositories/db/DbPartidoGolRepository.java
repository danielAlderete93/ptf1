package com.proyectotorneos.gol.infra.adaptors.repositories.db;

import com.proyectotorneos.gol.domain.model.PartidoGol;
import com.proyectotorneos.gol.domain.port.repositories.PartidoGolRepository;
import com.proyectotorneos.gol.infra.adaptors.repositories.PartidoGolRepositoryJPA;
import com.proyectotorneos.posicion.infra.entities.PartidoGolEntity;
import com.proyectotorneos.gol.infra.mapper.PartidoGolMapper;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@Transactional
public class DbPartidoGolRepository implements PartidoGolRepository {
    private final PartidoGolRepositoryJPA partidoGolRepositoryJPA;
    private final PartidoGolMapper partidoGolMapper;

    public DbPartidoGolRepository(PartidoGolRepositoryJPA partidoGolRepositoryJPA, PartidoGolMapper partidoGolMapper) {
        this.partidoGolRepositoryJPA = partidoGolRepositoryJPA;
        this.partidoGolMapper = partidoGolMapper;
    }

    @Override
    public void alta(PartidoGol o) {
        partidoGolRepositoryJPA.saveAndFlush(partidoGolMapper.toEntity(o));
    }

    @Override
    public PartidoGol getById(Integer id) {
        PartidoGolEntity entity;
        entity = partidoGolRepositoryJPA.findById(id).orElseThrow(() -> new ResourceNotFoundException("Recurso no encontrado"));

        return partidoGolMapper.toDomain(entity);
    }

    @Override
    public List<PartidoGol> getAll() {
        List<PartidoGolEntity> entityList;
        entityList = partidoGolRepositoryJPA.findAll();


        return entityList.stream().map(partidoGolMapper::toDomain).toList();
    }

    @Override
    public void elimina(PartidoGol o) {

    }
}
